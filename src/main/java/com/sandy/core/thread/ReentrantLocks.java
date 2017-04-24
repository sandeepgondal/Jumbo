package com.sandy.core.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gondals on 09/08/16.
 */
public class ReentrantLocks {

    public static void main(String[] args) {
        System.out.println("Hello Re-entrant");

        String myLoack = "Lock";
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            System.out.println("Thread 1");
            if (reentrantLock.tryLock()) {
                System.out.println("Thread 1 : got lock");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
                System.out.println("Thread 1 : released lock");
            } else
                System.out.println("Thread 1 : could not get lock");
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2");

            while (true) {
                if (!reentrantLock.tryLock()) {
                    System.out.println("Thread 2 : could not get lock");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Thread 2 : got lock");
                    break;
                }
            }
            reentrantLock.unlock();

        }).start();
    }

}
