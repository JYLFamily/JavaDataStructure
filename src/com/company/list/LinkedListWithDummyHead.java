package com.company.list;

public class LinkedListWithDummyHead<E> {

    private Node<E> dummyHead;
    private int size;

    public LinkedListWithDummyHead() {
        this.dummyHead = new Node<>();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Index Error.");

        Node<E> prev = this.dummyHead;
        Node<E> node = new Node<>(element, null);

        // 没有虚拟头节点的时候 i = 0 i < index-1
        // 存在虚拟头节点的时候 i = 0 i < index 需要多迭代一次
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        this.size = this.size + 1;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(this.size, element);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkList HEAD [");

        Node<E> prev = this.dummyHead;

        for (int i = 0; i < this.size; i++) {
            prev = prev.next;
            res.append(prev.element);
            if (i != this.size - 1)
                res.append(", ");
        }

        res.append("] TAIL");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListWithDummyHead<Integer> llwdh = new LinkedListWithDummyHead<>();
        llwdh.addLast(10);
        llwdh.addLast(20);

        System.out.println(llwdh);
    }
}
