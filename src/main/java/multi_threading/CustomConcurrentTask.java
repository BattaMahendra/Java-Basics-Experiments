package multi_threading;

import java.util.concurrent.CountDownLatch;

public class CustomConcurrentTask implements Runnable {

    private String name;
    private CountDownLatch latch;
    private Task task;

    public CustomConcurrentTask(Task task, String name, CountDownLatch latch) {
        this.task = task;
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s created, blocked by the latch...\n", name);
            Thread.sleep(1000);
            latch.await();
            task.execute(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

