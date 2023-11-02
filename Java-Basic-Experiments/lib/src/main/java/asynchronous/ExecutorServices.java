package asynchronous;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import javax.management.RuntimeErrorException;

public class ExecutorServices {
	
	
	
	public static ExecutorService executors = Executors.newFixedThreadPool(10);
	
	public static String returnAStringWithDelay(int seconds) throws Exception {
		
		Thread.sleep(seconds*1000);
		if(seconds==13) throw new Exception();
		System.out.println("Hello World with timeout sec "+seconds);
		
		return "Hello World with timeout sec "+seconds;
	}
	
	public static void main(String[] args) {
		
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
		
		/*
		 * the above code ensures that all the 10 futures are executed simultaneously and 
		 * you can see the result your  self.
		 */
			
		/*
		 * even after executing all above code the program will  be still running and in order to 
		 * stop it shutdown() method is required.
		 */
		executors.shutdown();
		//System.out.println(executors.isShutdown());
		
		//this will stop the executor immediately without even executing above code
		//executors.shutdownNow();
	}

}
