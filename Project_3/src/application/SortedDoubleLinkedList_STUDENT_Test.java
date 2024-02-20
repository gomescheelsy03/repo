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
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import java.util.ArrayList;


public class SortedDoubleLinkedList_STUDENT_Test {
    private SortedDoubleLinkedList<String> list;
    private StringComparator comparator;

    @Before
    public void setUp() throws Exception {
        comparator = new StringComparator();
        list = new SortedDoubleLinkedList<>(comparator);
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testAdd() {
        list.add("Charlie");
        list.add("Bravo");
        list.add("Delta");
        list.add("Alpha");
        assertEquals(4, list.getSize());
        assertEquals("Alpha", list.getFirst());
        assertEquals("Delta", list.getLast());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddToFront() {
        list.addToFront("Echo");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddToEnd() {
        list.addToEnd("Echo");
    }

    @Test
    public void testRemove() {
        list.add("Bravo");
        list.add("Charlie");
        list.remove("Bravo", comparator);
        assertEquals(1, list.getSize());
    }

    @Test
    public void testRetrieveFirstElement() {
        list.add("Charlie");
        list.add("Bravo");
        assertEquals("Bravo", list.retrieveFirstElement());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testRetrieveLastElement() {
        list.add("Charlie");
        list.add("Delta");
        assertEquals("Delta", list.retrieveLastElement());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testIterator() {
        list.add("Charlie");
        list.add("Echo");
        list.add("Delta");
        ListIterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Charlie", iterator.next());
        assertEquals("Delta", iterator.next());
        assertEquals("Echo", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementExceptionNext() {
        ListIterator<String> iterator = list.iterator();
        iterator.next(); 
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementExceptionPrevious() {
        ListIterator<String> iterator = list.iterator();
        iterator.previous(); 
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorUnsupportedOperationExceptionRemove() {
        list.add("Test"); 
        ListIterator<String> iterator = list.iterator();
        iterator.next(); 
        iterator.remove(); 
    }


    @Test
    public void testToArrayList() {
        list.add("Bravo");
        list.add("Delta");
        list.add("Charlie");
        ArrayList<String> testList = list.toArrayList();
        assertEquals("Bravo", testList.get(0));
        assertEquals("Charlie", testList.get(1));
        assertEquals("Delta", testList.get(2));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("Bravo");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, list.getSize());
        list.add("Alpha");
        list.add("Bravo");
        assertEquals(2, list.getSize());
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }
}
