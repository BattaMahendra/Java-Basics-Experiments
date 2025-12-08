package multi_threading;

public class JoinExample {

    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println("The current executing thread : "+name);


        // Create Thread 1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 started");
                try {
                    Thread.sleep(1); // Simulate some work for 2 seconds
                    int i =0;
                    while(i <=10){

                        System.out.println("Thread 1 "+ ++i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 finished");
            }
        });

        // Create Thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 started");
                try {

                 //   thread1.join();  // Thread-2 waits until Thread-1 completes
                    System.out.println(Thread.currentThread()+" is running");
                    // Simulate some work for 1 second
                    Thread.sleep(1);
                    int i =0;
                    while(i <=10){

                        System.out.println("Thread 2 "+ ++i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 finished");
            }
        });


        // Start Thread 1
        thread1.start();
        thread2.start();
        // Wait for Thread 1 to finish using join()
        Thread.sleep(100);
        System.out.println("Joining the thread 1");
        thread1.join();  // main thread waits until thread-1 completes
        System.out.println("Thread 1 has finished, so Thread 2 can start now");

        // Start Thread 2
        System.out.println("Joining the thread 2");
        thread2.join(); // main thread waits until thread-1 completes


        System.out.println("Thread 2 has finished, main thread exits");

        /*
         * Generally Main thread will be running here
         *
         * If you use thread.join() on the same thread then its a deadlock
         * as the thread waits for itself to complete - which goes on forever*/

        Thread.currentThread().join();  // main thread waits for itself to complete - goes on forever - deadlock

        System.out.println("=================== MAIN THREAD EXITS ======================");
    }
}
