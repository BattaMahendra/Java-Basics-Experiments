package multi_threading.synchronization;


import multi_threading.CustomConcurrentTask;
import multi_threading.Task;

import java.awt.*;
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

        Counter c = new Counter();

        Task task = (threadName) -> {
            for (int i = 0; i < 100; i++) {
                c.increment(threadName);
            }
        };

        CountDownLatch latch = new CountDownLatch(1);

        CustomConcurrentTask t2 = new CustomConcurrentTask(task , "thread2", latch );
        CustomConcurrentTask t3 = new CustomConcurrentTask(task , "thread3", latch );
        CustomConcurrentTask t1 = new CustomConcurrentTask(task , "thread1", latch );

        t1.run();
        t2.run();
        t3.run();
        latch.countDown();
        System.out.println("=====NOW RELEASE LATCH======");


    }
}

/*
* In Java, a race condition occurs when two or more threads can access shared data and they try to change it at the same time.
* Since the thread scheduling algorithm can swap between threads at any time,
* you don't know the order in which the threads will attempt to access the shared data.
* This can lead to unexpected results and bugs that are hard to reproduce and fix.
*
* There are two types of race conditions
* 1. Read and Write
* 2. Check and modify
*
* Below we have given example of read and write
* */

class Counter {
    private int count = 0;

    // Increment method that will be called by multiple threads at the same time
    // which leads to race condition
    public void increment(String threadName) {
        //this below operation is not atomic because it contains multiple operations
        //i.e read and then write and then modify , so there is a possibility of race condition here
        count = count + 1;
        System.out.println(threadName + " incremented count to " + getCount());
    }

    // Get method to return the current count
    public int getCount() {
        return count;
    }
}

