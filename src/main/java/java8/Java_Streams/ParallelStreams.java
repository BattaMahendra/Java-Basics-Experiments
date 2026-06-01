package java8.Java_Streams;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;

public class ParallelStreams {

	public static void main(String[] args) {
		System.out.println("=== STREAM vs PARALLEL STREAM Performance Test ===\n");
		usingStream();
		System.out.println("\n" + "=".repeat(50) + "\n");
		usingParallelStream();
		System.out.println("\n" + "=".repeat(50));
		System.out.println("Note: Parallel stream is slower due to:");
		System.out.println("1. Thread creation overhead (small dataset)");
		System.out.println("2. Synchronization costs for shared state (count+=)");
		System.out.println("3. Thread pool orchestration overhead");
	}

	private static void usingStream() {
		System.out.println("[SEQUENTIAL STREAM] Processing employees...");
		List<Employee> empList = VariablesAndTechniques.populateLargeEmployee();
		long start, end;
		AtomicLong count = new AtomicLong(0);

		start = System.currentTimeMillis();
		
		List<NewEmployee> newEmployees = empList.stream()
														.map(emp -> {
															NewEmployee n = new NewEmployee();
															n.id=emp.getId();
															n.name=emp.getFirstName();
															n.role=emp.getRole();
															count.addAndGet(emp.getId());
															return n;
														})
														.peek( emp ->{
															try {
																Thread.currentThread().sleep(1);
															} catch (InterruptedException e) {
																throw new RuntimeException(e);
															}
														})
														.collect(Collectors.toList());
		end= System.currentTimeMillis();
		double timeTaken=(end-start);
		System.out.println("Total time taken for SEQUENTIAL stream: " + timeTaken + " ms");
		System.out.println("Total employees processed: " + newEmployees.size());
		System.out.flush();
	}
	
	private static void usingParallelStream() {
		System.out.println("[PARALLEL STREAM] Processing employees with multiple threads...");
		List<Employee> empList = VariablesAndTechniques.populateLargeEmployee();
		long start, end;
		AtomicLong count = new AtomicLong(0);

		start = System.currentTimeMillis();
		
		List<NewEmployee> newEmployees = empList.parallelStream()
														.map(emp -> {
															NewEmployee n = new NewEmployee();
															n.id=emp.getId();
															n.name=emp.getFirstName();
															n.role=emp.getRole();
															count.addAndGet(emp.getId());
															return n;
														})
														.peek( emp ->{
                                                            try {
                                                                Thread.currentThread().sleep(1);
                                                            } catch (InterruptedException e) {
                                                                throw new RuntimeException(e);
                                                            }
                                                        })
														.collect(Collectors.toList());
		end= System.currentTimeMillis();
		double timeTaken=(end-start);
		System.out.println("Total time taken for PARALLEL stream: " + timeTaken + " ms");
		System.out.println("Total employees processed: " + newEmployees.size());
		System.out.flush();
	}

}

class NewEmployee{
	int id;
	String name;
	String role;
	
	public NewEmployee(int id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public NewEmployee() {
		super();
	}
}
