package com.sandy.tp;

/**
 * Created by gondals on 04/09/16.
 */
public class MyTPClass {

    public static void main(String[] args) {
        System.out.println("Hello World");


        new MyTPClass().execute();
    }

    private void execute() {
        callMethod();
    }

    private void callMethod() {
        throw new RuntimeException("hello");
//        System.out.println("Hello");
    }
}
