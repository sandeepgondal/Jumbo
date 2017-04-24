package com.sandy.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 14/08/16.
 */
public class BinarySearchTree {

    private static Node root;

    public static void main(String[] args) {
        System.out.println("Hello Trees");
        add(10);
        add(5);
        add(15);
        add(3);
        add(7);
        add(16);
        add(12);
        printTree();

        printInOrder();
        printPreOrder();
        printPostOrder();
    }

    private static void printPostOrder() {
        if (root == null)
            return;

        System.out.println("-----PostOrder");
        postOrder(root);
    }

    private static void postOrder(final Node node) {
        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);
        System.out.println(node.data);
    }

    private static void printPreOrder() {
        if (root == null)
            return;

        System.out.println("-----PreOrder");
        preOrder(root);
    }

    private static void preOrder(final Node node) {
        System.out.println(node.data);
        if (node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    private static void printInOrder() {
        if (root == null)
            return;

        System.out.println("-----InOrder");
        inOrder(root);
    }

    private static void inOrder(final Node node) {
        if (node.left != null)
            inOrder(node.left);
        System.out.println(node.data);
        if (node.right != null)
            inOrder(node.right);
    }

    private static void printTree() {
        if (root == null)
            return;

        System.out.println("-----");
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            Node poll = nodes.poll();
            System.out.println(poll.data);
            if (poll.left != null)
                nodes.add(poll.left);
            if (poll.right != null)
                nodes.add(poll.right);
        }
    }

    private static void add(final int data) {
        Node node = new Node();
        node.data = data;

        if (root == null)
            root = node;
        else {
            Node current = root;
            while (true) {
                if (data < current.data)
                    if (current.left == null) {
                        current.left = node;
                        break;
                    }
                    else
                        current = current.left;
                else
                    if (current.right == null) {
                        current.right = node;
                        break;
                    }
                    else
                        current = current.right;
            }
        }
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;
    }

}
