package multi_threading;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    static int unsafeCounter =0;

    static AtomicInteger atomicCounter = new AtomicInteger(0);

    static volatile  int volatileInteger =0;

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();




    /*
    * You can observe by running below program only atomic will give you accurate results
    * You can still use synchronized instead of Atomic but it is more costly as it locks and suspends threads
    * So Atomic variables are always preferred
    *
    * here the volatile fails because of race condition between threads
    * go and read more about it in the Theory file in this package
    * */
    static  void process() {

        int max = 1_000_00_00;
        max = 1000;

        threadLocal.set(0);


        for (int i = 0; i < max; i++) {
            unsafeCounter++;
            atomicCounter.getAndIncrement();
            volatileInteger++;
            threadLocal .set( threadLocal.get()+1);

        }

        System.out.println("Current thread:"+Thread.currentThread().getName()+" threadLocal :"+threadLocal.get());
        System.out.println("Current thread:"+Thread.currentThread().getName()+" normal variable :"+unsafeCounter);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(Atomic::process);
        Thread t2 = new Thread(Atomic::process);
        Thread t3 = new Thread(Atomic::process);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("\n Ideal count of every opertion should be 3000\n");
        System.out.println("Normal integer after operation : "+unsafeCounter);
        System.out.println("Atomic integer after operation : "+ atomicCounter);
        System.out.println("Volatile integer after operation : "+volatileInteger);
        //it will be null for this statement as this is executed by main thread
        System.out.println("ThreadLocal integer after operation : "+threadLocal.get());



    }

}


