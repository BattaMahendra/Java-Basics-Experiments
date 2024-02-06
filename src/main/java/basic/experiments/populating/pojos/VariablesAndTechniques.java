package basic.experiments.populating.pojos;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import basic.experiments.pojos.Address;
import basic.experiments.pojos.Employee;
import basic.experiments.pojos.Names;
import lombok.AllArgsConstructor;

@AllArgsConstructor
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
	public static String[] companies ={"Mphasis","Capgemini","Cognizant","Accenture","SAP LABS", "LTI-Mindtree","TCS"};	
	public static String[] state = { "Andhra Pradesh",
	                                 "Arunachal Pradesh",
	                                 "Assam",
	                                 "Bihar",
	                                 "Chhattisgarh",
	                                 "Goa",
	                                 "Gujarat",
	                                 "Haryana",
	                                 "Himachal Pradesh",
	                                 "Jammu and Kashmir",
	                                 "Jharkhand",
	                                 "Karnataka",
	                                 "Kerala",
	                                 "Madhya Pradesh",
	                                 "Maharashtra",
	                                 "Manipur",
	                                 "Meghalaya",
	                                 "Mizoram",
	                                 "Nagaland",
	                                 "Odisha",
	                                 "Punjab",
	                                 "Rajasthan",
	                                 "Sikkim",
	                                 "Tamil Nadu",
	                                 "Telangana",
	                                 "Tripura",
	                                 "Uttarakhand",
	                                 "Uttar Pradesh",
	                                 "West Bengal",
	                                 "Andaman and Nicobar Islands",
	                                 "Chandigarh",
	                                 "Dadra and Nagar Haveli",
	                                 "Daman and Diu",
	                                 "Delhi",
	                                 "Lakshadweep",
	                                 "Puducherry"};
	public static Random random=new Random();
	
	
	public static List<Employee> populateEmployee(){
		List<Employee>	listOfEmp=new ArrayList<>();
		IntStream.range(0, 52)
				  .forEach(num-> {
					  listOfEmp.add(
					  Employee.builder()
					  			.id(random.nextInt(999))
					  			.f_name("Employee : "+alphabets[num])
					  			.l_name(mixAlphas[num])
					  			.role(roles[random.nextInt(roles.length)])
					  			.company(companies[random.nextInt(companies.length)])
					  			.age(random.nextInt(65))
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
					  			.age(random.nextInt(65))
					  			.build() );
					  			
					  
				  });
						  
				return   listOfEmp;
		
		
		
	}
	
	List<Address> populateAddress(){
		try {
			File file = new File(this.getClass().getClassLoader().getResource("address.json").getFile());
			ObjectMapper mapper = new ObjectMapper();
			Address[] someClassObj =  mapper.readValue(file, Address[].class);
			return  Arrays.asList(someClassObj);
		
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		return null;
	}
	
	Names getRandomNamesFromJson(){
		try {
			File file = new File(this.getClass().getClassLoader().getResource("names.json").getFile());
			ObjectMapper mapper = new ObjectMapper();
			Names someClassObj =  mapper.readValue(file, Names.class);
			return  someClassObj;
		
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		return null;
	}
	
	
	
			
	public static void main(String[] args) {
		
		populateEmployee();
		    
			for(Employee s:populateEmployee()) {
				System.out.println(s.toString());
			}
			
//			populateLargeEmployee();
//			for(Employee s:populateLargeEmployee()) {
//				System.out.println(s.toString());
//			}
			
			VariablesAndTechniques techniques = new VariablesAndTechniques();
		
		System.out.println(techniques.populateAddress().size());
		System.out.println(techniques.getRandomNamesFromJson().getFemale().size());
			
		}		
	
	
}
