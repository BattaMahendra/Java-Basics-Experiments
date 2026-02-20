package multi_threading.re_entrant_locks;

import multi_threading.Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Test {

    /*
    * Reentrant locks are manual, more controlled, more feature rich alternative to synchronized blocks/methods.
    *
    * Advantages:
    * tryLock():boolean ==> other threads can use it and check whether lock is free or not and can proceed.
    * tryLock(time):boolean  ==> time out variant of above method
    * Fairness policy: Generally in synchronized blocks/methods any thread can acquire the lock. It is same in reentrant lock also.
    *                  But we can ensure manually so that long-awaiting/starved threads are given first priority
    *                  Eg: Lock l = new ReentrantLock(true); ==> passing true in constructor specifies true for fairness policy.
    * */
    private final ReentrantLock lock = new ReentrantLock();

    int count1 = 0;
    int count2 = 0;
    AtomicInteger ai = new AtomicInteger();

    public void perform1(){

        System.out.println(Thread.currentThread().getName() + " entering into method: perform1()");  // non synchronized code
        try { Thread.sleep(1); } catch (Exception e) {}
        count1++;

        lock.lock();  // thread acquired the lock
        try{
            count2++;
            ai.incrementAndGet();
        }finally {
            lock.unlock();  // thread released the lock
        }
    }

    /*
    * Major disadvantage compared to synchronized blocks/methods
    * We should always use try-finally blocks to ensure that lock is unlocked. We need to do it  manually. Otherwise lock is held*/


    public static void main(String[] args) {
        Test obj = new Test();
        ExecutorService es = Executors.newWorkStealingPool(12);
        IntStream.range(0,2000).forEach(i -> {
            es.submit(obj::perform1);
        });



        try{Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);} ;

        es.shutdown();
        System.out.println("\n count1 : "+obj.count1+"\n count2 : "+obj.count2+"\n atomicInteger : "+obj.ai.get());


    }
}
