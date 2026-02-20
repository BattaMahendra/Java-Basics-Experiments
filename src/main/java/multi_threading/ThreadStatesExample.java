package multi_threading;

public class ThreadStatesExample {

    public static void main(String[] args) throws InterruptedException {
        // Create and start Thread 1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadStatesExample.class) {
                    // Simulate some work
                    try {
                        Thread.sleep(1000*10); // Thread 1 sleeps for 10000 milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Create and start Thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                // Simulate some work
                try {
                    Thread.sleep(2000); // Thread 2 sleeps for 2000 milliseconds
                    System.out.println("Thread-2 out of sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ThreadStatesExample.class) {
                   // some task
                }
            }
        });


        // Print initial states of both threads
        System.out.println("Thread 1 state after creation: " + thread1.getState());
        System.out.println("Thread 2 state after creation: " + thread2.getState());

        // Start Thread 1
        thread1.start();
        System.out.println("Thread 1 state after start() : " + thread1.getState());

        // Sleep briefly to allow Thread 1 to enter synchronized block
        Thread.sleep(50);
        System.out.println("Thread 1 state while running synchronized block: " + thread1.getState());

        // Start Thread 2 after Thread 1 has started
        thread2.start();
        System.out.println("Thread 2 state after starting: " + thread2.getState());

        // Sleep briefly to allow Thread 2 to enter TIMED_WAITING state
        Thread.sleep(50);
        System.out.println("Thread 2 state while sleeping (TIMED_WAITING): " + thread2.getState());

        System.out.println("Main thread state :"+ Thread.currentThread().getState());

        // Wait for Thread 2 to finish
        thread2.join();
        System.out.println("Thread 2 state after joining: " + thread2.getState());

        // Wait for Thread 1 to finish
        synchronized (ThreadStatesExample.class) {
            System.out.println("Thread 1 state before joining: " + thread1.getState());
        }
        thread1.join();
        System.out.println("Thread 1 state after joining: " + thread1.getState());

       
    }
}
