package multi_threading.synchronization.producer_consumer_problem;

public class Test {

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(1);

        Producer p1 = new Producer("P1","Hello",queue);
        Producer p2 = new Producer("P2","world",queue);
        Producer p3 = new Producer("P3","How r u",queue);

        Consumer c1  = new Consumer("C1",queue);
        Consumer c2  = new Consumer("C2",queue);
        Consumer c3  = new Consumer("C3",queue);

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();


    }
}

class Producer extends Thread{
    private String message;
    private String name;

    private BlockingQueue queue;
    public Producer(String name , String message , BlockingQueue queue){
        this.message = message;
        this.name = name;
        this.queue = queue;
    }

    public void run(){
        try {
            this.queue.add(this.message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
