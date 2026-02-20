package multi_threading.synchronization.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Test {

    public synchronized  void perform1(){
        IntStream.range(0,10).forEach(i ->{
            try{ Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("perform1() : "+Thread.currentThread().getName() );
        });

    }

    public  synchronized  void perform2(){
        IntStream.range(0,10).forEach(i ->{
            try{ Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("perform2() : "+Thread.currentThread().getName() );
        });
    }

    public void testingReentrantLock(){
        Lock lock = new ReentrantLock();

        lock.lock();
        try{
            // some necessary code
        } finally {
            lock.unlock();
        }



    }


    public static void main(String[] args) {

        Test obj1 = new Test();
        Test obj2 = new Test();





        Thread t1 = new Thread(() -> obj1.perform1());
        Thread t2 = new Thread(() -> obj1.perform2());


        t1.start();
       // t2.start();
    }
}

