package multi_threading;

import basic.experiments.tricky.Main;

public class DeadLock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
        new Thread2().start();
        Thread.sleep(2000);
        System.out.println("\n\nNow both threads are waiting forever");
    }

    /*
    * In this situation Thread1 is waiting for lock2 to be acquired but lock 2 is already acquired by THread 2
    * and also THread 2 requires lock 1 which is already acquired by THread1
    * so both threads are stuck waiting for each other to release locks.
    *
    * solution
    *
    * you can avoid this situation by placing locks in same order in both threads.
    * i.e in Thread 2 you first used lock2 , instead use lock1 which solves the problem.
    * */

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread-1 acquired lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-1 interrupted.");
                }
                System.out.println("Thread-1 waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread-1 acquired lock2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread-1 interrupted.");
                    }
                }
                System.out.println("Thread-1 releases lock2");
            }
            System.out.println("Thread-1 releases lock1");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread-2 acquired lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-2 interrupted.");
                }
                System.out.println("Thread-2 waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Thread-2 acquired lock1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread-2 interrupted.");
                    }
                }
                System.out.println("Thread-2 releases lock1");
            }
            System.out.println("Thread-2 releases lock2");
        }
    }
}