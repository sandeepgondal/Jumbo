package com.sandy.core.thread.my;

/**
 * Created by gondals on 30/08/16.
 */
public class MyLock {

    private LockHolder lockHolder = new LockHolder();

    public static void main(String[] args) {
        System.out.println("Hello Locking");

        MyLock myLock = new MyLock();

        new Thread(() -> {
            System.out.println("This is first thread");

            try {
                myLock.lock();
                Thread.sleep(2000);
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
        })
        .start();

        new Thread(() -> {
            System.out.println("This is second thread");

            try {
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
        })
        .start();

    }

    private class LockHolder {
        private boolean isLocked = false;
    }

    public void lock() throws InterruptedException {
        synchronized (lockHolder) {
            if (lockHolder.isLocked)
                lockHolder.wait();

            lockHolder.isLocked = true;
            lockHolder.notifyAll();
        }
    }

    public void unlock() throws InterruptedException {
        synchronized (lockHolder) {
            if (!lockHolder.isLocked)
                lockHolder.wait();
            lockHolder.isLocked = false;
            lockHolder.notifyAll();
        }
    }
}
