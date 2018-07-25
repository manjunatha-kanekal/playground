package org.basics;

public class OddEvenMultiThreading implements Runnable {
    private final Object lock;
    private volatile static int i = 1;

    private OddEvenMultiThreading(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (i <= 10) {
            if ((i % 2) == 0 && Thread.currentThread().getName().equals("Even")) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    i++;
                    try {
                        if (i < 11) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if ((i % 2) == 1 && Thread.currentThread().getName().equals("Odd")) {
                synchronized (lock) {
                    if (i < 11) {
                        System.out.println(Thread.currentThread().getName() + " - " + i);
                        i++;
                        lock.notify();
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Object lock = new Object();
        OddEvenMultiThreading odd = new OddEvenMultiThreading(lock);
        OddEvenMultiThreading even = new OddEvenMultiThreading(lock);

        Thread oddThread = new Thread(odd);
        Thread evenThread = new Thread(even);

        oddThread.setName("Odd");
        evenThread.setName("Even");

        oddThread.start();
        evenThread.start();
    }
}
