package com.company.queue;

public class MyArrayLoopQueueGeneric<E> implements MyQueueGeneric<E> {

    private E[] array;
    private int front;
    private int tail;
    private int size;

    public MyArrayLoopQueueGeneric(int capacity) {
        // 因为实现循环队列的数组会故意空一个元素, 所以循环队列的容量为数组容量 - 1
        // 用户想要得到一个 capacity 容量的循环队列, 实现循环队列的数组容量需要 + 1
        this.array = (E[]) new Object[capacity+1];
    }

    public MyArrayLoopQueueGeneric() {
        this(10);
    }

    public void enqueue(E element) {
        // 如果队列满了, 底层数组扩容为原数组的两倍
        if ((this.tail + 1) % this.array.length == front) {
            this.resize(this.getCapacity() * 2);
        }

        this.array[this.tail] = element;
        this.tail = (this.tail + 1) % this.array.length;
        this.size = this.size + 1;
    }

    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Dequeue Error. Loop queue is empty.");
        E element = this.array[this.front];
        this.array[this.front] = null;
        this.front = (this.front + 1) % this.array.length;
        this.size = this.size - 1;

        if (this.size < this.getCapacity() / 2)
            this.resize(this.getCapacity() / 2);

        return element;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.array.length - 1;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Dequeue Error. Loop queue is empty.");

        return this.array[this.front];
    }

    private void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity + 1];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[(front + i) % this.array.length];
        }

        this.array = newArray;
        this.front = 0;
        this.tail = size;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LOOP QUEUE: FRONT [");

        for (int i = 0; i < this.size; i++) {
            res.append(this.array[(i + front) % this.array.length]);

            if (i != this.size - 1)
                res.append(", ");
        }

        res.append("] TAIL");

        return res.toString();
    }

    public static void main(String[] args) {
        MyArrayLoopQueueGeneric<Integer> myArrayLoopQueueGeneric = new MyArrayLoopQueueGeneric<>();

        myArrayLoopQueueGeneric.enqueue(10);
        myArrayLoopQueueGeneric.enqueue(20);
        myArrayLoopQueueGeneric.enqueue(30);
        myArrayLoopQueueGeneric.enqueue(40);
        myArrayLoopQueueGeneric.enqueue(50);
        System.out.println(myArrayLoopQueueGeneric);
        myArrayLoopQueueGeneric.dequeue();
        System.out.println(myArrayLoopQueueGeneric);
        myArrayLoopQueueGeneric.dequeue();
        System.out.println(myArrayLoopQueueGeneric);
        myArrayLoopQueueGeneric.dequeue();
        System.out.println(myArrayLoopQueueGeneric);
    }
}