package com.sandy.dsalgo.sorting;

/**
 * Created by gondals on 13/08/16.
 */
public class BubbleSort {

    public int[] sort(final int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int t = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = t;
                }
            }
        }
        return data;
    }
}
