package com.sandy.dsalgo.trees.coding;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 18/08/16.
 */
public class MinimumDepthOfBST {

    private Node root;

    public static void main(String[] args) {
        System.out.println("Hello");

        new MinimumDepthOfBST().execute();
    }

    private void execute() {
        add(10);
        add(5);
        add(15);
        add(3);
        add(2);
        add(12);
        add(11);
        add(20);
        print();
        System.out.println("-------");

        System.out.println("--" + getminimumHeight(root));
        setMinimumHeightWithPostOrder(root);
        System.out.println("--" + root.height);
    }

    private void setMinimumHeightWithPostOrder(final Node node) {
        if (node.left != null)
            setMinimumHeightWithPostOrder(node.left);

        if (node.right != null)
            setMinimumHeightWithPostOrder(node.right);

        if (node.left == null && node.right == null)
            node.height = 1;
        else if (node.left != null && node.right == null)
            node.height = node.left.height + 1;
        else if (node.right != null && node.left == null)
            node.height = node.right.height + 1;
        else
            node.height = Math.min(node.left.height, node.right.height) + 1;
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

    public int getminimumHeight(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        if (node.left == null)
            return getminimumHeight(node.right) + 1;

        if (node.right == null)
            return getminimumHeight(node.left) + 1;


        return Math.min(getminimumHeight(node.left), getminimumHeight(node.right)) + 1;
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;
        private int height;
    }

}
