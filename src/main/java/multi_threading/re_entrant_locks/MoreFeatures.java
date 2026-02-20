package multi_threading.re_entrant_locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MoreFeatures {

    private Lock reentrantLock = new ReentrantLock(true);
    /*
    * The above constructor with true ensures that fairness is practised in the locks.
    * i.e The threads which are starving/long-awaited are given priority based on waiting time.
    * But there will be performance impact due to it.
    *
    * By default reentrant locks have no fairness. But by specifying true in constructor we can turn on fairness*/


    /*
    * This is arguably the most useful feature.
    *  It prevents "thread hanging" by allowing a thread to check if a lock is available before committing to a wait.
    *
    *  We also have timeout variant in the tryLock() */

    public void print1(){

        reentrantLock.lock();
        if(reentrantLock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " entering into method: perform1()");
            } finally {
                reentrantLock.unlock();
            }
        }else{
            System.out.println("Could not acquire lock");
        }
    }

    public void print2() throws InterruptedException {

        reentrantLock.lock();
        if(reentrantLock.tryLock(2, TimeUnit.SECONDS)) {         // tryLock with timeout
            try {
                System.out.println(Thread.currentThread().getName() + " entering into method: perform1()");
            } finally {
                reentrantLock.unlock();
            }
        }else{
            System.out.println("Timeout while waiting for lock ==> Could not acquire lock");
        }
    }
}
