package multi_threading;

import java.util.concurrent.CountDownLatch;

public class ConcurrentThreads extends  Thread{

    public String name;
    public CountDownLatch latch;

    public ConcurrentThreads(String name , CountDownLatch latch){
        this.latch=latch;
        this.setName( name);
    }
    public void run(){


        try {
            System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
            Thread.sleep(500);
            latch.await();
            System.out.println("Current thread is "
                    + Thread.currentThread().getName()+
                    " at exact time "+ System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
