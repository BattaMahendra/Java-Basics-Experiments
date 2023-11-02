package printing.order;

import lombok.ToString;


@ToString
public class Car {

	static int wheels;
	String color;
	
	
	public Car() {
		System.out.println("Constructor");
	}
	
	public Car(String color) {
		this.color=color;
	}
	
	static {
		System.out.println(" Static block 1");
	}
	
	{
		System.out.println(" instance block 1");
	}
	
	static {
		System.out.println(" Static block 2");
	}
	
	public void createWheels() {
		wheels=2;
		color="blue";
	}
	
	public static void main(String... args) {
		System.out.println("Main method");
		Car c1 = new Car();
		Car c2 = new Car("Pink");
		c1.color="black";
		c1.wheels=4;
		
		System.out.println(c2);
		
		
	}
}


