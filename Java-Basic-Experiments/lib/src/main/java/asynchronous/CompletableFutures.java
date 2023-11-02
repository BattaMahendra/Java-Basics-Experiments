package asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutures {
	
	public static void main(String[] args) {
		
		CompletableFuture completableFuture =new CompletableFuture();

		 CompletableFuture.runAsync(()->{


             System.out.println(" I am under runasync() method with 5s latency");
        });
		
	}
	

}
