package multi_threading.synchronization.wait_notify.practice;

public class Queue {

    private int data;

    public boolean available = false;

    public synchronized void send(int message) throws InterruptedException {

        while (available){
            wait();
        }
        data = message;
        System.out.println(" Message sent : "+ message);
        available = true;
        notifyAll();

    }

    public synchronized void receive() throws InterruptedException {

        while(!available){
            wait();
        }
        System.out.println(" Message received : "+data);
        available = false;
        notifyAll();
    }
}
