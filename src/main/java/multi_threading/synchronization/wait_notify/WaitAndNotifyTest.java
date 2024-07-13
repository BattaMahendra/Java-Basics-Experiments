package multi_threading.synchronization.wait_notify;

public class WaitAndNotifyTest {

    public static void main(String[] args) {

        DisplayNumbers object = new DisplayNumbers();

        // Create a thread to print even numbers
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    object.printEvenNumbers(10); // Print even numbers up to 10
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // Create a thread to print odd numbers
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    object.printOddNumbers(10); // Print odd numbers up to 10
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start(); // Start the thread to print even numbers
        t2.start(); // Start the thread to print odd numbers
    }
}

class DisplayNumbers {
    int counter = 0; // Shared counter variable

    // Method to print odd numbers
    public void printOddNumbers(int num) throws InterruptedException {
        synchronized (this) { // Synchronize on the current object to ensure mutual exclusion
            while (counter <= num) {
                if (counter % 2 != 0) { // Check if the counter is odd
                    System.out.println(counter + " ");
                    notify(); // Notify the waiting even number thread to proceed
                }
                counter++; // Increment the counter
                wait(); // Release the lock and wait for the even number thread to notify
            }
        }
    }

    // Method to print even numbers
    public void printEvenNumbers(int num) throws InterruptedException {
        synchronized (this) { // Synchronize on the current object to ensure mutual exclusion
            while (counter <= num) {
                System.out.println("for observation");
                if (counter % 2 == 0) { // Check if the counter is even
                    System.out.println(counter + " ");
                    notify(); // Notify the waiting odd number thread to proceed
                }
                counter++; // Increment the counter
                wait(); // Release the lock and wait for the odd number thread to notify
            }
        }
    }
}

/*
 * Explanation of wait() and notify():
 *
 * 1. wait():
 * - The wait() method is used to make the current thread release the lock and go into a waiting state.
 * - The thread remains in the waiting state until another thread calls notify() or notifyAll() on the same object.
 * - After being notified, the thread must reacquire the lock before it can proceed.
 * - In this code, wait() is called inside the synchronized block to ensure that the current thread releases the lock
 *   and waits for the other thread to notify it.
 *
 * 2. notify():
 * - The notify() method is used to wake up a single thread that is waiting on the same object.
 * - If multiple threads are waiting, only one of them is chosen to be awakened.
 * - The awakened thread must reacquire the lock before it can proceed.
 * - In this code, notify() is called to wake up the other thread that is waiting after the current thread finishes its task.
 *
 * The combination of wait() and notify() ensures that the two threads coordinate with each other, allowing one thread to
 * proceed only after the other has completed its task and released the lock.
 */
