package com.sandy.core.thread;

import com.sandy.core.thread.my.MyBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by gondals on 01/08/16.
 */
public class BlockingQueueClass {

    public static void main(String[] args) {
        System.out.println("Welcome to Blocking Queue");

        // Blocking queue with capacity of 5
//        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(5);
        MyBlockingQueue<Integer> linkedBlockingQueue = new MyBlockingQueue<>(5);

        new Thread(() -> {
            System.out.println("Producer");
            for (int i = 0; i < 50; i++) {
                try {
                    linkedBlockingQueue.put(Integer.valueOf(i));
                    System.out.println("Producer: " + i);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("Consumer");
            for (int i = 0; i < 50; i++) {
                try {
                    Integer val = (Integer) linkedBlockingQueue.take();
                    System.out.println("Consumer: " + val);
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("Done with Main Thread");
    }
}
