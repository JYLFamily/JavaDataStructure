package com.company.stack;

import com.company.array.MyArrayGeneric;

public class MyArrayStackGeneric<E> implements MyStackGeneric<E> {

    private MyArrayGeneric<E> myArrayGeneric;

    public MyArrayStackGeneric(int capacity) {
        this.myArrayGeneric = new MyArrayGeneric<>(capacity);
    }

    public MyArrayStackGeneric() {
        this.myArrayGeneric = new MyArrayGeneric<>();
    }

    public void push(E element) {
        this.myArrayGeneric.addLast(element);
    }

    public E pop() {
        return this.myArrayGeneric.removeLast();
    }

    public int getSize() {
        return this.myArrayGeneric.getSize();
    }

    public boolean isEmpty() {
        return this.myArrayGeneric.isEmpty();
    }

    public E peek() {
        return this.myArrayGeneric.get(this.myArrayGeneric.getSize()-1);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("STACK: [");

        // 注意这里是 getSize() 不是 length
        for (int i = 0; i < this.myArrayGeneric.getSize(); i++) {
            res.append(this.myArrayGeneric.get(i));
            if (i != this.myArrayGeneric.getSize()-1)
                res.append(", ");
        }
        res.append("] Top");

        return res.toString();
    }

    public static void main(String[] args) {
        MyArrayStackGeneric<Integer> myArrayStackGeneric = new MyArrayStackGeneric<>();

        System.out.println("------------------- push Method --------------------");
        myArrayStackGeneric.push(10);  // Integer 与 int 自动拆箱、装箱
        myArrayStackGeneric.push(20);
        myArrayStackGeneric.push(30);
        myArrayStackGeneric.push(40);
        System.out.println(myArrayStackGeneric);

        System.out.println("------------------- pop Method ---------------------");
        myArrayStackGeneric.pop();
        System.out.println(myArrayStackGeneric);
    }
}
