package com.sandy.core.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by gondals on 16/09/16.
 */
public class CountDownLatchClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is count down latch");

        final int threads = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threads);

        Runnable r = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
            countDownLatch.countDown();
        };


        for (int i = 0; i < threads; i++) {
            new Thread(r).start();
        }

        countDownLatch.await();
        System.out.println("Done processing all threads");

    }

}
