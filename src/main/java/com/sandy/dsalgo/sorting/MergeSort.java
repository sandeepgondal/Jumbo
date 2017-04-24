package com.sandy.dsalgo.sorting;

/**
 * Created by gondals on 13/08/16.
 */
public class MergeSort {

    public int[] sort(final int[] data) {
        if (data.length == 1)
            return data;

        int[] arr1 = split(data, 0, data.length / 2);
        int[] arr2 = split(data, data.length / 2, data.length);

        return merge(sort(arr1), sort(arr2));
    }

    private int[] split(final int[] data, final int from, final int till) {
        int[] newArray = new int[till - from];
        int cnt = 0;
        for (int i = from; i < till; i++)
            newArray[cnt++] = data[i];

        return newArray;
    }

    private int[] merge(final int[] arr1, final int[] arr2) {
        int[] sortedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, cnt = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                sortedArray[cnt++] = arr1[i++];
            else
                sortedArray[cnt++] = arr2[j++];
        }

        while (i < arr1.length)
            sortedArray[cnt++] = arr1[i++];

        while (j < arr2.length)
            sortedArray[cnt++] = arr2[j++];

        return sortedArray;
    }
}
