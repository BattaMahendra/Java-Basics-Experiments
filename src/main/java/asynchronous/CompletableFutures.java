package asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutures {
	static int i =0;
	public static void main(String[] args) throws InterruptedException {

		
		CompletableFuture completableFuture =new CompletableFuture();
		 CompletableFuture.runAsync(()->{
			 try {sleep();} catch (InterruptedException e) {throw new RuntimeException(e);}
			 System.out.println(" I am under runasync() method with 5s latency");
        });
//

		while(i <=5){
			Thread.sleep(200);
			System.out.println("Main thread running "+i++);
		}

	}

	private static void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}


}
