package com.sandy.dsalgo.linkedlist;

/**
 * Created by gondals on 13/08/16.
 */
public class TestMyLinkedList {

    public static void main(String[] args) {
        System.out.println("Hello");

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        System.out.println("-----");
        myLinkedList.print();

        System.out.println("-----");
        myLinkedList.add(54);
        myLinkedList.add(67);
        myLinkedList.print();

        System.out.println("-----");
        myLinkedList.insert(99, 1);
        myLinkedList.print();

        System.out.println("-----");
        myLinkedList.insert(100, 3);
        myLinkedList.add(55);
        myLinkedList.print();

        System.out.println("-----");
        myLinkedList.delete(2);
        myLinkedList.print();

        System.out.println("-----");
        myLinkedList.delete(3);
        myLinkedList.print();
    }

}
