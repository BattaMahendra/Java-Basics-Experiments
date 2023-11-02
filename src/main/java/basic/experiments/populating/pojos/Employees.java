package basic.experiments.populating.pojos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import basic.experiments.pojos.Emp;

public class Employees {
	
	public static List<Emp> employeeList;
	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
			
		
			employeeList = objectMapper.readValue(new File("C:\\Users\\batta.chowdary\\git\\Java-Basics-Experiments\\Java-Basic-Experiments\\lib\\src\\main\\java\\basic\\experiments\\populating\\pojos\\Employees.txt"), new TypeReference<List<Emp>>() {
			});
			employeeList.forEach( System.out::println);
		
	}
	
	
}
