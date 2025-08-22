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
				.thenCompose( input->cf2)
				// thenRun() takes runnable as param and returns nothing
				.thenRun(()-> System.out.println(" Operation completed"));







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
