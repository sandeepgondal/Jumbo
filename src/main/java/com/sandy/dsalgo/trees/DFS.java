package com.sandy.dsalgo.trees;

import java.util.Stack;

/**
 * Created by gondals on 16/08/16.
 */
public class DFS {

    private Node root;

    public static void main(String[] args) {
        System.out.println("Hello DFS");

        new DFS().execute();
    }

    private void execute() {
        add(10);
        add(5);
        add(15);
        add(6);
        add(12);
        add(20);

        print();
    }

    private void print() {
        Stack<Node> nodes = new Stack<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            Node pop = nodes.pop();
            System.out.println(pop.data);
            if (pop.right != null)
                nodes.add(pop.right);
            if (pop.left != null)
                nodes.add(pop.left);
        }
    }

    private void add(final int data) {
        Node node = new Node();
        node.data = data;

        if (root == null)
            root = node;
        else {
            Node current = root;
            while(true)
                if (data <= current.data)
                    if (current.left == null) {
                        current.left = node;
                        break;
                    } else
                        current = current.left;
                else
                    if (data > current.data)
                        if (current.right == null) {
                            current.right = node;
                            break;
                        } else
                            current = current.right;
        }
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;
    }
}
