/*
 * Class: CMSC204 
 * Instructor: Gary Thai
 * Due: 05/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Chelsy Gomes_____
*/

package application;

import java.util.*;

// Class representing a graph that contains towns (vertices) and roads (edges)
public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> towns; // Holds all the towns in the graph
    private Set<Road> roads; // Holds all the roads in the graph

    // Constructor to initialize the graph with empty sets for towns and roads
    public Graph() {
        towns = new HashSet<>();
        roads = new HashSet<>();
    }

    // Returns the road (edge) connecting two towns (vertices), if it exists
    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        for (Road road : roads) {
            // Check both possible directions since the graph is undirected
            if ((road.getTown1().equals(sourceVertex) && road.getTown2().equals(destinationVertex)) ||
                (road.getTown1().equals(destinationVertex) && road.getTown2().equals(sourceVertex))) {
                return road;
            }
        }
        return null; // No road found
    }

    // Adds a road connecting two existing towns in the graph
    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) {
            throw new IllegalArgumentException("Both towns must be in the graph");
        }
        Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
        if (containsEdge(sourceVertex, destinationVertex)) {
            return null; // Prevents adding duplicate roads
        }
        roads.add(newRoad); // Add the new road to the set
        sourceVertex.addAdjacentTown(destinationVertex); // Link the towns bi-directionally
        destinationVertex.addAdjacentTown(sourceVertex);
        return newRoad;
    }

    // Adds a town to the graph
    @Override
    public boolean addVertex(Town v) {
        return towns.add(v);
    }

    // Checks if a specific road connecting two towns exists in the graph
    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        return roads.stream().anyMatch(r -> 
            (r.getTown1().equals(sourceVertex) && r.getTown2().equals(destinationVertex)) ||
            (r.getTown1().equals(destinationVertex) && r.getTown2().equals(sourceVertex)));
    }

    // Checks if a town is in the graph
    @Override
    public boolean containsVertex(Town v) {
        return towns.contains(v);
    }

    // Returns a set of all roads in the graph
    @Override
    public Set<Road> edgeSet() {
        return new HashSet<>(roads);
    }

    // Returns a set of all roads connected to a given town
    @Override
    public Set<Road> edgesOf(Town vertex) {
        Set<Road> edges = new HashSet<>();
        for (Road road : roads) {
            if (road.getTown1().equals(vertex) || road.getTown2().equals(vertex)) {
                edges.add(road);
            }
        }
        return edges;
    }

    // Removes a road from the graph
    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road road = getEdge(sourceVertex, destinationVertex);
        if (road != null && road.getDistance() == weight && road.getName().equals(description)) {
            roads.remove(road); // Remove the road
            // Disconnect the towns from each other
            sourceVertex.getAdjacentTowns().remove(destinationVertex);
            destinationVertex.getAdjacentTowns().remove(sourceVertex);
            return road;
        }
        return null;
    }

    // Removes a town from the graph, along with any connected roads
    @Override
    public boolean removeVertex(Town v) {
        boolean removed = towns.remove(v);
        if (removed) {
            // Remove all roads connected to the town
            roads.removeIf(road -> road.getTown1().equals(v) || road.getTown2().equals(v));
            // Remove this town from the adjacency lists of all other towns
            for (Town town : towns) {
                town.getAdjacentTowns().remove(v);
            }
        }
        return removed;
    }

    // Returns a set of all towns in the graph
    @Override
    public Set<Town> vertexSet() {
        return new HashSet<>(towns);
    }

    // Calculates the shortest path from sourceVertex to destinationVertex using Dijkstra's algorithm
    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        dijkstraShortestPath(sourceVertex);
        List<Town> path = new ArrayList<>();
        Town step = destinationVertex;

        // Check if a path exists
        if (destinationVertex.getPrevious() == null) {
            return new ArrayList<>();
        }

        // Construct the path by walking backwards from the destination
        while (step != null && !step.equals(sourceVertex)) {
            path.add(step);
            step = step.getPrevious();
        }
        path.add(sourceVertex); // add the source at the end

        Collections.reverse(path); // reverse to start from the source

        ArrayList<String> paths = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            Road connectingRoad = getEdge(path.get(i), path.get(i + 1));
            // Formulating the description for each step in the path
            String stepDescription = String.format("%s via %s to %s %d mi",
                                                   path.get(i).getName(),
                                                   connectingRoad.getName(),
                                                   path.get(i + 1).getName(),
                                                   connectingRoad.getDistance());
            paths.add(stepDescription);
        }

        return paths;
    }

    // Implementation of Dijkstra's algorithm to calculate the shortest paths from a single source town to all other towns
    @Override
    public void dijkstraShortestPath(Town sourceVertex) {
        for (Town town : towns) {
            town.setDistance(Integer.MAX_VALUE); // Set initial distance to infinity
            town.setPrevious(null); // Reset the previous town reference
        }
        sourceVertex.setDistance(0); // Set distance of the source town to 0

        PriorityQueue<Town> townQueue = new PriorityQueue<>(Comparator.comparingInt(Town::getDistance));
        townQueue.add(sourceVertex); // Start with the source town

        while (!townQueue.isEmpty()) {
            Town current = townQueue.poll(); // Get the town with the shortest distance

            for (Town neighbor : current.getAdjacentTowns()) {
                Road road = getEdge(current, neighbor);
                int distanceThroughCurrent = current.getDistance() + road.getDistance();
                if (distanceThroughCurrent < neighbor.getDistance()) {
                    neighbor.setDistance(distanceThroughCurrent); // Update distance if a shorter path is found
                    neighbor.setPrevious(current); // Set current town as the previous town in the path
                    // Reorder the priority queue with the new distance
                    townQueue.remove(neighbor);
                    townQueue.add(neighbor);
                }
            }
        }
    }
}
