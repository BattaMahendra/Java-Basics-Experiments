package printing.order;

public class RaceBike extends SportsBike {

	public RaceBike() {
		System.out.println(" RaceBike : no - args constructor");
	}
	
	static {
		System.out.println("RaceBike Class :: this is static block 1 from");
	}
	
	{
		System.out.println("RaceBike Class :: this is instance block 1 from");
	}
	
	int wheels =5;

	@Override
	public void testInheritance(){
		System.out.println("RaceBike  and wheels "+ this.wheels);
	}

}
