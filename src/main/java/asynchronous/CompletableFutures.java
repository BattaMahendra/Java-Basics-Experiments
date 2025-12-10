package asynchronous;

import basic.experiments.pojos.Emp;
import basic.experiments.populating.pojos.Employees;
import java8.Java_Streams.Employee;

import java.util.List;
import java.util.Optional;
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




		List<Employee> employeeList = Employee.populateEmployee();
		CompletableFuture<Employee> cf2 = CompletableFuture.supplyAsync(()->{
          for (Employee e : employeeList){
			  if(e.getEmp_salary()>20000) return e;
		  }
		  return null;
		});

		// then apply
		// as we are applying on cf2 , the default input param will be Employee as cf2 return is employee
		CompletableFuture cf3 = cf2.thenApply(employee -> employee.getEmp_age()>21 ?employee.getEmp_name():null)
				//thenAccept() --> consumer --> takes input as previous cf return statement and returns CompletableFuture<void>
				.thenAccept(name -> System.out.println("Employee Name whose age is above 21 :"+ name))
				// this one takes function as parameter and returns a completable future itself
				// here you can do any operation and should finally return a completable future itself
				// acts as a flat map and avoids situations like CompletableFuture< CompletableFuture< Employee > >
				.thenCompose( input->cf2)
				// thenRun() takes runnable as param and returns nothing
				.thenRun(()-> System.out.println(" Operation completed"));



		/*
		* One more example
		* */

		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 10);

			// 1. thenApply ==> Takes CF<T> --> returns CF<R>
					CompletableFuture<String> step1 =
							cf.thenApply(n -> "x = " + n);

			// 2. thenAccept ==> Takes CF<T> --> returns CF<Void>
					CompletableFuture<Void> step2 =
							step1.thenAccept(s -> System.out.println("step1: " + s));

			// 3. thenRun -> no input and run the task without return
					CompletableFuture<Void> step3 =
							step2.thenRun(() -> System.out.println("All done!"));

			//4. Difference b/w thenAccept() and thenCompose()

		/*
		* We are trying to return a completable future only
		* What thenApply() or supplyAsync() does is they wrap everything in Completable future*/
		CompletableFuture<CompletableFuture<Integer>> cfApply = cf.thenApply(n -> cf);
		CompletableFuture<CompletableFuture<Integer>> cfSupply = CompletableFuture.supplyAsync(() -> cf);

		// where as thenCombine() solves it by flattening it
		CompletableFuture<Integer> composed = cf.thenCompose(n -> cf);








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
