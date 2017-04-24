package com.sandy.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 15/08/16.
 */
public class RedBlack {

    private Node root;

    public static void main(String[] args) {
        System.out.println("Hello Red Black trees");
        new RedBlack().execute();

    }

    private void execute() {
        add(10);
        add(15);
        add(12);
        add(5);
        add(11);
        add(3);
        add(2);
        add(20);
        add(18);
        printTree();
    }

    private Node add(final int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            while(true) {
                if (data < current.data)
                    if (current.left == null) {
                        current.left = node;
                        node.parent = current;
                        break;
                    } else
                        current = current.left;
                else
                    if (current.right == null) {
                        current.right = node;
                        node.parent = current;
                        break;
                    } else
                        current = current.right;
            }
        }
        redBlack(node);
        return node;
    }

    private Node redBlack(Node node) {
        Node g = getGrandParent(node);
        Node p = getParent(node);
        Node s = getSibling(p);

        if (p == null) {
            // current node is root node
            node.isRed = false;
        } else if (!p.isRed) {
            // if parent is black, do nothing
        } else if (p.isRed && s != null && s.isRed) {
            // if parent and uncle is red, then make grandparent as red and, parent and uncle as black
            p.isRed = false;
            s.isRed = false;
            g.isRed = true;
            redBlack(g);
        } else {
            if (p.right == node && g.left == p) {
                p.right = node.left;
                node.left = p;
                g.left = node;
                node.parent = g;
                p.parent = node;
                node = node.left;
            } else if (p.left == node && g.right == p) {
                p.left = node.right;
                node.right = p;
                g.right = node;
                node.parent = g;
                p.parent = node;
                node = node.right;
            }

            if (node.parent.left == node) {
                Node g1 = node.parent.parent;
                Node p1 = node.parent;

                if (root == g1)
                    root = p1;
                else
                    g1.parent.left = p1;

                g1.isRed = true;
                p1.isRed = false;
                p1.parent = g1.parent;
                g1.parent = p1;
                g1.left = p1.right;
                p1.right = g1;
            } else if (node.parent.right == node){
                Node g1 = node.parent.parent;
                Node p1 = node.parent;

                if (root == g1)
                    root = p1;
                else
                    g1.parent.right = p1;

                g1.isRed = true;
                p1.isRed = false;
                p1.parent = g1.parent;
                g1.parent = p1;
                g1.right = p1.left;
                p1.left = g1;
            }
            // parent is red and uncle is black
//            if ()

        }
        return node;
    }

    private Node getSibling(final Node node) {
        Node p = getParent(node);
        if (p != null)
            if (p.left == node)
                return p.right;
            else
                return p.left;

        return null;
    }

    private Node getParent(final Node node) {
        if (node != null)
            return node.parent;
        return null;
    }

    private Node getGrandParent(final Node node) {
        if (node != null && node.parent != null)
            return node.parent.parent;
        return null;
    }

    private void printTree() {
        if (root == null)
            return;

        System.out.println("-----");
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            Node poll = nodes.poll();
            System.out.println(poll.data + " " + (poll.isRed ? "R" : "B"));
            if (poll.left != null)
                nodes.add(poll.left);
            if (poll.right != null)
                nodes.add(poll.right);
        }
    }

    private class Node {
        private int data;
        private boolean isRed;
        private Node left;
        private Node right;
        private Node parent;

        public Node(final int data) {
            this.data = data;
            this.isRed = true;
        }
    }

}
