package com.sandy.dsalgo.array;

/**
 * Created by gondals on 13/08/16.
 */
public class MyArray {

    private int size;
    private int[] arr;
    private int index;

    public MyArray(final int size) {
        this.index = 0;
        this.size = size;
        arr = new int[size];
    }

    public void addValue(final int value) {
        if (index >= size)
            throw new IllegalStateException("Array overflow");

        arr[index++] = value;
    }

    public void updateValue(final int value, final int index) {
        arr[index] = value;
    }

    public void deleteValue(final int index) {
        int counter = index;
        while (counter < this.index - 1) {
            arr[counter] = arr[counter + 1];
            counter++;
        }
        this.index--;
    }

    public void insertValue(final int value, final int index) {
        int counter = this.index;

        while (counter > index) {
            arr[counter] = arr[counter - 1];
            counter--;
        }
        arr[index] = value;
        this.index++;
    }

    public void print() {
        for (int i = 0; i < index; i++)
            System.out.println(arr[i]);
    }
}
