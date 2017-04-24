package com.sandy.dsalgo.trees.coding;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 18/08/16.
 *
 * Replace every element with the least greater element on its right
 * Create a BST of input from Right to Left since we want max value from right side.
 * While inserting an element in BST, if we take a left, then lat left will be least greater than than the value we are inserting.
 *
 * Input:  [ 8, 58, 71, 18, 31, 32, 63, 92, 43,  3, 91, 93, 25, 80, 28]
 * Output: [18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1]
 *
 */
public class ReplaceArrayElementWithLeastGreater {

    private Node root;

    public static void main(String[] args) {
        System.out.println("Hello");

        new ReplaceArrayElementWithLeastGreater().execute();
    }

    private void execute() {
        int [] input = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println("\n-----");

        for (int i = input.length - 1; i >= 0; i--)
            input[i] = add(input[i]);

        print();
        System.out.println("-----");

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    private int add(final int data) {
        Node node = new Node();
        node.data = data;
        int successor = -1;

        if (root == null)
            root = node;
        else {
            Node current = root;

            while(true)
                if (data < current.data) {
                successor = current.data;
                    if (current.left == null) {
                        current.left = node;
                        break;
                    } else
                        current = current.left;
                }
                else
                    if (current.right == null) {
                        current.right = node;
                        break;
                    } else
                        current = current.right;

        }

        return successor;
    }

    private void print() {
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);

        while(nodes.size() > 0) {
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
    }

}
