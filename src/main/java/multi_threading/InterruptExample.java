package multi_threading;

import java.util.stream.IntStream;

/**
 * interrupt() method used to interrupt the existing thread
 * calling it makes the interrupt flag in thread to true and that's it
 * thread continues to work. per suppose if thread is in TIMED_WAITING or WAITING  state then it will
 * throw interrupted exception
 *
 * To have a meaningful work of interrupt() method , you have to combine it with isInterrupted() method
 * it checks the flag and returns true or false
 *
 * Based on that you can programmatically modify whatever you want*/
public class InterruptExample {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            for(int i=0; i<10000; i++){
                ThreadOperations.sleepGivenThread(Thread.currentThread(), 10);
                System.out.println("Thread on loop: "+i);
            }
        });

        t1.start();

        //calling interrupt() on the thread
        // this doesn't guarantee that thread will stop
        //combining with isInterrupted() method , you can programmatical difference
        ThreadOperations.interruptGivenThread(t1);

        if(t1.isInterrupted()){
            System.out.println("The isInterrupted() of thread: "+t1.getName()+ " is "+ t1.isInterrupted());
            //here you can make any program if you want to
            System.out.println(" we have interrupted the thread");
        }

        IntStream.range(0,10).forEach(i ->{
            ThreadOperations.sleepGivenThread(Thread.currentThread(), 100);
            System.out.println(Thread.currentThread().getName()+ " executing loop "+ i);
        });

    }
}



