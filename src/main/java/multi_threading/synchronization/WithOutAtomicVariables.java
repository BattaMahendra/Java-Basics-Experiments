package multi_threading.synchronization;

import multi_threading.ThreadOperations;

import java.util.concurrent.atomic.AtomicInteger;

/*
* Ideally our counter should get increment by 10 times so it values should be 10. And finally for loop of 10 times should give final value as 100
* but when we run this program multiple times we see varying values of 8,9,10 in the
* count variable. This is because the count variable is changed rapidly
*
* One solution to this problem is using synchronised keyword on the counter method
* but excessive usage of synchronised keyword comes at a performance cost in multi-threading operations
*
* So other solution is to use Atomic variables*/

public class WithOutAtomicVariables implements ThreadOperations {
    /*Comment and uncomment below instance variables
    when you want experiment about atomic variables uncomment line number 25 & 30 and comment 23 & 29
    and vice versa*/


    // private static int count;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void counter() {
        for (int i = 0; i <= 4; i++) {
//            count=count+1;
            count.getAndIncrement();
            System.out.println("This thread is " + Thread.currentThread().getName() +
                    " Incremented counter value " + count);
        }
    }



    public static void main(String[] args) {
        for(int i =0; i<=9; i++) {
            System.out.println("\n====================================================");
            WithOutAtomicVariables a1 = new WithOutAtomicVariables();
            Thread t1 = new Thread(new myRunnable(), "t1");
            Thread t2 = new Thread(new myRunnable(), "t2");
            a1.startGivenThread(t1);
            a1.startGivenThread(t2);
            a1.joinGivenThread(t1);
            a1.joinGivenThread(t2);
            System.out.println("\n" +
                    "Final count value is " +
                    count);
        }
    }
}
class myRunnable implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WithOutAtomicVariables.counter();
    }
}
