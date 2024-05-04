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
import org.junit.Test;

public class Road_STUDENT_Test {
    private Road road;
    private Town town1;
    private Town town2;

    @Before
    public void setUp() throws Exception {
        town1 = new Town("Town1");
        town2 = new Town("Town2");
        road = new Road(town1, town2, 10, "RoadName");
    }

    @Test
    public void testGetTown1() {
        assertEquals(town1, road.getTown1());
    }

    @Test
    public void testGetTown2() {
        assertEquals(town2, road.getTown2());
    }

    @Test
    public void testGetName() {
        assertEquals("RoadName", road.getName());
    }

    @Test
    public void testGetDistance() {
        assertEquals(10, road.getDistance());
    }

    @Test
    public void testToString() {
        String expected = "RoadName, 10 miles; Town1; Town2";
        assertEquals(expected, road.toString());
    }

    @Test
    public void testCompareTo_SameRoad() {
        Road sameRoad = new Road(town1, town2, 10, "RoadName");
        assertEquals(0, road.compareTo(sameRoad));
    }

    @Test
    public void testCompareTo_DifferentRoad() {
        Road differentRoad = new Road(town1, town2, 20, "AnotherRoad");
        assertTrue(road.compareTo(differentRoad) != 0);
    }

    @Test
    public void testEquals_SameRoad() {
        Road sameRoad = new Road(town1, town2, 10, "RoadName");
        assertTrue(road.equals(sameRoad));
    }

    @Test
    public void testEquals_DifferentRoad() {
        Road differentRoad = new Road(town1, town2, 20, "AnotherRoad");
        assertFalse(road.equals(differentRoad));
    }

    @Test
    public void testHashCode() {
        Road sameRoad = new Road(town1, town2, 10, "RoadName");
        assertEquals(road.hashCode(), sameRoad.hashCode());

        Road differentRoad = new Road(town1, town2, 20, "AnotherRoad");
        assertNotEquals(road.hashCode(), differentRoad.hashCode());
    }
}
