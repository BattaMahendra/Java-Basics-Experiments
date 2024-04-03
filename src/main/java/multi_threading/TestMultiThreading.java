package multi_threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMultiThreading {


    public static void main(String[] args) throws InterruptedException {

        testThreadPriority();
        Thread.sleep(5000);
        testThreadPriorityWithConcurrentThreads();
        testExecutorServices();


    }

    private static void testExecutorServices() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("\n\n==================================================");
        System.out.println("Testing threads using Executor Service");
        System.out.println("==================================================");
        //ExecutorService myThreadPool =  Executors.newFixedThreadPool(2);
        ExecutorService myThreadPool =  Executors.newCachedThreadPool();
        Thread t1 = new Thread(new CustomRunnable(), "T1");
        Thread t2 = new Thread(new CustomRunnable(), "T2");
        Thread t3 = new Thread(new CustomRunnable(), "T3");
        Thread t4 = new Thread(new CustomRunnable(), "T4");
        myThreadPool.execute(t1);
        myThreadPool.execute(t2);
        myThreadPool.execute(t3);
        myThreadPool.execute(t4);
    }

    /*
    * We used this method to run all the threads at the exact time
    * so that we can differentiate the thread priorities
    * If suppose all the threads are running at the same time then
    * the threads with higher priority runs first
    * If two or more threads having same priority are run at once then JVM follows
    * first come first serve method
    *
    *  */
    private static void testThreadPriorityWithConcurrentThreads()  {

        System.out.println("\n\n==================================================");
        System.out.println("Testing thread priority using concurrent threads");
        System.out.println("==================================================");
        CountDownLatch latch = new CountDownLatch(1);
        ConcurrentThreads c1 = new ConcurrentThreads("c1",latch);
        ConcurrentThreads c2 = new ConcurrentThreads("c2",latch);
        ConcurrentThreads c3 = new ConcurrentThreads("c3",latch);
        ConcurrentThreads c4 = new ConcurrentThreads("c4",latch);
        ConcurrentThreads c5 = new ConcurrentThreads("c5",latch);



        /*
        setting priorities to threads
        * 10 is highest and 1 is lowest and 5 is normal
        *If we don't assign any priorities manually then JVM usually assigns
        * 5 as the priority
         Learn more here: https://www.javatpoint.com/thread-scheduler-in-java
         */
        c1.setPriority(8);
        c2.setPriority(1);
        c3.setPriority(1);
        c4.setPriority(10);
        c5.setPriority(10);

        startGivenThread(c1);
        startGivenThread(c2);
        startGivenThread(c3);
        startGivenThread(c4);
        startGivenThread(c5);
        //latch starts counting down from 1 to 0
        latch.countDown();
        System.out.println("=====NOW RELEASE LATCH======");
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
