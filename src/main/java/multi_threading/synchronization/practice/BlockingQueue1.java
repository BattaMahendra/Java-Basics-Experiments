package multi_threading.synchronization.practice;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BlockingQueue1<T> {

    private final int capacity;
    private final LinkedList<T> linkedList;

    public BlockingQueue1(int capacity){
        this.capacity = capacity;
        this.linkedList = new LinkedList<T>();
    }

    public synchronized  boolean offer( T t) throws InterruptedException {

       // Objects.requireNonNull(t);
        try{Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
        while (linkedList.size() == capacity){
            wait();
        }


        boolean b = linkedList.offer(t);
        notify();

        System.out.println("Adding to  Queue : "+ t + " : "+ b);
        return b;
    }

    public synchronized T  poll() throws InterruptedException {

        while(linkedList.isEmpty()){
            wait();
        }
        T t = linkedList.poll();
        notify();
        System.out.println("Consuming value: "+t);
        return t;
    }

    public static void main(String[] args) {

        BlockingQueue1<Integer> bq = new BlockingQueue1<>(5);

        Runnable produce = () -> {
            IntStream.range(0,6).forEach(i -> {
                try {

                    bq.offer(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        };
        Runnable consume = () -> {
            IntStream.range(0,6).forEach(i -> {
                try {
                     bq.poll();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        };



        Thread producer = new Thread(produce);
        Thread consumer = new Thread(consume);

        producer.start();
        consumer.start();


    }


}
