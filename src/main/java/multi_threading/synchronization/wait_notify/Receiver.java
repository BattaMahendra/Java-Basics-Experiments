package multi_threading.synchronization.wait_notify;

public class Receiver  implements  Runnable{

    private Queue queue;
    public Receiver(Queue queue){
        this.queue =queue;
    }
    @Override
    public void run() {
        queue.receive();
    }
}
