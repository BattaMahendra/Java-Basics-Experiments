package multi_threading.synchronization.wait_notify.practice;

import lombok.SneakyThrows;

import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {

        IntStream stream = IntStream.rangeClosed(1,100);
        Queue q = new Queue();
        Runnable send = ()->{
            createMessages(q);
        };

        Runnable receive = ()->{
            try {
                q.receive();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread sender = new Thread(send);

        sender.start();

    }

    @SneakyThrows
    private  static void createMessages(Queue q) {
        IntStream stream = IntStream.rangeClosed(1,100);

        stream.forEach(i -> {
            try {
                q.send(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
