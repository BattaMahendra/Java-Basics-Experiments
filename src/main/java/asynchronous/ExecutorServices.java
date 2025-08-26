package asynchronous;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import javax.management.RuntimeErrorException;

public class ExecutorServices {
	
	
	/*
	* newCachedThreadPool() creates required threads and reuses them if they are idle
	* It is efficient way of thread management*/
	public static ExecutorService executors = Executors.newCachedThreadPool();
	
	public static String returnAStringWithDelay(int seconds) throws Exception {
		
		Thread.sleep(seconds*1000);
		if(seconds==13) throw new Exception("exception is thrown");
		System.out.println("Hello World with timeout sec "+seconds);
		
		return "Hello World with timeout sec "+seconds;
	}
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		//submit() returns a Future representing the pending result.
		//here submit() takes input as callable
		Future<String> future1= executors.submit(()->returnAStringWithDelay(15));
		Future<String> future2=executors.submit(()->returnAStringWithDelay(1));
		Future<String> future3=executors.submit(()->returnAStringWithDelay(13));
		Future<String> future4=executors.submit(()->returnAStringWithDelay(10));
		Future<String> future5=executors.submit(()->returnAStringWithDelay(18));
		Future<String> future6=executors.submit(()->returnAStringWithDelay(9));
		Future<String> future7=executors.submit(()->returnAStringWithDelay(5));
		Future<String> future8=executors.submit(()->returnAStringWithDelay(7));
		Future<String> future9=executors.submit(()->returnAStringWithDelay(8));
		Future<String> future10=executors.submit(()->returnAStringWithDelay(4));

		// We can even submit a runnable task to executor service
		//remember runnable can't return value nor throw checked exceptions (i.e why we used try catch)
		Runnable printString = () -> {
			//simulating delay instead of original work
            try {Thread.sleep(2000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println("I am runnable without any return value");
		};
		Future<?> future11=executors.submit(printString);
		Future<?> future12=executors.submit(printString);


		
		/*
		 * the above code ensures that all the 12 futures are executed simultaneously and
		 * you can see the result your  self.
		 */
			
		/*
		 * even after executing all above code the program will  be still running and in order to 
		 * stop it shutdown() method is required.
		 *
		 * shutdown() method makes sure that no executor service takes no new tasks and wait
		 * for currently executing tasks to finish and then shuts down
		 */
		executors.shutdown();
		//System.out.println(executors.isShutdown());
		
		//this will stop the executor immediately without even executing above code
		//executors.shutdownNow();

		while(!future2.isDone()){
			Thread.sleep(100);
			System.out.println("Main thread is running simultaneously parallel");
		}

		//to get the exception
		future1.get();  // this is blocking call , everything else is blocked

		// the below line is blocked until the above get() is finished
		System.out.println("Main thread last statement execution");


		invokeAllOperation();
	}

	private static void invokeAllOperation() throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newCachedThreadPool();

		List<Callable<Integer>> callableTasks =  Arrays.asList(
				() -> { Thread.sleep(300); return 1; },
				() -> { Thread.sleep(200); return 2; },
				() -> { Thread.sleep(100); return 3; },
				() -> { Thread.sleep(100); return 4; },
				() -> { Thread.sleep(100); return 5; }
		);

		// we can use invokeAll() to invoke all callables at once
		List<Future<Integer>> futures = executors.invokeAll(callableTasks); // blocks until all done
		for (Future<Integer> f : futures) {
			System.out.println(f.get());
		}
		/*
		* Similarly we have invokeAny() operation which executes a list of callables and even if one gets success
		* then returns that and abandons everything*/
		executors.shutdown();
	}

}
