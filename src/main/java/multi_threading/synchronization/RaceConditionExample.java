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
    * it varies due to race condition
    * */
    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        // Defining the task (not yet executing)
        Task task = (threadName) -> {
            for (int i = 0; i < 10; i++) {
                c.increment(threadName);
            }

        };

        CountDownLatch latch = new CountDownLatch(1);

        CustomConcurrentTask c2 = new CustomConcurrentTask(task , "thread2", latch );
        CustomConcurrentTask c3 = new CustomConcurrentTask(task , "thread3", latch );
        CustomConcurrentTask c1 = new CustomConcurrentTask(task , "thread1", latch );

        int i = 0;
        /*
        * Simulating race condition multiple times by using do while loop*/
        do {
            Thread t1 = new Thread(c1);
            Thread t2 = new Thread(c2);
            Thread t3 = new Thread(c3);

            t1.start();
            t2.start();
            t3.start();
            latch.countDown();
            //Thread.sleep(1000);
            System.out.println("=====NOW RELEASE LATCH======");
            i++;
        }while (i < 10);
        Thread.sleep(3000);
        System.out.println("Final count of the counter: "+ c.getCount());


    }
}

/*
* In Java, a race condition occurs when two or more threads can access shared data and try to change it at the same time.
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
    private Integer integerObject = new Integer(0);

    // Increment method that will be called by multiple threads at the same time
    // which leads to race condition
    public  void increment(String threadName) {
        //this below operation is not atomic because it contains multiple operations
        //i.e read and then write and then modify , so there is a possibility of race condition here
        count = count + 1;
        integerObject = integerObject+1;
        System.out.println(threadName + " incremented count to " + getCount() +" and integerObject to :"+integerObject);
    }

    // Get method to return the current count
    public int getCount() {
        return count;
    }
}

