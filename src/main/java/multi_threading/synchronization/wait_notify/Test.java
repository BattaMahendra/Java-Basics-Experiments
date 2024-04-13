package multi_threading.synchronization.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Queue queue  = new Queue();
        List<String> messages = new ArrayList<>();
        messages.add("First Message");
        messages.add("second Message");
        messages.add("third Message");
        messages.add("Fourth Message");
        Sender sender = new Sender(messages ,queue);
        Thread receiver = new Thread(new Receiver(queue), "Receiver");
        sender.start();
        receiver.start();
    }
}
