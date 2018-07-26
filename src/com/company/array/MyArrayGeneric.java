package com.company.array;

public class MyArrayGeneric<E> {
    private E[] array;
    private int size;

    public MyArrayGeneric() {
        this(10);
    }

    public MyArrayGeneric(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    public E get(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Index error.");

        return this.array[index];
    }

    public int find(E element) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(E element) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.array.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        String str = "[";

        for (int i = 0; i < this.array.length; i++) {
            str = str.concat(String.valueOf(this.array[i]));
            if (i != this.array.length-1)
                str = str.concat(", ");
        }

        str = str.concat("]");

        return str;
    }

    public void add(int index, E element) {
        if (index < 0 || index > this.size)
            throw new IllegalArgumentException("Index Error.");


        if (this.size == this.array.length)
            resize(2 * this.array.length);

        for (int i = this.size-1; i >= index; i--) {
            this.array[i+1] = this.array[i];
        }
        this.array[index] = element;
        this.size = this.size + 1;
    }

    public void addFirst(E element) {
        this.add(0, element);
    }

    public void addLast(E element) {
        this.add(this.size, element);
    }

    public E remove(int index) {
        E temp = this.array[index];

        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Index Error.");

        for (int i = index+1; i <= this.size; i++) {
            this.array[i-1] = this.array[i];
        }

        this.size = this.size - 1;

        if (this.size < this.array.length / 2)
            resize(this.array.length / 2);

        return temp;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(this.size - 1);
    }

    public void set(int index, E element) {
        this.array[index] = element;
    }

    private void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }


    public static void main(String[] args) {
        MyArrayGeneric<Integer> myArray = new MyArrayGeneric<>(10);

        System.out.println("------------------- Add Method --------------------");
        myArray.addLast(10);
        myArray.addLast(20);
        myArray.addLast(30);
        myArray.addLast(40);
        myArray.addLast(50);
        System.out.println("Add Last Method: ");
        System.out.println(myArray);

        myArray.addFirst(5);
        System.out.println("Add First Method: ");
        System.out.println(myArray);

        myArray.add(1, 7);
        System.out.println("Add Method: ");
        System.out.println(myArray);

        System.out.println("------------------- Remove Method -----------------");
        myArray.remove(0);
        System.out.println("Remove Method: ");
        System.out.println(myArray);

        System.out.println("------------------- Set Method --------------------");
        myArray.set(0, -1);
        System.out.println("Set Method: ");
        System.out.println(myArray);

        System.out.println("------------------- Select Method -----------------");
        System.out.println("Get Method: ");
        System.out.println(myArray.get(0));
        System.out.println("Get Size Method: ");
        System.out.println(myArray.getSize());
        System.out.println("IS Empty Method: ");
        System.out.println(myArray.isEmpty());
        System.out.println("Contains Method: ");
        System.out.println(myArray.contains(-1));

        System.out.println("------------------- Resize Method -----------------");
        myArray.addLast(60);
        myArray.addLast(70);
        myArray.addLast(80);
        myArray.addLast(90);
        myArray.addLast(100);
        myArray.addLast(110);
        myArray.addLast(120);
        myArray.addLast(130);
        System.out.println(myArray);
    }
}
