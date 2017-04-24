package com.sandy.core.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by gondals on 01/08/16.
 */
public class ExecutorServiceClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to Executor Service");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println("Running a thread");
                try {
                    Thread.sleep(new Random().nextInt(5) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Done with main 1");
        executorService.awaitTermination(23, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("Done with main 2");
    }

}
