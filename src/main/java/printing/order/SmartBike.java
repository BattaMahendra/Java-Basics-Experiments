package printing.order;

public class SmartBike extends Bike {

	static {
		System.out.println("SmartBike Class :: this is static block 1 from");
	}

	{
		System.out.println("SmartBike Class :: this is instance block 1 from");
	}

	public SmartBike() {
		System.out.println(" SmartBike : no - args constructor");
	}

	int wheels =3;

	@Override
	public void testInheritance(){
		System.out.println("SmartBike  and wheels "+ this.wheels);
	}
	
	
	public static void testInheritanceStatic(){
		System.out.println("SmartBike Static");
	}

	public static void main(String[] args) {
		System.out.println("main method start");
		new SmartBike();
	}
}
