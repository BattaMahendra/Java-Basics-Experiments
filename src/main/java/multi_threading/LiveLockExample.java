package multi_threading;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;


/*
* - Livelock is another concurrency problem and is similar to deadlock.
* - In livelock, two or more threads keep on transferring states between one another instead of waiting infinitely as we saw in the deadlock example.
* - Consequently, the threads are not able to perform their respective tasks.

*  A great example of livelock is a messaging system where, when an exception occurs,
*  the message consumer rolls back the transaction and puts the message back to the head of the queue.
*  Then the same message is repeatedly read from the queue, only to cause another exception and be put back on the queue.
*  The consumer will never pick up any other message from the queue.
* */

public class LiveLockExample {




    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Unwanted Message");

        MessageListener processor = new MessageListener(queue, "Unwanted Message");

        /*
         * We can create Threads using lambda ==>
         *  Thread processingThread = new Thread(() -> processor.processMessages());
         * but as the processMessage() method doesn't take any parameter and also doesn't return anything
         * it is same as run() method in runnable , so we can modify the above lambda to following
         * method reference
         * */
        Thread processingThread = new Thread(processor::processMessages);
        processingThread.start();

    }
}

class MessageListener {
    private final Queue<String> queue;
    private final String incomingMessage;

    public MessageListener(Queue<String> queue, String unwantedMessage) {
        this.queue = queue;
        this.incomingMessage = unwantedMessage;
    }

    public void processMessages() {
        while (!queue.isEmpty()) {
            String message = queue.poll();
            System.out.println("Received message: " + message);

            //check whether the message is proper and if not roll it back to queue
            if (message.equals(incomingMessage)) {
                try {
                    throw new RuntimeException("Undesirable message");
                }catch (Exception ex) {
                    System.out.println("Encountered unwanted message. Re-adding to queue.");
                    //rollback the incoming message back to queue

                    queue.add(incomingMessage);
                }
            }

        }
    }
}




