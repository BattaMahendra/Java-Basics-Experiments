package oops.Immutable;

import lombok.ToString;

@ToString
public final  class Battery implements Cloneable {
	
	private int capacity;
	
	private String company;
	
	public Battery(int cap, String company) {
		this.capacity = cap;
		this.company = company;
	}
	
	@Override
	protected Battery clone() throws CloneNotSupportedException {
		
		return (Battery) super.clone();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
