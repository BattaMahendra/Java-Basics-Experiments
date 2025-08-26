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
 * - This method comes from Object class and it is a instance method
 * - The wait() method is used to make the current thread release the lock and go into a waiting state.
 * - The thread remains in the waiting state until another thread calls notify() or notifyAll() on the same object.
 * - After being notified, the thread must reacquire the lock before it can proceed.
 * - In this code, wait() is called inside the synchronized block to ensure that the current thread releases the lock
 *   and waits for the other thread to notify it.
 * - The wait() method releases the lock prior to waiting, and reacquires the lock prior to returning from the wait() method. This is done so that no race condition exists.
 * - This method should always be used in a synchronized method and moreover you should use it inside loop rather than if statement
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

/*
*  Why wait() method should always be called in while loop rather than if statement.
*
* We should always call wait() method inside loop rather than if statement because
*
* 1. Spurious wakeups
* - Usually the thread in wait() state wakes up when the active thread notifies it and gives away the lock
* - but in rare times the threads can directly wake up and proceed with the code from wait() method.
* - so to avoid this we keep wait() in loop so that it checks again and condition is met and it goes into wait() agaian
* - If the loop is not there then it directly proceeds with next statement after if condition.
*
* 2. Race conditions with notifyAll() method
* - When you check the waiting condition in the loop you ensure that the thread will test the condition after it wakes up to see if the condition still holds or not.
* - refer this article: https://www.java67.com/2019/05/why-wait-and-notify-method-should-be-called-in-loop-not-if-block.html
* */
