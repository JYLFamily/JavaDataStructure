package com.company.queue;

import com.company.array.MyArrayGeneric;

public class MyArrayQueueGeneric<E> implements MyQueueGeneric<E> {

    private MyArrayGeneric<E> myArrayGeneric;

    public MyArrayQueueGeneric(int capacaity) {
        this.myArrayGeneric = new MyArrayGeneric<>(capacaity);
    }

    public MyArrayQueueGeneric() {
        this.myArrayGeneric = new MyArrayGeneric<>();
    }

    public void enqueue(E element) {
        this.myArrayGeneric.addLast(element);
    }

    public E dequeue() {
        return this.myArrayGeneric.removeFirst();
    }

    public int getSize() {
        return this.myArrayGeneric.getSize();
    }

    public boolean isEmpty() {
        return this.myArrayGeneric.isEmpty();
    }

    public E getFront() {
        return this.myArrayGeneric.get(0);
    }

    public String toString() {
//        StringBuilder res = new StringBuilder();
//        res.append("QUEUE: FRONT [");
//
//        for (int i = 0; i < this.myArrayGeneric.getSize(); i++) {
//            res.append(this.myArrayGeneric.get(i));
//            if (i != this.myArrayGeneric.getSize()-1)
//                res.append(", ");
//        }
//        res.append("] TAIL");


        StringBuilder res = new StringBuilder();
        res.append("LOOP QUEUE: FRONT [");

        // 这里只能够使用 this.myArrayGeneric.getSize() 因为 get() 方法
        // 对 index 做了限制
        for (int i = 0; i < this.myArrayGeneric.getSize(); i++) {
            res.append(this.myArrayGeneric.get(i));

            if (i != this.myArrayGeneric.getSize() - 1)
                res.append(", ");
        }

        res.append("] TAIL");

        return res.toString();
    }

    public static void main(String[] args) {
        MyArrayQueueGeneric<Integer> myArrayQueueGeneric = new MyArrayQueueGeneric<>();

        myArrayQueueGeneric.enqueue(10);
        myArrayQueueGeneric.enqueue(20);
        myArrayQueueGeneric.enqueue(30);
        myArrayQueueGeneric.enqueue(40);
        myArrayQueueGeneric.enqueue(50);
        System.out.println(myArrayQueueGeneric);

        myArrayQueueGeneric.dequeue();
        System.out.println(myArrayQueueGeneric);
    }
}
