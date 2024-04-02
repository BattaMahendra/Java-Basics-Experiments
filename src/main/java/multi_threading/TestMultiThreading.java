package multi_threading;

import java.util.concurrent.CountDownLatch;

public class TestMultiThreading {


    public static void main(String[] args) {

       // testThreadPriority();
        CountDownLatch latch = new CountDownLatch(1);
        ConcurrentThreads c1 = new ConcurrentThreads("c1",latch);
        ConcurrentThreads c2 = new ConcurrentThreads("c2",latch);
        ConcurrentThreads c3 = new ConcurrentThreads("c3",latch);
        c1.setPriority(9);
        c2.setPriority(6);
        c3.setPriority(10);
        startGivenThread(c1);
        startGivenThread(c2);
        startGivenThread(c3);
        latch.countDown();



    }

    private static void testThreadPriority() {
        Thread t1 = new Thread(new CustomRunnable(), "T1");
        Thread t2 = new Thread(new CustomRunnable(), "T2");
        Thread t3 = new Thread(new CustomRunnable(), "T3");
        t1.setPriority(9);
        t2.setPriority(6);
        t3.setPriority(1);
        startGivenThread(t1);
        startGivenThread(t2);
        startGivenThread(t3);
    }

    private static void printThreadState(Thread... t) {
        for (Thread thread : t) {
            System.out.println("Current thread is "
                    + thread.getName() + " and thread state is "
                    + thread.getState());
        }

    }

    private static void startGivenThread(Thread t) {
        System.out.println("Starting the " + t.getName());
        t.start();
    }


    private static void joinGivenThread(Thread t) {
        System.out.println("Joining the " + t.getName());
        try {
            t.join(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
