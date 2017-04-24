package com.sandy.core.thread.my;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by gondals on 30/08/16.
 */
public class MyBlockingQueue<T> {

    private Queue<T> queue;
    private int bound;

    public MyBlockingQueue(final int bound) {
        queue = new ArrayDeque<T>();
        this.bound = bound;
    }

    public T take() {
        synchronized (queue) {
            if (queue.size() <= 0)
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            T poll = queue.poll();
            queue.notifyAll();
            return poll;
        }
    }

    public void put(T t) {
        synchronized (queue) {
            if (queue.size() >= bound)
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            queue.add(t);
            queue.notifyAll();
        }
    }
}
