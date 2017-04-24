package com.sandy.dsalgo.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gondals on 14/08/16.
 */
public class MaxHeap {

    List<Integer> heap = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello Max Heap");

        new MaxHeap().execute();
    }

    private void execute() {
        add(26);
        add(33);
        add(31);
        add(10);
        add(42);
        add(19);
        add(27);
        add(44);
        add(35);
        add(99);
        System.out.println(heap);
        removeMax();
        System.out.println(heap);
    }

    private void removeMax() {
        int newRoot = heap.remove(heap.size() - 1);
        heap.set(0, newRoot);
        shiftDown(0);
    }

    private void shiftDown(final int index) {
        int childIndex1 = index * 2 + 1;
        int childIndex2 = childIndex1 + 1;


        if (childIndex1 < heap.size() && heap.get(index) < heap.get(childIndex1)) {
            swap(index, childIndex1);
            shiftDown(childIndex1);
        }
        if (childIndex2 < heap.size() && heap.get(index) < heap.get(childIndex2)) {
            swap(index, childIndex2);
            shiftDown(childIndex2);
        }
    }

    private void add(final int data) {
        heap.add(data);
        shiftUp(heap.size() - 1);
    }

    private void shiftUp(final int index) {
        int parentIndex = (index - 1) / 2;

        if (parentIndex < 0)
            return;

        if (heap.get(index) > heap.get(parentIndex)) {
            swap(parentIndex, index);
            shiftUp(parentIndex);
        }
    }

    private void swap(final int parentIndex, final int index) {
        int t = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(index));
        heap.set(index, t);
    }

}
