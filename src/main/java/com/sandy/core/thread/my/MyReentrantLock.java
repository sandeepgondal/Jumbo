package com.sandy.core.thread.my;

/**
 * Created by gondals on 30/08/16.
 */
public class MyReentrantLock {

    volatile private StateHolder stateHolder = new StateHolder(false);

    public static void main(String[] args) {
        System.out.println("Hello Locking");

        MyReentrantLock myLock = new MyReentrantLock();

        new Thread(() -> {
            System.out.println("This is first thread");

            try {
                myLock.lock();
                Thread.sleep(2000);
                myLock.lock();
                System.out.println("Got lock .. working thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    myLock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 1")
        .start();

        new Thread(() -> {
            System.out.println("This is second thread");

            try {
                Thread.sleep(100);
                myLock.lock();
                Thread.sleep(1000);
                System.out.println("Got lock .. working thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    myLock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 2")
        .start();
    }

    public void lock() throws InterruptedException {
        synchronized (stateHolder) {
            if (stateHolder.currentThread == Thread.currentThread())
                return;

            if (stateHolder.isLocked && stateHolder.currentThread != Thread.currentThread())
                stateHolder.wait();

            stateHolder.isLocked = true;
            stateHolder.currentThread = Thread.currentThread();
            stateHolder.notifyAll();
        }
    }

    public void unlock() throws InterruptedException {
        synchronized (stateHolder) {
            if (!stateHolder.isLocked)
                stateHolder.wait();
            stateHolder.isLocked = false;
            stateHolder.currentThread = null;
            stateHolder.notifyAll();
        }
    }

    private class StateHolder {
        private boolean isLocked;
        private Thread currentThread;

        public StateHolder(final boolean state) {
            isLocked = state;
        }
    }
}
