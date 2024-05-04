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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// This class manages a graph that models a network of towns connected by roads.
public class TownGraphManager implements TownGraphManagerInterface {
    private Graph graph; // The graph where towns and roads are stored

    // Constructor initializes a new graph instance
    public TownGraphManager() {
        this.graph = new Graph();
    }

    // Adds a road between two towns. Creates towns if they don't exist.
    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        Town source = getTown(town1);  // Retrieve or create the source town
        if (source == null) {
            source = new Town(town1);
            graph.addVertex(source);
        }

        Town destination = getTown(town2);  // Retrieve or create the destination town
        if (destination == null) {
            destination = new Town(town2);
            graph.addVertex(destination);
        }

        // Add a road between the source and destination towns
        return graph.addEdge(source, destination, weight, roadName) != null;
    }

    // Retrieves the road name between two towns if it exists
    @Override
    public String getRoad(String town1, String town2) {
        Town source = new Town(town1);
        Town destination = new Town(town2);
        Road road = graph.getEdge(source, destination);
        return road == null ? null : road.getName();
    }

    // Adds a new town to the graph
    @Override
    public boolean addTown(String v) {
        Town newTown = new Town(v);
        return graph.addVertex(newTown);
    }

    // Retrieves a town by name if it exists in the graph
    @Override
    public Town getTown(String name) {
        Set<Town> towns = graph.vertexSet();
        for (Town town : towns) {
            if (town.getName().equals(name)) {
                return town;
            }
        }
        return null;
    }

    // Checks if a town exists in the graph
    @Override
    public boolean containsTown(String v) {
        Town town = new Town(v);
        return graph.containsVertex(town);
    }

    // Checks if a road connection exists between two specified towns
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        Town source = new Town(town1);
        Town destination = new Town(town2);
        return graph.containsEdge(source, destination);
    }

    // Returns a list of all road names in alphabetical order
    @Override
    public ArrayList<String> allRoads() {
        Set<Road> roads = graph.edgeSet();
        ArrayList<String> roadNames = new ArrayList<>();
        for (Road road : roads) {
            roadNames.add(road.getName());
        }
        Collections.sort(roadNames);
        return roadNames;
    }

    // Deletes a road between two towns
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Town source = new Town(town1);
        Town destination = new Town(town2);
        Road r = graph.getEdge(source, destination);
        if (r != null && r.getName().equals(road)) {
            graph.removeEdge(source, destination, r.getWeight(), road);
            return true;
        }
        return false;
    }

    // Deletes a town and any connected roads from the graph
    @Override
    public boolean deleteTown(String v) {
        Town town = new Town(v);
        return graph.removeVertex(town);
    }

    // Returns a list of all town names in alphabetical order
    @Override
    public ArrayList<String> allTowns() {
        Set<Town> towns = graph.vertexSet();
        ArrayList<String> townNames = new ArrayList<>();
        for (Town town : towns) {
            townNames.add(town.getName());
        }
        Collections.sort(townNames);
        return townNames;
    }

    // Finds the shortest path between two towns using Dijkstra's algorithm
    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        Town source = getTown(town1);
        Town destination = getTown(town2);

        if (source == null || destination == null) {
            return new ArrayList<>();  // Return empty list if one of the towns doesn't exist
        }

        graph.dijkstraShortestPath(source);
        return graph.shortestPath(source, destination);
    }

    // Populates the graph with data from a file
    public void populateTownGraph(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] details = line.split(";");
            String[] roadInfo = details[0].split(",");
            String roadName = roadInfo[0];
            int distance = Integer.parseInt(roadInfo[1]);
            String town1 = details[1];
            String town2 = details[2];

            addTown(town1);
            addTown(town2);
            addRoad(town1, town2, distance, roadName);
        }
        scanner.close();
    }
}
