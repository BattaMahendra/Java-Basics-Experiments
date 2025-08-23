package comparators.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;

/*
* Comparator is a interface with compare() method
* This is very useful if you want to define multiple comparison strategies
* There is no need to change original product/Employee class because we define comparators outside as another classes
* */
public class Basics {
	//Learning Comparators basics
	static List<Employee> employees = VariablesAndTechniques.populateEmployee().subList(0, 6);

	 //leveraging java 8 to create comparator interfaces --> using lambda functions
	static Comparator<Employee> advancedNameComparator = (emp1 , emp2) -> emp1.getFirstName().compareTo(emp2.getFirstName());
	//more concise way of creating comparators --> using internal methods of comparator
	static Comparator<Employee> idComparator = Comparator.comparing(Employee::getId);
	// Using internal methods to sort the values of type Double
	// ( we also methods for ComparingInt, comparingLong)
	static Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary);
	// We can also use a reversed() method to reverse the list if already a comparator exists
	static Comparator<Employee> salarysComparator = idComparator.reversed();
	//we can compare object with multiple fields 
	static Comparator<Employee> employeeComparator = Comparator
														// we can use lambda functions
														.comparing((Employee e) -> e.getAge())
														//we can use predefined comparators
														.thenComparing(advancedNameComparator)
														//we can use method referencing
														.thenComparing(Employee::getFirstName)
														//if you want reverse order
														.thenComparing(idComparator)
														.thenComparing(e -> e.getRole());

	/**
	 * Extremely important - If the collection have nulls then we need to handle them
	 * and comparator provides two ways - nullFirst() , nullLast()
	 * If you don't handle then it throws NPE
	 * */
	Comparator<Employee> nullSafeComparator = Comparator.nullsFirst(idComparator); // places null first
	Comparator<Employee> nullLastComparator = Comparator.nullsLast(idComparator); // places null first

	/**
	 * If you want reverse order */
	Comparator<Employee> descendingSalary = Comparator.comparing(Employee::getSalary).reversed();
	//or you can also pass like below
	Comparator<Employee> descendingSalary2 = Comparator.comparing(Employee::getSalary, Comparator.reverseOrder());

	/**
	 * Case sensitivity matters
	 * In String class remember case sensitivity matters. i.e. "Zebra" comes before "apple"
	 * */

	Comparator<Employee> cmp = Comparator.comparing(Employee::getFirstName, String.CASE_INSENSITIVE_ORDER);



	public static void main(String[] args) {
		System.out.println("age of employees before sorting ");
		employees.forEach(emp -> System.out.printf(emp.getAge()+" "));
		System.out.println("\n age of employees after sorting ");
		
		//creating a comparator object and using it in the sort method
		EmployeeAgeComparator ageComparator =new EmployeeAgeComparator();
		//employees.sort(c);

		// We can also pass like this
		Collections.sort(employees,ageComparator);
		
		/*
		 * instead of creating another class for comparator
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
		employees.forEach(emp -> System.out.println(emp.getFirstName()+" "));
		employees.sort(advancedNameComparator);
		System.out.println("\nname of employees after sorting");
		employees.forEach(emp -> System.out.println(emp.getFirstName()+" "));
		
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

/**
 *
 * Advantages
 * 1. Multiple sorting strategies
 * 2. More flexible as comparators are separated from original product class
 *    So doesn't modify the original class
 * 3. Best if we have complex sorting logic
 * 4. Extremely useful in case when the original class is coming from a library (where we can't modify the class)
 *
 * Disadvantages
 * 1. Unlike Comparable, where the “natural” order is defined inside the class itself,
 * 	  Comparator doesn’t indicate a single default order (you must explicitly choose one each time).
 * 2. More boilerplate as external classes are needed
 * 3. No single natural order like comparable interface
 *
 * 6. Common Pitfalls
 * 	---> Forgetting null handling → may throw NullPointerException.
 * 	---> Using subtract for comparison (p1.getPrice() - p2.getPrice()) → risky due to overflow; better use Double.compare().
 * 	---> Overusing anonymous classes → makes code verbose, prefer lambdas.
 * 	---> Chaining without reversed properly → thenComparing only reverses last comparator if not careful.
 * 	---> In String class remember case sensitivity matters. i.e. "Zebra" comes before "apple"
 *
 *  * Final verdict
 *  * Use Comparable → if your class has a single natural order (like String, Integer, Employee by ID).
 *  * Use Comparator → if you want multiple ways of sorting or when the class cannot/should not be modified.
 *
 * */
