package Java_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.management.relation.RoleStatus;

import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.VariablesAndTechniques;

public class FlatMap {
	
	public static List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	public static List<Character> charList =IntStream.rangeClosed('a', 'z')
												.mapToObj(eachInteger ->(char)eachInteger )
												.collect(Collectors.toList());
	public static List<String> roles =Arrays.asList(VariablesAndTechniques.roles);
	public static List<Employee> employees=VariablesAndTechniques.populateEmployee();
	public static List<List<? extends Object>> listOfList = Arrays.asList(intList,charList,roles,employees);
	public static List<Object> listOfObjects =new ArrayList<>();
	
	public static void main(String[] args) {
		
		//usingAFlatMap();
		castingObjectsInStream();
		
	}

	private static void usingAFlatMap() {
		/*
		 * using flat map to convert a list of various lists to single list
		 * flat map always flattens the complex collections
		 * flatMap = flattening + map()
		 * map() is used for transformation only, but flatMap() is used for both transformation and flattening
		 * finally a flat map same as map will return a stream 
		 */
		System.out.println("before using a flat map");
		System.out.println(listOfList);
		
		System.out.println("\n after using a flat map");
		
		listOfObjects=listOfList.stream()
								//.flatMap(eachList->eachList.stream())
								//instead of above line we can use method referencing
								.flatMap(Collection::stream)
								.collect(Collectors.toList());
		
		
		System.out.println(listOfObjects);
	}
		
	
	/*
	 * suppose we want to perform some operation on only employee objects 
	 * that is we have multiple lists in the "listOfList" but we not only want to flat them but also we 
	 * need to perform some operation on list of employees.
	 */
	public static void castingObjectsInStream() {
		
		System.out.println("\n after using specific casting in flat map");
		
		listOfObjects=listOfList.stream()
								.flatMap(eachList ->
									
									eachList.stream()
//													 .filter(s -> s instanceof Employee)
//													 .map(s ->(Employee)s)
													 //instead of above two lines we can write using method referencing
													 .filter(Employee.class::isInstance)
													 // we need to cast incoming filtered objects to Employee for further operations on employee object
													 .map(Employee.class::cast)
													 //now we have only employee objects and now you can perform your operations using map
													 .map(Employee::getId)
								)
								.collect(Collectors.toList());
		
		/*
		 * we can reduce above code 
		 */
		
		listOfObjects=listOfList.stream()
				//check whether the incoming list is instance of list or not
				.filter(eachList -> eachList instanceof List)
				/*
				 * now we have checked whether incoming stream is list or not
				 * after that we cast each filtered list into List<?> which means the list can have any object
				 * and then we stream it for further processing
				 * instead of using below line we can even use method referencing like flatMap(List::stream)
				 * which performs same function with reduced code
				 */
				.flatMap(eachList -> ((List<?>)eachList).stream())
//				.flatMap(List::stream)
				/*
				 * we are filtering out only Employee objects from various lists
				 */
				.filter(Employee.class::isInstance)
				.map(Employee.class::cast)
				.map(Employee::getCompany)
				
				// the above two lines are decoded as 
//				.map(employee ->{
//					Employee emp =(Employee)employee;
//					return emp.getId();
//				})
				
				.collect(Collectors.toList());

		System.out.println(listOfObjects);
		
	}
	
	

}
