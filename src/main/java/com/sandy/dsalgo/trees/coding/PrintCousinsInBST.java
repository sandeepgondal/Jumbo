package com.sandy.dsalgo.trees.coding;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 18/08/16.
 */
public class PrintCousinsInBST {

    private Node root;

    public static void main(String[] args) {
        System.out.println("Hello");

        new PrintCousinsInBST().execute();
    }

    private void execute() {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);

        print();
        printSiblings(5);
    }

    private void printSiblings(final int data) {
        Node parent = getParent(root, data);
    }

    private Node getParent(final Node node, final int data) {

//        if (node.left != null) {
//
//        }

        return null;

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
        Queue<Node> nodes = new ArrayDeque<>();
        if (root != null)
            nodes.add(root);

        while (nodes.size() > 0) {
            Node n = nodes.poll();
            System.out.println(n.data);
            if (n.left != null)
                nodes.add(n.left);
            if (n.right != null)
                nodes.add(n.right);
        }
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;
        private int height;
    }

}
