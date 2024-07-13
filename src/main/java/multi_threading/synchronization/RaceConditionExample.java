package multi_threading.synchronization;


import java.util.concurrent.CountDownLatch;


/*
* Refer this article for race condition: https://www.baeldung.com/cs/race-conditions
*
* */

public class RaceConditionExample{

    /*
    * if you runt this program multiple times you get varied result, ideally you should get 300 but
    * it varies due to race condtion
    * */
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);
        Counter c = new Counter();
        CustomConcurrentThread t1 = new CustomConcurrentThread(c , "thread1", latch );
        CustomConcurrentThread t2 = new CustomConcurrentThread(c , "thread2", latch );
        CustomConcurrentThread t3 = new CustomConcurrentThread(c , "thread3", latch );

        t1.start();;
        t2.start();
        t3.start();
        latch.countDown();
        System.out.println("=====NOW RELEASE LATCH======");


    }
}

class Counter {
    private int count = 0;

    // Increment method that will be called by multiple threads at the same time
    // which leads to race condition
    public void increment(String threadName) {
        count = count + 1;
        System.out.println(threadName + " incremented count to " + getCount());
    }

    // Get method to return the current count
    public int getCount() {
        return count;
    }
}

class CustomConcurrentThread extends  Thread{

    public String name;
    public CountDownLatch latch;

    public Counter counter;

    public CustomConcurrentThread(Counter counter, String name , CountDownLatch latch){
        this.latch=latch;
        this.setName( name);
        this.counter = counter;
    }
    public void run(){


        try {
            System.out.printf(" %s  created, blocked by the latch...\n", getName());
            Thread.sleep(1000);
            latch.await();
            for (int i = 0; i < 100; i++) {
                counter.increment(Thread.currentThread().getName());
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}