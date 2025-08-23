package basic.experiments.pojos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Employee {
	
	public Employee() {
		super();
	}
	
	public Employee(int id, String empId, String f_name, String lastName, String company, String role, int age , double salary, Address a , String doj) {
		super();
		this.id = id;
		this.firstName = f_name;
		this.lastName = lastName;
		this.company = company;
		this.role = role;
		this.age = age;
		this.salary=salary;
		this.address = a;
		this.empId=empId;
		this.dob =doj;
	}
	
	int id;
	String empId;
	String firstName;
	String lastName;
	String company;
	String role;
	int age;
	double salary;
	Address address;
	String dob;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}




