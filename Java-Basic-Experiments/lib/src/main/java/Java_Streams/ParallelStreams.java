package Java_Streams;

import java.util.stream.Collectors;

import com.google.common.base.Stopwatch;

import basic.experiments.populating.pojos.VariablesAndTechniques;

public class ParallelStreams {
	static int count;
	
	public static void main(String[] args) {
		
		usingStream();
		usingParallelStream();
		
	}

	private static void usingStream() {
		long start, end;
		start = System.currentTimeMillis();
		
		VariablesAndTechniques.populateLargeEmployee().stream()
//														.map(emp -> emp.getF_name()+"add on")
														.map(emp -> {
															NewEmployee n = new NewEmployee();
															n.id=emp.getId();
															n.name=emp.getF_name();
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
		long start, end;
		start = System.currentTimeMillis();
		VariablesAndTechniques.populateLargeEmployee().parallelStream()
														.map(emp -> {
															NewEmployee n = new NewEmployee();
															n.id=emp.getId();
															n.name=emp.getF_name();
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
