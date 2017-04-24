package com.sandy.dsalgo.trees.coding;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gondals on 18/08/16.
 *
 * Find intersection of two binary search trees
 */
public class IntersectionOfTwoBST {

    private Node root1;
    private Node root2;

    public static void main(String[] args) {
        System.out.println("Hello");

        new IntersectionOfTwoBST().execute();
    }

    private void execute() {

        add(1, 5);
        add(1, 1);
        add(1, 10);
        add(1, 0);
        add(1, 4);
        add(1, 7);
        add(1, 9);

        add(2, 10);
        add(2, 7);
        add(2, 20);
        add(2, 4);
        add(2, 9);

        intersection();

    }

    private void intersection() {
        Set<Node> nodes = new HashSet<>();
        getFirstBSTNodes(root1, nodes);
        printCommonNodes(root2, nodes);
    }

    private void printCommonNodes(final Node node, final Set<Node> nodes) {
        if (node.left != null)
            printCommonNodes(node.left, nodes);

        if (nodes.contains(node))
            System.out.println(node.data);

        if (node.right != null)
            printCommonNodes(node.right, nodes);
    }

    private void getFirstBSTNodes(final Node node, final Set<Node> nodes) {
        if (node.left != null)
            getFirstBSTNodes(node.left, nodes);

        nodes.add(node);

        if (node.right != null)
            getFirstBSTNodes(node.right, nodes);
    }

    private void add(final int tree, final int data) {
        Node node = new Node();
        node.data = data;

        if (tree == 1 && root1 == null)
            root1 = node;
        else if (tree == 2 && root2 == null)
            root2 = node;
        else {
            Node current = null;
            if (tree == 1)
             current = root1;
            else
                current = root2;

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
            return Integer.hashCode(data);
        }
    }

}
