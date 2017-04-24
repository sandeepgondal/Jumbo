package com.sandy.core.thread.my;

/**
 * Created by gondals on 17/09/16.
 */
public class MyCyclicBarrier {

    private int total;
    private int count;
    private Runnable runnable;

    public MyCyclicBarrier(final int total, final Runnable runnable) {
        this.total = total;
        this.count = 0;
        this.runnable = runnable;
    }

    synchronized public void await() {
        count++;
        if (count == total)
            new Thread(runnable).start();
    }

    public static void main(String[] args) {
        System.out.println("My Barrier");
        MyCyclicBarrier myCyclicBarrier = new MyCyclicBarrier(3, () -> System.out.println("Done with all threads"));


        myCyclicBarrier.await();
        myCyclicBarrier.await();
        myCyclicBarrier.await();

    }
}
