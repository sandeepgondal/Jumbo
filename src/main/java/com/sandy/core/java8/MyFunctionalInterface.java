package com.sandy.core.java8;

/**
 * Created by gondals on 02/08/16.
 */

@FunctionalInterface
public interface MyFunctionalInterface {

    void sayHello();

    default void printGreetingMessage() {
        System.out.println("Inside greeting message...");
    }

}
