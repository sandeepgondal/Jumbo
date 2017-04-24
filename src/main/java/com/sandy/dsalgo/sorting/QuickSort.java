package com.sandy.dsalgo.sorting;

/**
 * Created by gondals on 13/08/16.
 */
public class QuickSort {

    public int[] sort(final int[] data) {
        int pivot = data[data.length / 2];
        quickSort(data, 0, pivot, data.length - 1);
        return data;
    }

    private void quickSort(final int[] data, final int start, final int pivot, final int end) {
        int i = start;
        int j = end;

        while (i <= j) {
            while (data[i] < pivot)
                i++;
            while (data[j] > pivot)
                j--;

            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        if (start < j) {
            int pivot1 = data[(start + j) / 2];
            quickSort(data, start, pivot1, j);
        }

        if (i < end) {
            int pivot2 = data[(i + end) / 2];
            quickSort(data, i, pivot2, end);
        }
    }

    private void swap(final int[] data, final int i, final int j) {
        if (i == j)
            return;
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
