package com.sandy.dsalgo.trees;

import java.util.Comparator;

/**
 * Created by gondals on 14/08/16.
 */
public class AVLTreeSet<E> {

    private static class MutableBoolean {
        boolean value;
    }

    private static final long serialVersionUID = 1L;

    private class Node<E> {
        E data;
        Node<E> left, right;
        int height;

        Node(E data, Node<E> left, Node<E> right, int height) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        Node(E data, Node<E> left, Node<E> right) {
            this(data, left, right, 0);
        }
    }

    private Node<E> root = null;
    private int size = 0;
    private Comparator<? super E> cmp = null;

    public AVLTreeSet(Comparator<? super E> cmp) {
        this.cmp = cmp;
    }

    public AVLTreeSet() {
    }

    @SuppressWarnings("unchecked")
    private int myCompare(E lhs, E rhs) {
        if (cmp == null) {
            return ((Comparable) lhs).compareTo(rhs);
        }
        else {
            return cmp.compare(lhs, rhs);
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public java.util.Comparator<? super E> comparator() {
        return cmp;
    }

    private boolean contains(Node<E> n, E elt) {
        if (n == null) {
            return false;
        }
        int comp = myCompare(elt, n.data);
        if (comp < 0) {
            return contains(n.left, elt);
        }
        else if (comp > 0) {
            return contains(n.right, elt);
        }
        else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    public boolean contains(Object obj) {
        E elt = (E) obj;
        return contains(root, elt);
    }

    private int height(Node<E> p) {
        return (p == null) ? -1 : p.height;
    }

    private Node<E> s_rotate_left(Node<E> n) {
        Node<E> k2 = n;
        Node<E> k1 = k2.left;

        int x = k1.left.height;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = x;
        k1.height = x + 1;

        return k1;
    }

    private Node<E> s_rotate_right(Node<E> n) {
        Node<E> k1 = n;
        Node<E> k2 = k1.right;

        int z = k2.right.height;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = z;
        k2.height = z + 1;

        return k2;
    }

    private Node<E> d_rotate_left(Node<E> n) {
        Node<E> k3 = n;
        Node<E> k1 = n.left;
        Node<E> k2 = k1.right;

        int a = height(k1.left);

        k1.right = k2.left;
        k3.left = k2.right;
        k2.left = k1;
        k2.right = k3;

        k1.height = 1 + a;
        k3.height = 1 + a;
        k2.height = 2 + a;

        return k2;
    }

    private Node<E> d_rotate_right(Node<E> n) {
        Node<E> k1 = n;
        Node<E> k3 = n.right;
        Node<E> k2 = k3.left;

        int d = height(k3.right);

        k3.left = k2.right;
        k1.right = k2.left;
        k2.left = k1;
        k2.right = k3;

        k1.height = 1 + d;
        k3.height = 1 + d;
        k2.height = 2 + d;

        return k2;
    }

    private boolean show_rotations = false;

    public void setShowRotations(boolean trueORfalse) {
        show_rotations = trueORfalse;
    }

    private Node<E> add(E elt, Node<E> n, MutableBoolean found) {

        if (n == null) {
            found.value = false;
            return new Node<>(elt, null, null);
        }
        int comp = myCompare(elt, n.data);
        if (comp < 0) {
            n.left = add(elt, n.left, found);

            if (height(n.left) - height(n.right) == 2) {
                int comp1 = myCompare(elt, n.left.data);
                if (comp1 < 0) {
                    if (show_rotations) {
                        System.out.println("s_rotate_left at " + n.data);
                    }
                    return s_rotate_left(n);   // single rotate on left-left insertion
                }
                else {
                    if (show_rotations) {
                        System.out.println("d_rotate_left at " + n.data);
                    }
                    return d_rotate_left(n);   // double rotate on left-right insertion
                }
            }
            else if (!found.value) {
                // adjust the height if the tree changed (not found)
                n.height = Math.max(height(n.left), height(n.right)) + 1;
                return n;
            }
            else {
                return n;
            }

        }
        else if (comp > 0) {
            n.right = add(elt, n.right, found);

            if (height(n.right) - height(n.left) == 2) {
                int comp1 = myCompare(elt, n.right.data);
                if (comp1 > 0) {
                    if (show_rotations) {
                        System.out.println("s_rotate_right at " + n.data);
                    }
                    return s_rotate_right(n);   // single rotate on right-right insertion
                }
                else {
                    if (show_rotations) {
                        System.out.println("d_rotate_right at " + n.data);
                    }
                    return d_rotate_right(n);   // double rotate on right-left insertion
                }
            }
            else if (!found.value) {
                n.height = Math.max(height(n.left), height(n.right)) + 1;
                return n;
            }
            else {
                return n;
            }
        }
        else {
            found.value = true;
            return n;
        }
    }

    public boolean add(E elt) {
        MutableBoolean found = new MutableBoolean();
        found.value = false;
        root = add(elt, root, found);
        if (!found.value) {
            ++size;
        }
        return !found.value;
    }

    // structure-revealing operations
    private String indentString = "   ";

    public void setIndentString(String indentString) {
        this.indentString = indentString;
    }

    public void reverseInorderOutput() {
        reverseInorderOutput(root, 0);
    }

    private String repeat(String s, int times) {
        String output = "";
        for (int i = 0; i < times; ++i) {
            output += s;
        }
        return output;
    }

    private void reverseInorderOutput(Node n, int level) {
        if (n != null) {
            reverseInorderOutput(n.right, level + 1);
            System.out.println(repeat(indentString, level) + n.data + "[ht=" + n.height + "]");
            reverseInorderOutput(n.left, level + 1);
        }
    }
}