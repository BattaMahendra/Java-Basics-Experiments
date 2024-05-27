package oops.Immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class SmartPhone {

	public SmartPhone(double price, String model, Map<String, String> specifications, List<String> subModels,
			Battery battery) {
		super();
		this.price = price;
		this.model = model;
		
		//performing deep copy for map
//		Map<String , String> temporary = new HashMap<>();
//		specifications
//			.entrySet()
//				.forEach(entry -> temporary.put(entry.getKey(), entry.getValue()));
//		this.specifications = temporary;
		
		this.specifications = specifications;
		this.subModels = subModels;
		this.battery = battery;
	}

	private final double price;
	
	private final String model;
	
	private final Map<String , String> specifications;
	
	private final List<String> subModels;
	
	private final Battery battery;

	public double getPrice() {
		return price;
	}

	public String getModel() {
		return model;
	}

	/*
	 * we are always returning new hashmap with 
	 * initialized values and by doing this the specifications 
	 * can never be mutable
	 * even the client class tries to store in it 
	 * it doesn't store and always return new hashmap with initialized values
	 * 
	 */
	public Map<String, String> getSpecifications() {
		
		return new HashMap<String, String> (specifications);
	}

	public List<String> getSubModels() {
		return new ArrayList<String>(subModels);
	}

	/*
	 * we are cloning the battery class so that its values can never be 
	 * overrided once initialized 
	 * because this clone method which comes from the Battery class will 
	 * always return the battery object initialized with specifications
	 */
	public Battery getBattery() throws CloneNotSupportedException {
		return  battery.clone();
		//return battery;
	}

	@Override
	public String toString() {
		try {
			return "SmartPhone [price=" + price + ", model=" + model + ", specifications=" + specifications + ", subModels="
					+ subModels + ", battery=" + battery + ", getPrice()=" + getPrice() + ", getModel()=" + getModel()
					+ ", getSpecifications()=" + getSpecifications() + ", getSubModels()=" + getSubModels()
					+ ", getBattery()=" + getBattery() + "]";
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "exception occured in to string method";
	}
	
	
	
	
}
