package basic.experiments.pojos;

import java.util.ArrayList;
import java.util.List;

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
	
	public Employee(int id, String f_name, String l_name, String company, String role) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.company = company;
		this.role = role;
	}
	
	int id;
	String f_name;
	String l_name;
	String company;
	String role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
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
