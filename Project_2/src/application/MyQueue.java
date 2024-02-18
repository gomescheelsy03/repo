/*
 * Class: CMSC204
 * Instructor: Gary Thai 
 * Description: Implements a generic queue data structure using an array. This class supports basic queue operations such as enqueue (add an element), dequeue (remove an element), and checks for empty/full states, along with methods to get the size of the queue and to convert the queue content to a String. 
 * Due: 02/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

import java.util.*;

/**
 * Implementation of a generic queue class called MyQueue.
 * MyQueue will implement the QueueInterface.
 * @author Chelsy Gomes
 */
public class MyQueue<T> implements QueueInterface<T> {

    protected T[] q; // Array to store queue elements
    protected int front, rear, capacity, len; // Trackers for front and rear of the queue, its capacity, and current length

    /**
     * Constructor to initialize the queue with a specific size.
     * @param n The size of the queue.
     */
    public MyQueue(int n) {
        capacity = n;
        len = 0; // Initialize current length as 0
        q = (T[]) new Object[capacity]; // Type-safe array due to casting
        front = -1; // Initialize front and rear pointers
        rear = -1;
    }

    /**
     * Default constructor with default capacity.
     */
    public MyQueue() {
        // Student note: Set default capacity to 20
        this(20);
    }

    /**
     * Checks if the queue is empty.
     * @return true if queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks if the queue is full.
     * @return true if queue is full, false otherwise.
     */
    @Override
    public boolean isFull() {
        // Full condition check
        return front == 0 && rear == capacity - 1;
    }

    /**
     * Removes and returns the front element of the queue.
     * @return The element at the front of the queue.
     * @throws QueueUnderflowException If the queue is empty.
     */
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Underflow Exception");
        }
        T ele = q[front];
        if (front == rear) {
            // Queue has become empty
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        len--;
        return ele;
    }

    /**
     * Returns the number of elements in the queue.
     * @return The size of the queue.
     */
    @Override
    public int size() {
        return len;
    }

    /**
     * Adds an element to the rear of the queue.
     * @param e The element to add.
     * @return true if the operation is successful.
     * @throws QueueOverflowException If the queue is full.
     */
    @Override
    public boolean enqueue(T e) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Overflow Exception");
        }
        if (rear == -1) {
            // Queue is initially empty
            front = 0;
            rear = 0;
        } else {
            rear++;
        }
        q[rear] = e;
        len++;
        return true;
    }

    /**
     * Returns a string representation of the queue's elements separated by a delimiter.
     * @param delimiter The delimiter to separate queue elements.
     * @return A string containing all elements in the queue, separated by the delimiter.
     */
    @Override
    public String toString(String delimiter) {
        StringBuilder s = new StringBuilder();
        for (int i = front; i <= rear; i++) {
            s.append(q[i].toString());
            if (i < rear) {
                s.append(delimiter);
            }
        }
        return s.toString();
    }
    
    /**
     * Returns a string representation of the queue's elements without a delimiter.
     * @return A string containing all elements in the queue.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = front; i <= rear; i++) {
            s.append(q[i].toString());
        }
        return s.toString();
    }

    /**
     * Fills the queue with elements from an ArrayList, resetting the queue before doing so.
     * @param list The list of elements to add to the queue.
     */
    @Override
    public void fill(ArrayList<T> list) {
        len = 0; // Reset current length
        q = (T[]) new Object[capacity]; // Reinitialize the queue
        front = -1; // Reset front and rear pointers
        rear = -1;
        for (T t : list) {
            try {
                enqueue(t);
            } catch (QueueOverflowException ex) {
                System.out.println(ex.toString()); // Handle potential overflow
            }
        }
    }
}
