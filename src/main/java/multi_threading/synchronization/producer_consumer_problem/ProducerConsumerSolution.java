package multi_threading.synchronization.producer_consumer_problem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer Consumer Problem solution using BlockingQueue in Java.
 * BlockingQueue not only provide a data structure to store data
 * but also gives you flow control, require for inter thread communication.
 * 
 * @author Javin Paul
 */
public class ProducerConsumerSolution {

    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();
        
        producer1 p = new producer1(sharedQ);
        Consumer1 c = new Consumer1(sharedQ);
        
        p.start();
        c.start();
    }
}

class producer1 extends Thread {
    private BlockingQueue<Integer> sharedQueue;

    public producer1(BlockingQueue<Integer> aQueue) {
        super("PRODUCER");
        this.sharedQueue = aQueue;
    }

    public void run() {
        // no synchronization needed
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
                System.out.println(getName() + " produced " + i);
                sharedQueue.put(i);
                //Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consumer1 extends Thread {
    private BlockingQueue<Integer> sharedQueue;

    public Consumer1(BlockingQueue<Integer> aQueue) {
        super("CONSUMER");
        this.sharedQueue = aQueue;
    }

    public void run() {
        try {
            while (true) {
                Integer item = sharedQueue.take();
                System.out.println(getName() + " consumed " + item);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}