package com.company.stack;

public interface MyStackGeneric<E> {
    public void push(E element);

    public E pop();

    public int getSize();

    public boolean isEmpty();

    public E peek();
}
