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

import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    @Override
    public void addToEnd(T data) {
        
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public void addToFront(T data) {
        
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            Node current = head;
            while (current != null && comparator.compare(current.data, data) < 0) {
                current = current.next;
            }
            if (current == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                newNode.next = current;
                newNode.prev = current.prev;
                if (current.prev != null) {
                    current.prev.next = newNode;
                }
                current.prev = newNode;
            }
        }
        size++;
    }

    // The iterator and other functionalities are inherited from BasicDoubleLinkedList
    // Ensure to test thoroughly for your specific use cases
}
