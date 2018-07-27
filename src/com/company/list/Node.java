package com.company.list;

public class Node<E> {
    public E element;
    public Node<E> next;

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public Node(E element) {
        this(element, null);
    }

    public Node() {
        this(null, null);
    }

    public String toString() {
        return this.element.toString();
    }

}
