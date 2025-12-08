package multi_threading.Volatile;

class Worker implements Runnable {

    // add and remove volatile keyword here and observe
    boolean running = true;

    @Override
    public void run() {
        System.out.println("Worker started...");

        while (running) {     // Thread may cache this and never stop
            System.out.println(Thread.currentThread().getName()+" running ");             // Without volatile thread may run endlessly even after main finished
        }

        System.out.println("Worker stopped");
    }

    public void stop() {
        running = false;
    }
}

public class VolatileTest {
    public static void main(String[] args) throws Exception {

        Worker worker = new Worker();
        Thread t = new Thread(worker);
        t.start();

       // Thread.sleep(1000);

        System.out.println("Stopping thread...");
        worker.stop();   // may NOT be seen by thread t

        System.out.println("Main finished");
    }
}
