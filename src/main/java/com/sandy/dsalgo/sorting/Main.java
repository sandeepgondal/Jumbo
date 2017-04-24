package com.sandy.dsalgo.sorting;

/**
 * Created by gondals on 13/08/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Sorting");

        int[] data = {5, 3, 1, 66, 34, 100, 0};
        print("---Unsorted", data);

        print("---Bubble", new BubbleSort().sort(new int[] {5, 3, 1, 66, 34, 100, 0}));
        print("---Insertion", new InsertionSort().sort(new int[] {5, 3, 1, 66, 34, 100, 0}));
        print("---Selection", new SelectionSort().sort(new int[] {5, 3, 1, 66, 34, 100, 0}));
        print("---Merge", new MergeSort().sort(new int[] {5, 3, 1, 66, 34, 100, 0}));
        print("---Quick", new QuickSort().sort(new int[]{5, 3, 1, 66, 34, 100, 0}));
        print("---Quick", new QuickSort().sort(new int[]{10, 9, 1, 5, 3, 4, 12, 2, 7}));
    }

    private static void print(final String sortingType, final int[] data) {
        System.out.println(sortingType);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

}
