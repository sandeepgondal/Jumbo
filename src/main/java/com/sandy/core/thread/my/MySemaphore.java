package com.sandy.core.thread.my;

/**
 * Created by gondals on 30/08/16.
 */
public class MySemaphore {

    private Holder holder;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("MySemaphore");

        MySemaphore mySemaphore = new MySemaphore(5);

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    mySemaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Thread(() -> System.out.println("Got semaphore")).start();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                mySemaphore.release();
                new Thread(() -> System.out.println("Released semaphore")).start();
            }
        }).start();
    }

    public MySemaphore(int bound) {
        holder = new Holder(bound);
    }

    private class Holder {
        private int bound;
        private int count;

        public Holder(final int bound) {
            this.bound = bound;
            this.count = bound;
        }
    }

    public void acquire() throws InterruptedException {
        synchronized (holder) {
            while (true) {
                if (holder.count <= 0)
                    holder.wait();
                else
                    break;
            }
            holder.count--;
            holder.notifyAll();
        }
    }

    public synchronized void release() {
        synchronized (holder) {
            while (true) {
                if (holder.count >= holder.bound) {
                    try {
                        holder.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else
                    break;
            }
            holder.count++;
            holder.notifyAll();
        }
    }

    public int availablePermits() {
        return holder.count;
    }
}
