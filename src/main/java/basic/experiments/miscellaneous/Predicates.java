package basic.experiments.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;



public class Predicates {

	public static Predicate<List<Employee>>
	filterEmpByCompany=empList->empList.stream()
									.anyMatch(emp -> emp.getCompany().equals("Mphasis"));
	
//	List<String> names1 = new ArrayList<>();
//	names1.add("Hello");
//	public static Predicate<String> filterByName = names.
								


	public static void main(String[] args) {

	}											


}
