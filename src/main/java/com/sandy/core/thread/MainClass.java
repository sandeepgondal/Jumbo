package com.sandy.core.thread;

/**
 * Created by gondals on 16/09/16.
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Threads");
        int count = 0;

        Runnable r = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        };

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(r);
            thread.start();
//            thread.join();
        }

        System.out.println("Exiting main method");
        Thread.sleep(100);
        System.out.println("Exiting main method");
    }
}
