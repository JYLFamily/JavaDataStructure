package com.company.queue;

public interface MyQueueGeneric<E> {

    public void enqueue(E element);

    public E dequeue();

    public int getSize();

    public boolean isEmpty();

    public E getFront();
}
