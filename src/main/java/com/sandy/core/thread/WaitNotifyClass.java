package com.sandy.core.thread;

/**
 * Created by gondals on 30/08/16.
 */
public class WaitNotifyClass {

    public static void main(String[] args) {
        System.out.println("Hello Wait Notify");

        MyObject myLock = new MyObject();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is thread 1");

                try {
                    myLock.doWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("After wait");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is thread 2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Before Notify");
                myLock.doNotify();
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();

    }

    static class MyObject {
        String myLock = new String();
        boolean isNotified = false;

        public void doWait() throws InterruptedException {
            if (!isNotified) {
                synchronized (myLock) {
                    myLock.wait();
                }
                isNotified = false;
            }
        }

        public void doNotify() {
            synchronized (myLock) {
                isNotified = true;
                myLock.notify();
            }
        }
    }
}
