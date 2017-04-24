package com.sandy.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 16/08/16.
 */
public class BFS {

    private Node root;

    public static void main(String[] args) {
        System.out.println("Hello BFS");
        new BFS().execute();
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
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);

        while(nodes.size() > 0) {
            Node poll = nodes.poll();
            System.out.println(poll.data);
            if (poll.left != null)
                nodes.add(poll.left);
            if (poll.right != null)
                nodes.add(poll.right);
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
