package asynchronous;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CompletableFutures2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService = Executors.newCachedThreadPool();

        /*
        * Future represents only the result which will come in future
        * Future only stores the value which will be obtained after computation
        *
        * Completable future represents both result and as well as completion stage
        * */
        Future<Integer> f1 = executorService.submit(() -> 1);

            // Now what?
            // No thenApply
            // No thenCompose
            // No thenCombine

        Future<String> f = Executors.newCachedThreadPool().submit(()->{

            int i = 0;
            while(i < 100){
                sleep(1000);
                System.out.println("Running Future method : " + Thread.currentThread().getName());

            }
            return "Future Done!";
        });
        // Creating a simple completable future
        CompletableFuture<String> cf = new CompletableFuture<>();

        // we can manually complete it later (even in another thread if we want)
        cf.complete("Done!");
        String result = cf.get(); // blocking call

        /*
        * 👉 CompletableFuture<T> represents a value of type T that will be available in the future (like Future<T>),
        * plus:
            💪 You can complete it manually.
            💪 You can chain callbacks (non-blocking).
            💪 You can compose multiple async tasks (thenCompose, thenCombine, allOf, anyOf).
            💪 You can handle exceptions in a functional style (exceptionally, handle, whenComplete).
            *
            *🔴 runAsync() returns  → CompletableFuture<Void>
            *🔴 supplyAsync() returns  → CompletableFuture<T>
            *
            *✔️ By default, both use ForkJoinPool.commonPool() unless you pass your own Executor.
            */

        /*
        * Creating a runnable method with completable futures in separate thread
        * */
        CompletableFuture<Void> cfRunnable =  CompletableFuture.runAsync(()->{

           int i = 0;
           while(i < 100){
              sleep(1000);
               System.out.println("Running runAsync : " + Thread.currentThread().getName());
            }
        });

      //  cfRunnable.join(); //blocking call just like get() but throws checked exceptions

       CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(()->{
           return IntStream.range(0, 1_000_00).peek((i)->{
                   sleep(1000);
                   System.out.println("Running supplyAsync : " + Thread.currentThread().getName());
           }).reduce(Integer::sum).getAsInt();
       });


       CompletableFuture<String> greet = CompletableFuture.supplyAsync(() -> "Hello");
       // we can even pass our own executors thread pool to execute the tasks - preferred in industry
       CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> "Mahendra", executorService);

       // Combining both of the independent CFs
        CompletableFuture<String> finalCS = greet.thenCombine(name , (g,n) -> (g + " " + n));

        CompletableFuture<Void> printIt = finalCS.thenAccept(System.out::println);

        // we could have avoided both of above lines using this
        CompletableFuture<Void> printDirect = greet.thenAcceptBoth(name , (g,n) -> System.out.println(g + " " + n));





        int i = 0;
        while(i < 100){
           sleep(1000);
            System.out.println("Running main method : " + Thread.currentThread().getName());

        }


    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
