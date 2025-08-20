package multi_threading.Volatile;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class VolatileUsage {

    // remove/add volatile keyword and observe the difference
    private  boolean flag = true;

    private int count = 0; // just to keep reference of loops


    public static void main(String[] args) throws InterruptedException {
        VolatileUsage obj = new VolatileUsage();

        // creating a runnable task which operates on the main flag of this class
        Runnable r = ()->{
            while(obj.flag) {
               // thread doing some actual work
                System.out.println(Thread.currentThread().getName()+ " running operation "+ obj.count++);
            }

        };

        //creating threads
        Thread t1 = new Thread(r, "t1");


        t1.start();





        //main thread modifies flag
        Thread.sleep(100);
        obj.flag = false;
        System.out.println("===========================Main thread finishes ======================");


    }


}
