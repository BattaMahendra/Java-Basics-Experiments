package asynchronous;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorsLearning {

    /*
    * Thread Pool Executors:
    *   *   🔴 Thread pool is a collection of threads that can be reused to execute tasks.
    *  Creating threads manually is a tedious task as we need to maintain them.
    *  So we generally use Executor Service. But even underlying implementation inside ExecutorService
    *  is also ThreadPoolExecutors.
    *
    * Directly using ThreadPoolExecutors give us more control
    * */


    public static void creatingThreadPoolExecutors(){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // core pool size - minimum number of threads always maintained
                4, // maximum pool size
                60L, // keep-alive time for idle threads
                java.util.concurrent.TimeUnit.SECONDS, // time unit for keep-alive
                new LinkedBlockingQueue<>(), // queue to hold tasks
                new ThreadPoolExecutor.AbortPolicy() // handler for rejected tasks


        );

        // Submit 5 tasks to the executor
        for (int i = 1; i <= 15; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);  // Simulating a task that takes 1 second to complete
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
            });
        }

        // Gracefully shut down the executor after all tasks are completed
        executor.shutdown();

    }

    public static void main(String[] args) {

        creatingThreadPoolExecutors();

    }
}
