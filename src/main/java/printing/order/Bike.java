package printing.order;

import java.time.LocalDateTime;

public class Bike {
	
	String color;
	int wheels =2;
	String sA="hello Bike";
	
	public void testInheritance(){
		System.out.println("Bike  and wheels "+ this.wheels);
	}
	
	public static void testInheritanceStatic(){
		System.out.println("Bike Static");
	}

	{
		System.out.println("Bike basic block 1");
	}

	{
		System.out.println("Bike basic block 2");
	}

	static {
		System.out.println("Bike this is static block 1");
	}

	

	public Bike() {
		System.out.println("Bike this is from constructor");
	}
	
	public Bike(String color) {
		System.out.println(" Bike this is from loaded constructor");
		this.color=color;
//		wheels=5;
		System.out.println("we created a "+this.color+ " Bike with "+wheels+" wheels");
	}
	

	public static  void main(String[] hems) {
		
		System.out.println("Main method started at "+ LocalDateTime.now());
		new Bike();
//		new Bike();
//		Bike blackBike = new Bike("BLACK");
//		System.out.println("this is a "+blackBike.color+ " Bike with "+blackBike.wheels+" wheels");
		System.out.println("Main method ended at " + LocalDateTime.now());

	}
	
//	static void main(String[] args, String msg) {
//		System.out.println("hello");
//	}
	
	static {
		System.out.println(" Bike this is static block 2");
	}

}

