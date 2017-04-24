package com.sandy.dsalgo.sorting;

/**
 * Created by gondals on 13/08/16.
 */
public class SelectionSort {

    public int[] sort(final int[] data) {
        for (int i = 0; i < data.length; i++) {
            int val = data[i];
            int index = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < val) {
                    val = data[j];
                    index = j;
                }
            }
            int t = data[i];
            data[i] = val;
            data[index] = t;
        }
        return data;
    }
}
