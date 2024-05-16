package comparators;

import java.util.Comparator;
import java.util.List;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;

public class Basics {
	//Learning Comparators basics
	static List<Employee> employees = VariablesAndTechniques.populateEmployee().subList(0, 6);

	 //leveraging java 8 to create comparator interfaces --> using lambda functions
	static Comparator<Employee> advancedNameComparator = (emp1 , emp2) -> emp1.getF_name().compareTo(emp2.getF_name());
	//more concise way of creating comparators --> using internal methods of comparator
	static Comparator<Employee> idComparator = Comparator.comparing(Employee::getId);
	//we can compare object with multiple fields 
	static Comparator<Employee> employeeComparator = Comparator
														// we can use lambda functions
														.comparing((Employee e) -> e.getAge())
														//we can use predefined comparators
														.thenComparing(advancedNameComparator)
														//we can use method referencing
														.thenComparing(Employee::getF_name)
														.thenComparing(idComparator)
														.thenComparing(e -> e.getRole());
																		

	public static void main(String[] args) {
		System.out.println("age of employees before sorting ");
		employees.forEach(emp -> System.out.printf(emp.getAge()+" "));
		System.out.println("\n age of employees before sorting ");
		
		//creating a comparator object and using it in the sort method
		EmployeeAgeComparator c =new EmployeeAgeComparator();
		//employees.sort(c);
		
		/*
		 * instead of creating a another class for comparator
		 * we can rather use anonymous inner classes to create comparator object
		 */
		employees.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getAge()>o2.getAge()) return 1;
				else if (o1.getAge()<o2.getAge()) return -1;
				else 	return 0;
			}
		});
		employees.forEach(emp -> System.out.printf(emp.getAge()+" "));
		
		System.out.println("\nname of employees before sorting");
		employees.forEach(emp -> System.out.println(emp.getF_name()+" "));
		employees.sort(advancedNameComparator);
		System.out.println("\nname of employees after sorting");
		employees.forEach(emp -> System.out.println(emp.getF_name()+" "));
		
		System.out.println("\nid of employees before sorting");
		employees.forEach(emp -> System.out.println(emp.getId()+" "));
		//using lambda functions to compare
		employees.sort(idComparator);
		//we can directly use lambdas to sort the list
		//employees.sort((e1,e2)->e1.getRole().compareTo(e2.getRole()));
		System.out.println("\nid of employees before sorting");
		employees.forEach(emp -> System.out.println(emp.getId()+" "));
		//employees.forEach(emp ->

		sortedInStreams();
		
	}

	public static void sortedInStreams(){
		System.out.println("\n=========================================================\n");
		System.out.println("Employees before sorting");
		employees.stream().forEach(System.out::println);
	}
}

//creating a comparator class to define the comparators
class EmployeeAgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getAge()>o2.getAge()) return 1;
		else if (o1.getAge()<o2.getAge()) return -1;
		else 	return 0;
	}

}
