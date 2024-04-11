package multi_threading.synchronization.producer_consumer_problem;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<String> cloudQueue;
    private int capacity;

    public BlockingQueue(int capacity){
        cloudQueue= new LinkedList<>();
        this.capacity =capacity;
    }

    public boolean add(String toBeAdded) throws InterruptedException {
        synchronized (cloudQueue) {
            while (cloudQueue.size() == capacity) {
                cloudQueue.wait();
            }
            cloudQueue.add(toBeAdded);
            cloudQueue.notifyAll();
            System.out.println(cloudQueue);
            return true;

        }
    }

    public String remove() throws InterruptedException {
        synchronized (cloudQueue) {
            while (cloudQueue.size() == 0) {
                cloudQueue.wait();
            }
            String removedElement = cloudQueue.poll();
            cloudQueue.notifyAll();
            System.out.println(cloudQueue);
            return removedElement;

        }

    }
}
