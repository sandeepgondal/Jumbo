package com.sandy.core.thread;

import com.sandy.core.thread.my.MySemaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Created by gondals on 01/08/16.
 */
public class SemaphoreClass {

    public static void main(String[] args) {
        System.out.println("Welcome to Semaphore");

//        Semaphore semaphore = new Semaphore(5);
        MySemaphore semaphore = new MySemaphore(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            // This is executed when both main producer and consumer threads are executed
            System.out.println("Available permits: " + semaphore.availablePermits());
        });

        new Thread(() -> {
            System.out.println("Producers");

            // Create producer threads
            for (int i = 0; i < 100; i++) {
                try {
                    semaphore.acquire();
                    new Thread(() -> System.out.println("Producer")).start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // wait this main producer thread on a cyclic barrier
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("Consumers");

            // Create consumer threads
            for (int i = 0; i < 100; i++) {
                semaphore.release();
                new Thread(() -> System.out.println("Consumer")).start();
            }

            // wait this main consumer thread on a cyclic barrier
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
