package com.sandy.dsalgo.trees.coding;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 18/08/16.
 *
 * Convert BST to Min Heap in place
 *
 * Solution: Create a Sorted Linked List using in-order traversal. Use left reference of Node to create Linked List.
 * Use sorted linked list and queue to re arrange tree so that it is a min heap.
 */
public class BSTtoMinHeap {

    private Node root;
    private Node newRoot;
    private Node current;

    public static void main(String[] args) {
        System.out.println("Hello");

        new BSTtoMinHeap().execute();
    }

    private void execute() {

        add(8);
        add(4);
        add(12);
        add(2);
        add(6);
        add(10);
        add(14);

        print();
        System.out.println("---------");

        convertBSTtoSortedLinkList(root);
        convertSortedLinkListToMinHeap(newRoot);
        root = newRoot;
        print();
    }

    private void convertSortedLinkListToMinHeap(final Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        Node current = node.left;
        queue.add(node);
        while (current != null) {
            Node poll = queue.poll();

            Node leftNode = current;
            current = current.left;
            leftNode.left = null;
            leftNode.right = null;
            poll.left = leftNode;
            queue.add(leftNode);


            if (current == null)
                break;
            Node rightNode = current;
            current = current.left;
            rightNode.left = null;
            rightNode.right = null;
            poll.right = rightNode;
            queue.add(rightNode);

        }
    }

    private void convertBSTtoSortedLinkList(final Node node) {
        if (node.left != null)
            convertBSTtoSortedLinkList(node.left);

        if (newRoot == null)
            newRoot = node;
        else
            current.left = node;

        current = node;

        if (node.right != null)
            convertBSTtoSortedLinkList(node.right);
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
