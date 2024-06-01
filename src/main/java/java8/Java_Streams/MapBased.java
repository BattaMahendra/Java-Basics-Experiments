package java8.Java_Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import basic.experiments.pojos.Employee;
import basic.experiments.pojos.Names;
import basic.experiments.populating.pojos.VariablesAndTechniques;
import lombok.Data;
import lombok.ToString;

public class MapBased {
	
	/*
	 * create a map with employee company as key
	 */

	public static void mappedEmployee() {
		
		//get employee list 
		List<Employee> employeeList = VariablesAndTechniques.getLargeEmployeeList();
		System.out.println("========================================================================");
		List<Employee> employeeListWithSortedSalaries = employeeList.stream().limit(50).sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println(employeeListWithSortedSalaries);

		
		/*
		 *grouping employees based on their company 
		 */
		Map<String , List<Employee>> employeesWithCompany = employeeList.stream()
																		 .collect(Collectors.groupingBy(Employee::getCompany));
		employeesWithCompany.entrySet().forEach(e -> System.out.println("company: "+e.getKey()+"  no of emp: "+ e.getValue().size()));
		System.out.println("========================================================================");
		
		/*
		 * grouping employees with company and list of their names
		 */
		Map<String , List<String>>
						employeeNamesWithCompany = 	
												employeeList.stream()
															.collect(Collectors.groupingBy(Employee::getCompany, Collectors.mapping(Employee::getF_name, Collectors.toList())));
		employeeNamesWithCompany.entrySet().forEach(e -> System.out.println("company: "+e.getKey()+"  no of emp: "+ e.getValue().size()));
		
		//sort employees based on their salary
		
		Map<String, List<Employee>> employeesWithSaalary = employeeList.stream().limit(100)
																.sorted(Comparator.comparingDouble(Employee::getSalary))
																.collect(Collectors.groupingBy(Employee::getCompany));
																
		employeesWithSaalary.entrySet().stream().map(entry ->{
			System.out.println(entry.getKey());
			return entry.getValue();}
			).forEach(e -> e.stream().forEach(emp->System.out.println(emp.getSalary())));
		
		//group employees based on their company and salary
		
		Map<String, List<Double>> employeesMapWithSaalary = employeeList.stream().limit(100)
				.sorted(Comparator.comparingDouble(Employee::getSalary))
				/*
				 * in collectors.groupingBy first parameter is key and for mapping values we use 
				 * Collectors.mapping and we specify which parameter to set as value and its type
				 */
				
				.collect(Collectors.groupingBy(Employee::getCompany,Collectors.mapping( Employee::getSalary, Collectors.toList())));
				System.out.println(employeesMapWithSaalary);
				
		//group employees with company name and a custom DTO as value		
		Map<String, SampleDto> mapWithCompanyAndDto =	
				employeeList.stream().limit(100)
				//sort all employees with salary even before collecting
				.sorted(Comparator.comparingDouble(Employee::getSalary))
													
				.collect(Collectors
							.groupingBy(Employee::getCompany,
								Collectors.mapping( emp -> (Object)emp.getSalary(), Collectors.toList())))
				
							//now we have a map<companyName , List<Salaries>> and we iterate on top of it
								.entrySet().stream()
								//collect now into a map
								.collect(Collectors.toMap(Map.Entry::getKey, e -> new SampleDto(e.getValue())));
																				
														
		System.out.println(mapWithCompanyAndDto);
				
	}
	
	/*
	 * sort given lists and map them with list size as key and sorted list in value
	 */
	
	public static void sortListToMap() {
		VariablesAndTechniques v = new VariablesAndTechniques();
		//contains male , female and surname lists
		Names names = v.getRandomNamesFromJson();
		List<String> namesList = new ArrayList<>();
		namesList.addAll(names.getMale());
		namesList.addAll(names.getFemale());
		namesList.forEach(System.out::println);
		Map<Integer,List<String>> sortedNames = namesList.stream().sorted((n1,n2) -> n2.compareTo(n1))
							.collect(Collectors
											.groupingBy(n -> n.length() , Collectors.toList()));
		
		
		sortedNames.entrySet().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));
	}
	
	
	public static void main(String[] args) {
		
		mappedEmployee();
		
		
		//sortListToMap();
		
	}
}

@Data
@ToString
class SampleDto{
	public SampleDto(List<Object> salaries) {
		this.list=salaries;
	}

	List<Object> list;
}
