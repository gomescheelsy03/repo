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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Graph_STUDENT_Test {
    private GraphInterface<Town, Road> graph;
    private Town[] towns;

    @Before
    public void setUp() throws Exception {
        graph = new Graph();
        towns = new Town[6]; // Using a smaller set for simplicity

        // Adding towns
        for (int i = 1; i <= 5; i++) {
            towns[i] = new Town("Town" + i);
            graph.addVertex(towns[i]);
        }

        // Adding roads
        graph.addEdge(towns[1], towns[2], 10, "RoadA");
        graph.addEdge(towns[2], towns[3], 15, "RoadB");
        graph.addEdge(towns[3], towns[4], 20, "RoadC");
        graph.addEdge(towns[4], towns[5], 25, "RoadD");
        graph.addEdge(towns[5], towns[1], 30, "RoadE");
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
    }

    // Test to check the correct edge is retrieved
    @Test
    public void testGetEdge() {
        assertEquals(new Road(towns[1], towns[2], 10, "RoadA"), graph.getEdge(towns[1], towns[2]));
        assertNull("Edge should not exist", graph.getEdge(towns[1], towns[3]));
    }

    // Test addition of an edge
    @Test
    public void testAddEdge() {
        assertFalse(graph.containsEdge(towns[2], towns[5]));
        graph.addEdge(towns[2], towns[5], 35, "RoadF");
        assertTrue(graph.containsEdge(towns[2], towns[5]));
    }

    // Test addition of a vertex
    @Test
    public void testAddVertex() {
        Town newTown = new Town("Town6");
        assertFalse(graph.containsVertex(newTown));
        graph.addVertex(newTown);
        assertTrue(graph.containsVertex(newTown));
    }

    // Test if an edge exists
    @Test
    public void testContainsEdge() {
        assertTrue(graph.containsEdge(towns[1], towns[2]));
        assertFalse(graph.containsEdge(towns[2], towns[5])); // No direct edge between Town2 and Town5
    }

    // Test if a vertex exists
    @Test
    public void testContainsVertex() {
        assertTrue(graph.containsVertex(new Town("Town2")));
        assertFalse(graph.containsVertex(new Town("Town7"))); // Town7 was not added
    }

    // Test getting the complete set of edges
    @Test
    public void testEdgeSet() {
        Set<Road> roads = graph.edgeSet();
        assertEquals(5, roads.size()); // Check if all roads are present
    }

    // Test getting edges of a specific town
    @Test
    public void testEdgesOf() {
        Set<Road> roads = graph.edgesOf(towns[1]);
        assertEquals(2, roads.size()); // Town1 is connected by RoadA and RoadE
    }

    // Test removal of an edge
    @Test
    public void testRemoveEdge() {
        assertTrue(graph.containsEdge(towns[1], towns[2]));
        graph.removeEdge(towns[1], towns[2], 10, "RoadA");
        assertFalse(graph.containsEdge(towns[1], towns[2]));
    }

    // Test removal of a vertex
    @Test
    public void testRemoveVertex() {
        assertTrue(graph.containsVertex(towns[3]));
        graph.removeVertex(towns[3]);
        assertFalse(graph.containsVertex(towns[3]));
    }

    // Test getting all vertices
    @Test
    public void testVertexSet() {
        Set<Town> vertices = graph.vertexSet();
        assertEquals(5, vertices.size()); // Ensure all towns are present
    }

    // Example tests for shortest path
    @Test
    public void testShortestPath() {
        ArrayList<String> path = graph.shortestPath(towns[1], towns[4]);
        assertNotNull("Path should not be null", path);
        assertTrue("Path should have steps", path.size() > 0);
        assertEquals("Town1 via RoadA to Town2 10 mi", path.get(0).trim());
        assertEquals("Town2 via RoadB to Town3 15 mi", path.get(1).trim());
        assertEquals("Town3 via RoadC to Town4 20 mi", path.get(2).trim());
    }
}
