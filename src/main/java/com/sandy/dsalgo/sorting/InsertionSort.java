package com.sandy.dsalgo.sorting;

/**
 * Created by gondals on 13/08/16.
 */
public class InsertionSort {

    public int[] sort(final int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    int t = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = t;
                } else
                    break;
            }
        }
        return data;
    }
}
