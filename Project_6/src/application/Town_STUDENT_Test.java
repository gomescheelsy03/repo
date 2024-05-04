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
import java.util.ArrayList;

public class Town_STUDENT_Test {
    private Town town1;
    private Town town2;
    private Town town3;

    @Before
    public void setUp() throws Exception {
        town1 = new Town("Town1");
        town2 = new Town("Town2");
        town3 = new Town("Town3");
    }

    @Test
    public void testGetName() {
        assertEquals("Town1", town1.getName());
    }

    @Test
    public void testSetName() {
        town1.setName("NewTown1");
        assertEquals("NewTown1", town1.getName());
    }

    @Test
    public void testAddAndGetAdjacentTowns() {
        town1.addAdjacentTown(town2);
        town1.addAdjacentTown(town3);
        ArrayList<Town> adjacentTowns = town1.getAdjacentTowns();

        assertTrue(adjacentTowns.contains(town2));
        assertTrue(adjacentTowns.contains(town3));
        assertEquals(2, adjacentTowns.size());
    }

    @Test
    public void testToString() {
        assertEquals("Town{name='Town1'}", town1.toString());
    }

    @Test
    public void testCompareTo() {
        assertEquals(0, town1.compareTo(new Town("Town1")));
        assertTrue(town1.compareTo(town2) < 0);
        assertTrue(town2.compareTo(town1) > 0);
    }

    @Test
    public void testEquals() {
        assertTrue(town1.equals(new Town("Town1")));
        assertFalse(town1.equals(town2));
    }

    @Test
    public void testHashCode() {
        assertEquals(town1.hashCode(), new Town("Town1").hashCode());
        assertNotEquals(town1.hashCode(), town2.hashCode());
    }

    @Test
    public void testSetAndGetPrevious() {
        town1.setPrevious(town2);
        assertEquals(town2, town1.getPrevious());
    }

    @Test
    public void testSetAndGetDistance() {
        town1.setDistance(100);
        assertEquals(100, town1.getDistance());
    }
}

