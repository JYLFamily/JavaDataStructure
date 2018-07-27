package com.company.list;

public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(E element) {
        Node<E> node = new Node<>(element, this.head);
        this.head = node;
        this.size = this.size + 1;
    }

    public void add(int index, E element) {
        // index = size 相当于在链表末尾插入元素
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Index Error.");

        if (index == 0) {
            addFirst(element);
        } else {
            Node<E> prev = this.head;
            Node<E> node = new Node<>(element, null);

            // 迭代到使得 prev 指向插入 element 之前那个 element
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }

        this.size = this.size + 1;
    }

    public void addLast(E element) {
        this.add(this.size, element);
    }
}
