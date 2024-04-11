package multi_threading.synchronization.producer_consumer_problem;

public class Consumer extends Thread{

    private String name;

    private BlockingQueue queue;
    public Consumer(String name  , BlockingQueue queue){

        this.name = name;
        this.queue = queue;
    }

    public void run(){
        try {
            System.out.println("The removed message is "+this.queue.remove());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
