package multi_threading.synchronization.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Sender extends Thread{
    List<String> messagesList = new ArrayList<>();
    private Queue queue;

    public Sender(List<String> listOfMessagesToBeSent, Queue queue){
        this.messagesList = listOfMessagesToBeSent;
        this.queue=queue;

    }

    public  void run(){
        Sender.currentThread().setName("Sender");
        messagesList.stream().forEach(eachMessage -> {
            queue.send(eachMessage);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
