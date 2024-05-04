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
import java.util.ArrayList;

public class TownGraphManager_STUDENT_Test {
    private TownGraphManagerInterface graph;
    private String[] towns;

    @Before
    public void setUp() throws Exception {
        graph = new TownGraphManager();
        towns = new String[6]; // Smaller set of towns for testing

        for (int i = 1; i <= 5; i++) {
            towns[i] = "SmallTown_" + i;
            graph.addTown(towns[i]);
        }

        graph.addRoad(towns[1], towns[2], 3, "TinyRoad_1");
        graph.addRoad(towns[2], towns[3], 5, "TinyRoad_2");
        graph.addRoad(towns[3], towns[4], 4, "TinyRoad_3");
        graph.addRoad(towns[4], towns[5], 6, "TinyRoad_4");
        graph.addRoad(towns[5], towns[1], 7, "TinyRoad_5");
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
    }

    @Test
    public void testAddRoad() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("TinyRoad_1", roads.get(0));
        graph.addRoad(towns[1], towns[3], 9, "TinyRoad_6");
        roads = graph.allRoads();
        assertTrue(roads.contains("TinyRoad_6"));
    }

    @Test
    public void testGetRoad() {
        assertEquals("TinyRoad_2", graph.getRoad(towns[2], towns[3]));
    }

    @Test
    public void testAddTown() {
        assertFalse(graph.containsTown("SmallTown_6"));
        graph.addTown("SmallTown_6");
        assertTrue(graph.containsTown("SmallTown_6"));
    }

    @Test
    public void testContainsTown() {
        assertTrue(graph.containsTown("SmallTown_2"));
        assertFalse(graph.containsTown("SmallTown_7"));
    }

    @Test
    public void testContainsRoadConnection() {
        assertTrue(graph.containsRoadConnection(towns[2], towns[3]));
        assertFalse(graph.containsRoadConnection(towns[1], towns[4]));
    }

    @Test
    public void testAllRoads() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals(5, roads.size());
        assertTrue(roads.contains("TinyRoad_4"));
    }

    @Test
    public void testDeleteRoadConnection() {
        assertTrue(graph.containsRoadConnection(towns[2], towns[3]));
        graph.deleteRoadConnection(towns[2], towns[3], "TinyRoad_2");
        assertFalse(graph.containsRoadConnection(towns[2], towns[3]));
    }

    @Test
    public void testDeleteTown() {
        assertTrue(graph.containsTown("SmallTown_3"));
        graph.deleteTown("SmallTown_3");
        assertFalse(graph.containsTown("SmallTown_3"));
    }

    @Test
    public void testAllTowns() {
        ArrayList<String> townList = graph.allTowns();
        assertEquals(5, townList.size());
        assertTrue(townList.contains("SmallTown_1"));
    }

    @Test
    public void testGetPath() {
        ArrayList<String> path = graph.getPath(towns[1], towns[4]);
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals("SmallTown_1 via TinyRoad_1 to SmallTown_2 3 mi", path.get(0).trim());
        assertEquals("SmallTown_2 via TinyRoad_2 to SmallTown_3 5 mi", path.get(1).trim());
        assertEquals("SmallTown_3 via TinyRoad_3 to SmallTown_4 4 mi", path.get(2).trim());
    }
}

