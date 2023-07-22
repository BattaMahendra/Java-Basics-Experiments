package basic.experiments.populating.pojos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import basic.experiments.pojos.Employee;

public class VariablesAndTechniques {
	
	public static String[] alphabets= IntStream.concat(IntStream.rangeClosed('a', 'z'), IntStream.rangeClosed('A', 'Z'))
											  .mapToObj(c->(char) c+",")
											  .collect(Collectors.joining())
											  .split(",");
		
	public static String[] mixAlphas = Arrays.asList(alphabets)
													.stream()
//													.filter(a->!a.toLowerCase().equals("z"))
													.map(e-> e+(char)(e.toCharArray()[0])+",")
													.collect(Collectors.joining())
													.split(",");
													
	public static String[] roles ={"developer","tester","support engineer","manager","director","supervisor","programmer specialist","team lead","project amnager"," operations manager","networking engineer","supporting staff","security personel","junior developer","fresher engineer","maintanace staff","plumber","Solutions Architect"};											
	public static String[] companies ={"Mphasis","Capgemini"};	
	public static Random random=new Random();
	
	public static List<Employee> populateEmployee(){
		List<Employee>	listOfEmp=new ArrayList<>();
		IntStream.range(0, 52)
				  .forEach(num-> {
					  listOfEmp.add(
					  Employee.builder()
					  			.id(num)
					  			.f_name("Employee : "+alphabets[num])
					  			.l_name(mixAlphas[num])
					  			.role(roles[random.nextInt(roles.length)])
					  			.company(companies[random.nextInt(companies.length)])
					  			.build() );
					  			
					  
				  });
						  
				return   listOfEmp;
		
		
		
	}
	
	public static List<Employee> populateLargeEmployee(){
		List<Employee>	listOfEmp=new ArrayList<>();
		IntStream.range(0, 10000000)
				  .forEach(num-> {
					  listOfEmp.add(
					  Employee.builder()
					  			.id(num)
					  			.f_name("Employee : "+alphabets[random.nextInt(51)])
					  			.l_name(mixAlphas[random.nextInt(mixAlphas.length-1)])
					  			.role(roles[random.nextInt(roles.length)])
					  			.company(companies[random.nextInt(companies.length)])
					  			.build() );
					  			
					  
				  });
						  
				return   listOfEmp;
		
		
		
	}
	
			
	public static void main(String[] args) {
		
		populateEmployee();
		    
//			for(Employee s:populateEmployee()) {
//				System.out.println(s.toString());
//			}
			
			populateLargeEmployee();
			for(Employee s:populateLargeEmployee()) {
				System.out.println(s.toString());
			}
			
		}									  

}
