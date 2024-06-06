package java8.Java_Streams;

import java.util.List;
import java.util.stream.Collectors;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;

public class ParallelStreams {
	static int count;
	
	public static void main(String[] args) {
		
		usingStream();
		usingParallelStream();
		
	}

	private static void usingStream() {
		List<Employee> empList = VariablesAndTechniques.populateLargeEmployee();
		long start, end;
		start = System.currentTimeMillis();
		
												empList.stream()
//														.map(emp -> emp.getF_name()+"add on")
														.map(emp -> {
															NewEmployee n = new NewEmployee();
															n.id=emp.getId();
															n.name=emp.getFirstName();
															n.role=emp.getRole();
															count+=emp.getId();
															return n;
															
														})
														.collect(Collectors.toList());
		end= System.currentTimeMillis();
		double timeTaken=(end-start);
		System.out.println(" total time taken for stream class is "+timeTaken);
	}
	
	private static void usingParallelStream() {
		List<Employee> empList = VariablesAndTechniques.populateLargeEmployee();
		long start, end;
		start = System.currentTimeMillis();
		
												empList.parallelStream()
														.map(emp -> {
															NewEmployee n = new NewEmployee();
															n.id=emp.getId();
															n.name=emp.getFirstName();
															n.role=emp.getRole();
															count+=emp.getId();
															return n;
															
														})
														.collect(Collectors.toList());
		end= System.currentTimeMillis();
		double timeTaken=(end-start);
		System.out.println("\ntotal time taken for parallelStream class is "+timeTaken);
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
