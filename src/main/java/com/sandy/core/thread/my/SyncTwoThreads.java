package com.sandy.core.thread.my;

/**
 * Created by gondals on 17/09/16.
 */
public class SyncTwoThreads {

    public static void main(String[] args) {
        System.out.println("Threads Dude !!!");
        ThreadStateHolder threadStateHolder = new ThreadStateHolder();

        Runnable evenJob = () -> {
            int count = 0;
            while(count < 100)
                synchronized (threadStateHolder) {
                    if (threadStateHolder.isEven) {
                        System.out.println(count);
                        count += 2;

                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        threadStateHolder.isEven = false;
                        threadStateHolder.notifyAll();
                    } else
                        try {
                            threadStateHolder.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
        };

        Runnable oddJob = () -> {
            int count = 1;
            while(count < 100)
                synchronized (threadStateHolder) {
                    if (!threadStateHolder.isEven) {
                        System.out.println(count);
                        count += 2;
                        threadStateHolder.isEven = true;
                        threadStateHolder.notifyAll();
                    } else
                        try {
                            threadStateHolder.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
        };

        new Thread(oddJob).start();
        new Thread(evenJob).start();
    }

    private static class ThreadStateHolder {

        private volatile boolean isEven = true;


    }
}
