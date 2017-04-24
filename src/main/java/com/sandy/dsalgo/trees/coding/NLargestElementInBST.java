package com.sandy.dsalgo.trees.coding;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 18/08/16.
 */
public class NLargestElementInBST {

    private int cnt = 0;
    private Node root;

    public static void main(String[] args) {
        System.out.println("Hello");

        new NLargestElementInBST().execute();
    }

    private void execute() {
        add(20);
        add(8);
        add(22);
        add(4);
        add(12);
        add(10);
        add(14);

        print();
        System.out.println("-------");
        printElement(5, root);
    }

    private void printElement(final int number, final Node node) {
        if (node.left != null)
            printElement(number, node.left);

        cnt++;
        if (cnt == number) {
            System.out.println(node.data);
            return;
        }

        if (node.right != null)
            printElement(number, node.right);
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
    }
}
