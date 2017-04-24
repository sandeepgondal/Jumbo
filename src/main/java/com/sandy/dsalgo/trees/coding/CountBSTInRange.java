package com.sandy.dsalgo.trees.coding;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by gondals on 18/08/16.
 *
 * Count all sub trees in a BST that are in given range
 */
public class CountBSTInRange {

    private Node root;
    private Set<Node> range = new HashSet<>();
    private int count = 0;

    public static void main(String[] args) {
        System.out.println("Hello");

        new CountBSTInRange().execute();
    }

    private void execute() {
        add(10);
        add(5);
        add(50);
        add(1);
        add(40);
        add(100);

        print();
        countInRange(1, 100, root);
        System.out.println("---Count: " + count);
        System.out.println("---Range: " + range);
    }

    private void countInRange(final int start, final int end, final Node node) {

        if (node.left != null)
            countInRange(start, end, node.left);

        if (node.right != null)
            countInRange(start, end, node.right);

        if (node.data >= start && node.data <= end) {
            if (inCachedRange(node.left) && inCachedRange(node.right)) {
                    range.add(node);
                    count++;
            } else
                return;
        }

    }

    private boolean inCachedRange(Node node) {
        if (node == null)
            return true;
        else if (range.contains(node))
            return true;
        else
            return false;
    }

    private void add(final int data) {
        Node node = new Node();
        node.data = data;

        if (root == null)
            root = node;
        else {
            Node current = root;

            while(true)
                if (data < current.data)
                    if (current.left == null) {
                        current.left = node;
                        break;
                    } else
                        current = current.left;
                else
                if (current.right == null) {
                    current.right = node;
                    break;
                } else
                    current = current.right;

        }
    }

    private void print() {
        Queue<Node> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        while(queue.size() > 0) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }


    private class Node {
        private int data;
        private Node left;
        private Node right;

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Node node = (Node) o;

            return data == node.data;
        }

        @Override
        public int hashCode() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}
