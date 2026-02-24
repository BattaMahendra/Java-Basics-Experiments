package collections.queue;

import multi_threading.synchronization.practice.BlockingQueue1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

public class ThreadSafeQueues {

    static final Integer h = new Integer(7);



    public static void main(String[] args) {




        BlockingQueue<Integer> bq = new LinkedBlockingDeque<>(1);
        // we can use other Queue implementations like new LinkedBlockingQueue(),  ArrayBlockingQueue(), new PriorityBlockingQueue()

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                IntStream.range(0,10).forEach(i ->{
                    try {
                        Thread.sleep(1000);
                        System.out.println("Producer putting: "+i);
                        bq.offer(i);

                    } catch (InterruptedException e) {throw new RuntimeException(e);}

                });
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                IntStream.range(0,10).forEach(s ->{
               try {
                   Thread.sleep(1000);
                   Integer i = bq.poll();
                   System.out.println("Consumer consuming : "+i);

               } catch (InterruptedException e) {
                   throw new RuntimeException(e.getCause());
               }

           });


            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();



    }
}
