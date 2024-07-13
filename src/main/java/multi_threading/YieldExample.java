package multi_threading;


/*
* The yield method in Java is a static method of the Thread class
* It is used to hint to the thread scheduler that the current thread is willing to yield its current use of the CPU.
*  This can allow other threads of the same priority to run.
*  It's important to note that yield is a hint to the thread scheduler,
* and there is no guarantee that the scheduler will actually pause the current thread or that it will allow other threads to run.
*
* Here are some key points about the yield method:

 - Purpose: yield is used to improve the performance of multi-threaded programs by allowing a running thread to pause and let other threads of the same priority execute.

 - Voluntary Pause: When a thread calls yield, it is voluntarily pausing and allowing the thread scheduler to select another thread to run. The current thread goes back to the runnable state, and the scheduler may or may not schedule another thread to run.

 - No Guarantee: There is no guarantee that calling yield will result in a context switch. The thread scheduler is free to ignore the hint.

 - Same Priority: Typically, yield only makes sense for threads with the same priority. It gives a chance for other threads of the same priority to execute.
* */
public class YieldExample {
    public static void main(String[] args) {
        Thread producerThread = new Thread(new TaskProducer(), "TaskProducer Thread");
        Thread consumerThread = new Thread(new TaskConsumer(), "TaskConsumer Thread");

        producerThread.start();
        consumerThread.start();
    }
}

class TaskProducer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " producing: " + i);
            // Yield control to other threads
            Thread.yield();
        }
    }
}

class TaskConsumer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " consuming: " + i);
            // Yield control to other threads
            Thread.yield();
        }
    }
}
