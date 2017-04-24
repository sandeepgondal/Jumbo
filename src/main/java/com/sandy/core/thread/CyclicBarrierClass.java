package com.sandy.core.thread;

import com.sandy.core.thread.my.MyCyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by gondals on 01/08/16.
 */
public class CyclicBarrierClass {

    public static void main(String[] args) {
        System.out.println("Welcome to cyclic barrier");

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("Done with all the threads"));
        MyCyclicBarrier cyclicBarrier = new MyCyclicBarrier(5, () -> System.out.println("Done with all the threads"));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("Starting a thread");
                try {
                    Thread.sleep(new Random().nextInt(5) * 1000);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
            }).start();
        }

        System.out.println("Done with main method");
    }
}
