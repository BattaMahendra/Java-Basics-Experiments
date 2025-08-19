package multi_threading;

import java.util.concurrent.CountDownLatch;

public class ConcurrentThreads extends  Thread{

    public String name;
    public CountDownLatch latch;
    private int waitTime;

    public ConcurrentThreads(String name , CountDownLatch latch, int waitTime){
        this.latch=latch;
        this.setName( name);
        this.waitTime = waitTime;
    }
    public void run(){


        try {
            System.out.printf(" %s  created, blocked by the latch...\n", getName());
            Thread.sleep((1000L *this.waitTime));
            latch.await();
            System.out.println("Current thread is "
                    + Thread.currentThread().getName()+" with thread priority "+
                    Thread.currentThread().getPriority()+
                    " at exact time   "+ System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
