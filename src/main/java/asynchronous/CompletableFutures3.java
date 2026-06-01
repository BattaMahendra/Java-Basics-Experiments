package asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CompletableFutures3 {


    public static Integer divide()  {

        System.out.println("Current execuing thread: "+Thread.currentThread().getName());
        try{Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        int i = 10/0;
        return i;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
        * Generally if an exception occurs in Future then it is swallowed up
        * It is not visible until you cal future.get() method. At that time exception is thrown*/

        Future<Integer> future = Executors.newCachedThreadPool().submit(() -> divide());

        // blocking call
        //future.get(); // now the exception is visible


        /*
        * Where as completable futures can work with exceptions or can also complete exceptionally*/

        /*
        * 🔴 exceptionally() -> input: exception , output: CF<T>
        * 🔴 runs only when exception occurs. Skipped when it is success
        * 🔴 Returns fallback value
        * */

        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync( () -> divide())
                .exceptionally(ex -> {
                    System.out.println("Error Occurred : "+ ex);
                    return 0; // fall back value
                });

        Integer i = task1.join();
        System.out.println(i);


        //  2. We can also use handle() method.

        /*
        * 🌟 on success → result available and can manipulate it
        * 🌟 on failure → exception available and can manipulate it
        * */

        CompletableFuture<Integer>
                handleExample = CompletableFuture.supplyAsync(() -> 10/0)
                         .handle((result, exception) -> {
                             if(exception != null){
                                 System.out.println("Exception : "+exception);
                                 return  0; // fallback value
                             }

                             return result;  // if not exception occurs then return real value
                         });

        Integer j = handleExample.join();
        System.out.println(j);



        /*
        * Using all of and any of
        * */

        CompletableFuture<Integer> service1 =
                CompletableFuture.supplyAsync(() -> {
                    try{Thread.sleep(2000);} catch (InterruptedException e) {throw new RuntimeException(e);}
                    return 10;
                });

        CompletableFuture<Integer> service2 =
                CompletableFuture.supplyAsync(() -> {
                    try{Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
                    return 20;
                });

        CompletableFuture<Object> any =
                CompletableFuture.anyOf(service1, service2);

        System.out.println(any.join()); // likely 20


        // allOf()  input: multiple cfs , output: CF<Void>

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2);

        all.join(); // wait for both

        // you can also chain

       CompletableFuture<List<Integer>> resultList =  all.thenApply( voidd -> {
            return List.of(f1.join(), f2.join());
        });
        System.out.println("Both done");







    }
}
