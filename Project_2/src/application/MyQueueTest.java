
package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MyQueue.
 * Modifications made by Chelsy Gomes.
 */

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests

	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() throws QueueUnderflowException {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
		catch (QueueUnderflowException e){
			assertTrue(true, "This should have caused an QueueUnderflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
	}
	
	@Test
	public void testDequeueStudent() {
// Student modification: Test dequeue functionality for Double type
	    doubleQ = new MyQueue<Double>(5);
	    try {
	        doubleQ.enqueue(1.0);
	        doubleQ.enqueue(2.0);
	        doubleQ.enqueue(3.0);

	        assertEquals(Double.valueOf(1.0), doubleQ.dequeue());
	        assertEquals(Double.valueOf(2.0), doubleQ.dequeue());
	        assertEquals(Double.valueOf(3.0), doubleQ.dequeue());

	        // Now the queue should be empty; trying to dequeue should throw an exception
	        doubleQ.dequeue();
	        fail("Expected a QueueUnderflowException to be thrown");
	    } catch (QueueUnderflowException e) {
	        assertTrue(true); // This is expected.
	    } catch (Exception e) {
	        fail("Expected a QueueUnderflowException, but another exception was thrown");
	    }
	}


	@Test
	public void testSize() throws QueueOverflowException, QueueUnderflowException {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
		catch (QueueOverflowException e){
			assertTrue(true, "This should have caused an QueueOverflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
	}

	@Test
	public void testEnqueueStudent() {
// Student modification: Test enqueue functionality for Double type
	    doubleQ = new MyQueue<Double>(3); 
	    try {
	        assertTrue(doubleQ.enqueue(1.0));
	        assertTrue(doubleQ.enqueue(2.0));
	        assertTrue(doubleQ.enqueue(3.0));

	        // The queue is now full; trying to enqueue another item should throw an exception
	        doubleQ.enqueue(4.0);
	        fail("Expected a QueueOverflowException to be thrown");
	    } catch (QueueOverflowException e) {
	        assertTrue(true); // This is expected.
	    } catch (Exception e) {
	        fail("Expected a QueueOverflowException, but another exception was thrown");
	    }
	}


	@Test
	public void testIsFull() throws QueueOverflowException {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() throws QueueOverflowException {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
	public void testToStringStudent() {
// Student modification: Test toString functionality for Double type
	    doubleQ = new MyQueue<Double>(5);
	    try {
	        doubleQ.enqueue(1.0);
	        doubleQ.enqueue(2.0);
	        doubleQ.enqueue(3.0);

	        String expected = "1.02.03.0";
	        assertEquals(expected, doubleQ.toString());

	        // Test with delimiter
	        String expectedDelimited = "1.0,2.0,3.0";
	        assertEquals(expectedDelimited, doubleQ.toString(","));
	    } catch (Exception e) {
	        fail("An unexpected exception was thrown");
	    }
	}


	@Test
	public void testToStringDelimiter() throws QueueOverflowException {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() throws QueueOverflowException, QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}
