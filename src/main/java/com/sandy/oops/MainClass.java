package com.sandy.oops;

/**
 * Created by gondals on 15/09/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello OOPS");

        Apple apple = new Apple();
        int peels = apple.peels();
        System.out.println(peels);
    }

}
