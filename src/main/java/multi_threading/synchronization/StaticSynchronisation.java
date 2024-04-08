package multi_threading.synchronization;



import multi_threading.ConcurrentThreads;
import multi_threading.TestMultiThreading;
import multi_threading.ThreadOperations;

import java.util.concurrent.CountDownLatch;

public class StaticSynchronisation extends TestMultiThreading {

    /*
    * Try removing synchronised keyword and see the difference
    * */
    public static synchronized void printLoop() {

        for (int i = 0; i <= 10; i++) {
            System.out.println("This thread is " + Thread.currentThread().getName() + " wtih value " + i);
        }
    }

    public static void main(String[] args) {
        testThreadPriorityWithConcurrentThreads();
    }

    private static void testThreadPriorityWithConcurrentThreads()  {

        System.out.println("\n\n==================================================");
        System.out.println("Testing thread priority using concurrent threads");
        System.out.println("==================================================");
        CountDownLatch latch = new CountDownLatch(1);
        ConcurrentThread c1 = new ConcurrentThread("c1",latch);
        ConcurrentThread c2 = new ConcurrentThread("c2",latch);
        ConcurrentThread c3 = new ConcurrentThread("c3",latch);
        ConcurrentThread c4 = new ConcurrentThread("c4",latch);
        ConcurrentThread c5 = new ConcurrentThread("c5",latch);



        /*
        setting priorities to threads
        * 10 is highest and 1 is lowest and 5 is normal
        *If we don't assign any priorities manually then JVM usually assigns
        * 5 as the priority
         Learn more here: https://www.javatpoint.com/thread-scheduler-in-java
         */
        c1.setPriority(8);
        c2.setPriority(10);
        c3.setPriority(10);
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
}



 class ConcurrentThread extends  Thread{

    public String name;
    public CountDownLatch latch;

    public ConcurrentThread(String name , CountDownLatch latch){
        this.latch=latch;
        this.setName( name);
    }
    public void run(){


        try {
            System.out.printf(" %s  created, blocked by the latch...\n", getName());
            Thread.sleep(50);
            latch.await();
//            System.out.println("Current thread is "
//                    + Thread.currentThread().getName()+" with thread priority "+
//                    Thread.currentThread().getPriority()+
//                    " at exact time "+ System.currentTimeMillis());

            StaticSynchronisation.printLoop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

