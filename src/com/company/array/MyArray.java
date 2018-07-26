package com.company.array;

public class MyArray {

    private int[] array;
    private int size;

    public MyArray() {
        this(10);
    }

    public MyArray(int capacity) {
        this.array = new int[capacity];
    }

    public int get(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Index error.");

        return this.array[index];
    }

    public int find(int element) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == element)
                return i;
        }
        return -1;  // 没有找到 element 返回 -1
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == element)
                return true;
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
            if (i != this.array.length - 1)
                str = str.concat(", ");
        }

        str = str.concat("]");

        return str;
    }

    public void add(int index, int element) {
        if (index < 0 || index > this.size)
            throw new IllegalArgumentException("Index error.");

        if (this.size == this.array.length)
            resize(2 * this.array.length);

        for (int i = this.size-1; i >= index; i--) {
            this.array[i+1] = this.array[i];
        }
        this.array[index] = element;
        this.size = this.size + 1;
    }

    public void addFirst(int element) {
        this.add(0, element);
    }

    public void addLast(int element) {
        this.add(this.size, element);
    }

    public int remove(int index) {
        int temp = this.array[index];

        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Index error.");

        // FIX: 注意是 i <= this.size 需要使用 this.size - 1 覆盖 this.size
        for (int i = index + 1; i <= this.size; i++) {
            this.array[i-1] = this.array[i];
        }
        this.size = this.size - 1;

        if (this.size < this.array.length / 2)
            resize(this.array.length / 2);

        return temp;
    }

    public int removeFirst() {
        // 数组为空, index >= this.size 为真 throw Error
        return this.remove(0);
    }

    public int removeLast() {
        // 数组为空, index < 0 为真 throw Error
        return this.remove(this.size-1);
    }

    public void removeElement(int element) {
        int index = this.find(element);
        if (index != -1)
            this.remove(index);
    }

    public void set(int index, int element) {
        this.array[index] = element;
    }

    private void resize(int capacity) {
        int[] newArray = new int[capacity];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);

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
        myArray.removeLast();
        System.out.println("Remove Last Method: ");
        System.out.println(myArray);

        myArray.removeFirst();
        System.out.println("Remove First Method: ");
        System.out.println(myArray);

        myArray.removeElement(10);
        System.out.println("Remove Element Method: ");
        System.out.println(myArray);

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

        myArray.removeLast();
        myArray.removeLast();
        myArray.removeLast();
        myArray.removeLast();
        myArray.removeLast();
        myArray.removeLast();
        myArray.removeLast();
        myArray.removeLast();
        myArray.removeLast();
        System.out.println(myArray);
    }
}
