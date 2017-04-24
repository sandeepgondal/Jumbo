package com.sandy.dsalgo.linkedlist;

/**
 * Created by gondals on 13/08/16.
 */
public class MyLinkedList<I> {

    private DataNode root;
    private DataNode current;

    private class DataNode {
        private I data;
        private DataNode next;
    }

    public void print() {
        DataNode pointer = root;
        while (pointer != null) {
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }

    public void add(final I data) {
        DataNode dataNode = new DataNode();
        dataNode.data = data;

        if (root == null) {
            root = dataNode;
            current = dataNode;
        } else {
            current.next = dataNode;
            current = dataNode;
        }
    }

    public void insert(final I data, final int index) {
        DataNode dataNode = new DataNode();
        dataNode.data = data;

        int counter = 0;
        DataNode pointer = root;
        while (counter < index - 1 && pointer.next != null) {
            counter++;
            pointer = pointer.next;
        }
        dataNode.next = pointer.next;
        pointer.next = dataNode;

        if (dataNode.next == null)
            current = dataNode;
    }

    public void delete(final int index) {
        int counter = 0;
        DataNode pointer = root;
        while (counter < index - 1 && pointer != null) {
            counter++;
            pointer = pointer.next;
        }

        if (pointer != null && pointer.next != null && counter == index - 1) {
            pointer.next = pointer.next.next;

            if (pointer.next == null)
                current = pointer;
        }

    }
}
