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

import java.util.*;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head, tail;
    protected int size = 0;

    public BasicDoubleLinkedList() {
        head = tail = null;
    }

    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    public int getSize() {
        return size;
    }

    public T retrieveFirstElement() {
        if (isEmpty()) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public T retrieveLastElement() {
        if (isEmpty()) {
            return null;
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public BasicDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, data) == 0) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                break;
            }
            current = current.next;
        }
        return this;
    }

    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected class Node {
        T data;
        Node next, prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node nextItem = head;
        private Node lastItemReturned = null;

        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            return lastItemReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0) || (nextItem != null && nextItem.prev != null);
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) {
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            return lastItemReturned.data;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException();
        }
    }
}