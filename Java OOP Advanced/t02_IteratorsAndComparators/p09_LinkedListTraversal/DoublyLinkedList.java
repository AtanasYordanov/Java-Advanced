package t02_IteratorsAndComparators.p09_LinkedListTraversal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList<E extends Comparable<E>> implements Iterable<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public int size() {
        return this.size;
    }

    public void addFirst(E element) {
        if (this.head == null) {
            this.head = this.tail = new Node<>(element);
        } else {
            Node<E> newNode = new Node<>(element);
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(E element) {
        if (this.head == null) {
            this.head = this.tail = new Node<>(element);
        } else {
            Node<E> newNode = new Node<>(element);
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void remove(E element) {
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            E current = iterator.next();
            if (current.compareTo(element) == 0) {
                iterator.remove();
                return;
            }
        }
    }

    public E removeFirst() {
        if (this.size <= 0) {
            throw new IllegalArgumentException("List is empty");
        } else {
            E element = this.head.value;
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            } else {
                this.tail = null;
            }
            this.size--;
            return element;
        }
    }

    public E removeLast() {
        if (this.size <= 0) {
            throw new IllegalArgumentException("List is empty");
        } else {
            E element = this.tail.value;
            this.tail = this.tail.prev;
            if (this.tail != null) {
                this.tail.next = null;
            } else {
                this.head = null;
            }
            this.size--;
            return element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        for (E e : this) {
            action.accept(e);
        }
    }

    private static class Node<T extends Comparable<T>> {

        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    private final class ListIterator implements Iterator<E> {

        Node<E> currentNode = head;

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = this.currentNode.value;
            this.currentNode = currentNode.next;
            return element;
        }

        @Override
        public void remove() {
            if (size <= 0) {
                throw new IllegalArgumentException("List is empty");
            }
            Node<E> node = this.currentNode == null ? tail : this.currentNode.prev;
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            size--;
        }
    }
}
