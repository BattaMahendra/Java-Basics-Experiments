package basic.experiments.miscellaneous;

import java.util.ArrayList;
import java.util.List;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;

public class StreamsVsForEach {
	
	public static void main(String[] args) {
		
		List<Employee> empListNew=new ArrayList<>();
		
		List<Employee> empListOld=VariablesAndTechniques.populateEmployee();
		try {
		empListOld.stream().forEach(emp ->{
			empListOld.clear();
			empListNew.add(emp);
			
		} );
		}catch (Exception e) {
			System.out.println("inexception block");
			 empListOld.forEach(System.out::println);
			 System.out.println("end of exception block");
		}
//		empListOld=VariablesAndTechniques.populateEmployee();
		
		System.out.println("\n new List");
		
		empListNew.forEach(System.out::println);
		
		System.out.println("\n with for each");
	}

}
