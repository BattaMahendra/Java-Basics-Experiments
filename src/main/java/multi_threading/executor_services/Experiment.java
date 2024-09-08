package multi_threading.executor_services;

import multi_threading.ExecutorServices;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Experiment {

   private static Runnable r = () -> {
       try {
           Thread.sleep(1000);
           System.out.println("Running thread simultaneously");
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   };

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        Future<Object> future1 = (Future<Object>) executorService.submit(r);
        Future<Object> future2 = (Future<Object>) executorService.submit(r);
        Future<Object> future3 = (Future<Object>) executorService.submit(r);
        Future<Object> future4= (Future<Object>) executorService.submit(r);
        Future<Object> future5 = (Future<Object>) executorService.submit(r);
        Future<Object> future6 = (Future<Object>) executorService.submit(r);

        while (!future1.isDone())
        System.out.println("Hello Main");

        executorService.shutdown();


    }
}
