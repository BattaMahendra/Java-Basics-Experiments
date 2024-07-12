package multi_threading;

public class JoinExample {

    public static void main(String[] args) throws InterruptedException {
        // Create Thread 1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 started");
                try {
                    Thread.sleep(1); // Simulate some work for 2 seconds
                    int i =0;
                    while(i <=100){

                        System.out.println("Thread 1 "+ ++i);
                        Thread.sleep(100);
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

                    System.out.println(Thread.currentThread()+" is running");
                    // Simulate some work for 1 second
                    Thread.sleep(1);
                    int i =0;
                    while(i <=100){

                        System.out.println("Thread 2 "+ ++i);
                        Thread.sleep(100);
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
        thread1.join();
        System.out.println("Joining the thread 1");

        System.out.println("Thread 1 has finished, so Thread 2 can start now");

        // Start Thread 2
        System.out.println("Joining the thread 2");
        thread2.join(); // Wait for Thread 2 to finish

        System.out.println("Thread 2 has finished, main thread exits");
    }
}
