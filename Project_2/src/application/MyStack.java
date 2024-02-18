/*
 * Class: CMSC204
 * Instructor: Gary Thai 
 * Description: Implements a generic stack data structure also using an array. It supports typical stack operations including push (add an element), pop (remove an element), and checks for the stack being empty or full. Additionally, it can return the stack's size and represent the stack's contents as a String.  
 * Due: 02/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Chelsy Gomes_________
*/

package application;

import java.util.ArrayList;

/**
 * Implementation of a generic stack data structure.
 * @author Chelsy Gomes
 */
public class MyStack<T> implements StackInterface<T> {

    // Use Object array for generic storage
    private Object[] arr;
    private int size; // Maximum size of the stack
    private int index; // Current top index of the stack

    /**
     * Constructor to initialize stack with a specific size.
     * @param size The maximum size of the stack.
     */
    public MyStack(int size) {
        this.size = size;
        arr = new Object[size];
        index = 0; // Stack starts empty
    }

    /**
     * Default constructor with default size.
     */
    public MyStack() {
        // Student note: Default size set to 20
        this(20);
    }

    /**
     * Checks if the stack is empty.
     * @return true if stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    /**
     * Checks if the stack is full.
     * @return true if stack is full, false otherwise.
     */
    @Override
    public boolean isFull() {
        return index == size;
    }

    /**
     * Removes and returns the top element of the stack.
     * @return The top element of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Empty Stack!");
        }
        @SuppressWarnings("unchecked")
        T element = (T) arr[--index];
        arr[index] = null; // Help with garbage collection
        return element;
    }

    /**
     * Returns the top element of the stack without removing it.
     * @return The top element of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    @Override
    public T top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Empty Stack!");
        }
        @SuppressWarnings("unchecked")
        T element = (T) arr[index - 1];
        return element;
    }

    /**
     * Returns the current number of elements in the stack.
     * @return The size of the stack.
     */
    @Override
    public int size() {
        return index;
    }

    /**
     * Adds an element to the top of the stack.
     * @param e The element to add.
     * @return true if the operation is successful.
     * @throws StackOverflowException If the stack is full.
     */
    @Override
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("Stack is full");
        }
        arr[index++] = e;
        return true;
    }

    /**
     * Returns a string representation of the stack's elements.
     * @return A string containing all elements in the stack.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < index; i++) {
            s.append(arr[i].toString());
        }
        return s.toString();
    }

    /**
     * Returns a string representation of the stack's elements separated by a delimiter.
     * @param delimiter The delimiter to separate stack elements.
     * @return A string containing all elements in the stack, separated by the delimiter.
     */
    @Override
    public String toString(String delimiter) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < index; i++) {
            s.append(arr[i].toString());
            if (i != index - 1) {
                s.append(delimiter);
            }
        }
        return s.toString();
    }

    /**
     * Fills the stack with elements from an ArrayList.
     * @param list The list of elements to add to the stack.
     * @throws StackOverflowException If adding all elements would exceed stack capacity.
     */
    @Override
    public void fill(ArrayList<T> list) throws StackOverflowException {
        for (T t : list) {
            push(t); // Use existing push method to ensure checks
        }
    }
}
