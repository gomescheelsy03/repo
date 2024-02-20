/*
 * Class: CMSC204
 * Instructor: Gary Thai 
 * Description: 03/10/2024
 * Due: 02/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class BasicDoubleLinkedList_STUDENT_Test {
    BasicDoubleLinkedList<String> list;
    StringComparator comparator;

    @Before
    public void setUp() throws Exception {
        list = new BasicDoubleLinkedList<>();
        list.addToEnd("Hello");
        list.addToFront("World");
        comparator = new StringComparator();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testAddToEnd() {
        assertEquals("Hello", list.getLast());
        list.addToEnd("End");
        assertEquals("End", list.getLast());
    }

    @Test
    public void testAddToFront() {
        assertEquals("World", list.getFirst());
        list.addToFront("Start");
        assertEquals("Start", list.getFirst());
    }

    @Test
    public void testGetFirst() {
        assertEquals("World", list.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals("Hello", list.getLast());
    }

    @Test
    public void testGetSize() {
        assertEquals(2, list.getSize());
    }

    @Test
    public void testRemove() {
        list.addToEnd("Test");
        assertEquals(3, list.getSize());
        list.remove("Hello", comparator); 
        assertEquals(2, list.getSize());
        assertNotNull(list.remove("Non-existent", comparator)); 
    }


    @Test
    public void testRetrieveFirstElement() {
        assertEquals("World", list.retrieveFirstElement());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testRetrieveLastElement() {
        assertEquals("Hello", list.retrieveLastElement());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testIteratorSuccessfulNext() {
        ListIterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("World", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Hello", iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementException() {
        ListIterator<String> iterator = list.iterator();
        while (true) {
            iterator.next();
        }
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        ListIterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        assertTrue(iterator.hasPrevious());
        assertEquals("Hello", iterator.previous());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementExceptionPrevious() {
        ListIterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        while (true) {
            iterator.previous();
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue("New list should be empty", new BasicDoubleLinkedList<>().isEmpty());
        assertFalse("List with elements should not be empty", list.isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        ListIterator<String> iterator = list.iterator();
        iterator.next();
        iterator.remove();
    }


    @Test
    public void testToArrayList() {
        ArrayList<String> testList = list.toArrayList();
        assertEquals("World", testList.get(0));
        assertEquals("Hello", testList.get(1));
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
