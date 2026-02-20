package comparators.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;
import lombok.ToString;

/*
* Comparator is a interface with compare(T t1, T t2):int method
* This is very useful if you want to define multiple comparison strategies
* There is no need to change original product/Employee class because we define comparators outside as another classes
* */
public class Basics {



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

		commonPitFalls();

	}




	//Learning Comparators basics
	static List<Employee> employees = VariablesAndTechniques.populateEmployee().subList(0, 10);

	 //leveraging java 8 to create comparator interfaces --> using lambda functions
	static Comparator<Employee> advancedNameComparator = (emp1 , emp2) -> emp1.getFirstName().compareTo(emp2.getFirstName());
	//more concise way of creating comparators --> using internal methods of comparator
	static Comparator<Employee> idComparator1 = Comparator.comparing(employee ->  employee.getId());  // just supply required function to the comparing() method
	// the above can be rewritten as
	static Comparator<Employee> idComparator = Comparator.comparing(Employee::getId);
	// Using internal methods to sort the values of type Double
	// ( we also methods for ComparingInt, comparingLong)
	static Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary);
	// We can also use a reversed() method to reverse the list if already a comparator exists
	static Comparator<Employee> salarysComparator = idComparator.reversed();
	//we can compare object with multiple fields 
	static Comparator<Employee> employeeComparator = Comparator
														// we can use lambda functions to compare employees with their age
														.comparing((Employee e) -> e.getAge())
														// now what if two  employees age is equal and how you want to sort those who are equal
														// then you can choose to sort equal age employees using their first name
														// we can do this chaining by thenComparing() method
														.thenComparing(advancedNameComparator)  // takes param as a comparator and sorts
														// instead of passing comparator  as a param
			                                            // you can directly pass the field which you want to compare for equal age and equal first name employees
														.thenComparing(Employee::getFirstName)    // takes a function as param - return type will be compared
														//if you want reverse order
														.thenComparing(idComparator)
														.thenComparing(e -> e.getRole());
/**
 *
 * Lets suppose you want to sort employees based on their age - you can use ageComparator
 *
 * But what if some of the employees age is equal - then what to do - if you want to sort out only equal age employees further
 * you can use 1.  thenComparing(Comparator)  ==> you can pass any comparator
 * 		       2.  thenComparator(Function)   ==> you can pass any function , which return value is used to compare
 *
 * ✔️ 💡  thenComparing() runs only when the previous comparison returns 0
 * 🌟 thenComparing() = “If previous comparison ties, use this next.”
 * */

	/**
	 * Extremely important - If the collection have nulls then we need to handle them
	 * and comparator provides two ways - nullFirst() , nullLast()
	 * If you don't handle then it throws NPE
	 * */
	Comparator<Employee> nullSafeComparator = Comparator.nullsFirst(idComparator); // places null first
	Comparator<Employee> nullLastComparator = Comparator.nullsLast(idComparator); // places null last

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





	public static void sortedInStreams(){
		System.out.println("\n=========================================================\n");
		System.out.println("Employees before sorting");
		employees.stream().forEach(System.out::println);

		System.out.println("Employees after sorting");
		employees.stream().sorted().forEach(System.out::println); // uses comparable

		employees.sort(salaryComparator.reversed()); // sorting using salary comparator - highest salary first
		System.out.println("\nEmployees after sorting with salary comparator\n");
		employees.forEach(System.out::println);

		// streams ==> comparator
		employees.stream().sorted(idComparator.thenComparing(advancedNameComparator))  // we can pass custom comparator in sorted()
				.forEach(System.out::println);

		System.out.println("\n================= Sorting with max() and min() ======================\n");

		//streams ==> max()  ==> returns optional of highest element
		// max() , min() - terminal operation
		// a special case of reduce()
		employees.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.ifPresent(System.out::println);

		// returns minimum element of stream according to provided comparator
		// min() ==> returns an optional wrapped element
		employees.stream().min(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

		System.out.println("\n=========================================================\n");

	}


	public void evolution(){

		/* Using EmployeeAgeComparator directly */
		EmployeeAgeComparator employeeAgeComparator = new EmployeeAgeComparator();
		Collections.sort(employees, employeeAgeComparator);
		// the above can also be written as
		employees.sort(employeeAgeComparator);

		/* We can also have anonymous inner class instead of above*/
		employees.sort(new Comparator<Employee>() {

			//static String comparatorStaticId = "S12345";  // only static final constants allowed
			int comparatorId = 12345; // we can have instance variables in case of inner anonymous class
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getAge() > o2.getAge() ? 1 : (o1.getAge() == o2. getAge() ? 0 : -1);

				//return Integer.compare(o1.getAge(),o2.getAge()); // the above can be written as this
			}
		});

		/*
		* The above anonymous class can be reduced to lambda*/

		// Using Integer class compare method as age is an integer
		Comparator<Employee> ageComparatorLambda1 = (e1,e2) -> Integer.compare(e1.getAge(),e2.getAge());

		//Using Comparator.comparing()
		Comparator<Employee> ageComparatorLambda4 =  Comparator.comparing(Employee::getAge);

		// Using comparing int
		Comparator<Employee> ageComparatorLambda2 =  Comparator.comparingInt(e -> e.getAge());

		// Using Method reference
		Comparator<Employee> ageComparatorLambda3 =  Comparator.comparingInt(Employee::getAge);





		/*
		* We can use above as following*/
		employees.sort(ageComparatorLambda4);
	}

	public static void commonPitFalls(){

		@ToString
		class Product{
			int price;
			String name;

			Product(int price, String name){
				this.name = name;
				this.price = price;
			}
		}

		Product p1 = new Product(10, "Pen");
		Product p2 = new Product(20, "Book");
		Product p3 = new Product(10, "Pencil");
		Product p4 = new Product(10, "Pen-Pencil");

		Comparator<Product> productComparator = Comparator.comparing(p -> p.price);

		TreeSet<Product> productTreeSet = new TreeSet<>(productComparator);

		productTreeSet.add(p1);
		productTreeSet.add(p2);
		productTreeSet.add(p3);
		productTreeSet.add(p4);

		// you will see only two entry as TreeSet compares everything by the comparator we provided, and it is price
		// price is same for all products

		System.out.println(productTreeSet);




	}
}

//creating a comparator class to define the comparators
class
EmployeeAgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getAge()>o2.getAge()) return 1;
		else if (o1.getAge()<o2.getAge()) return -1;
		else 	return 0;

		/*
		* compare(a, b) < 0 → a moves left in the order
		* compare(a, b) > 0 → a moves right in the order
		* compare(a, b) = 0 → no movement needed in the order
		* */

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
