package basic.experiments.populating.pojos;
import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
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
		List<Employee> listOfEmp=new ArrayList<>();

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

	public Names getRandomNamesFromJson(){
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
	public static List<String> getNames(){
		
		VariablesAndTechniques object = new VariablesAndTechniques();
		//populate names and surnames
		List<String> namesList = new ArrayList<>();
		namesList.addAll(object.getRandomNamesFromJson().getMale());
		namesList.addAll(object.getRandomNamesFromJson().getFemale());
		return namesList;
	}
	public static List<Employee> getLargeEmployeeList(){
		List<Employee> listOfEmp=new ArrayList<>();
		VariablesAndTechniques object = new VariablesAndTechniques();

		//get address from pops file
		List<Address> addressList = new ArrayList<>(object.populateAddress());

		//populate names and surnames
		List<String> namesList = new ArrayList<>();
		namesList.addAll(object.getRandomNamesFromJson().getMale());
		namesList.addAll(object.getRandomNamesFromJson().getFemale());
		List<String> surNamesList = new ArrayList<>();
		surNamesList.addAll(object.getRandomNamesFromJson().getSurnames());


		IntStream.range(0, 1000)
		.forEach(num-> {
			listOfEmp.add(
					Employee.builder()
					.id(num)
					.empId(LocalDate.now().getYear()+"-"
							+mixAlphas[random.nextInt(mixAlphas.length-1)]+""
							+getRandomNumber(100, 999)+"-"+
							+getRandomNumber(1000, 9999))
					.f_name(namesList.get(random.nextInt(namesList.size()-1)))
					.l_name(surNamesList.get(random.nextInt(surNamesList.size()-1)))
					.role(roles[random.nextInt(roles.length)])
					.company(companies[random.nextInt(companies.length)])
					.age(getRandomNumber(18,80))
					.salary(getRandomNumber(10000, 9999999))
					.address(addressList.get(random.nextInt(addressList.size()-1)))
					.build());


		});

		return   listOfEmp;



	}

	static int getRandomNumber(int start, int end) {
		return random.nextInt(end-start+1)+start;
	}


	public static void main(String[] args) {

		//		populateEmployee();
		//		    
		//			for(Employee s:populateEmployee()) {
		//				System.out.println(s.toString());
		//			}
		//			
		//			populateLargeEmployee();
		//			for(Employee s:populateLargeEmployee()) {
		//				System.out.println(s.toString());
		//			}
		//			
		//			VariablesAndTechniques techniques = new VariablesAndTechniques();
		//		
		//		System.out.println(techniques.populateAddress().size());
		//		System.out.println(techniques.getRandomNamesFromJson().getFemale().size());
		//	getLargeEmployeeList().stream().limit(100).forEach(e -> System.out.println(e));

		//System.out.println(e);

	}		


}
