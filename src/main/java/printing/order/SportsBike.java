package printing.order;


public class SportsBike extends SmartBike {

	public SportsBike() {
		System.out.println(" SportsBike : no - args constructor");
	}
	
	static {
		System.out.println("SportsBike Class :: this is static block 1 from");
	}
	
	{
		System.out.println("SportsBike Class :: this is instance block 1 from");
	}
	
	int wheels =4;
	int sportsMeter=5;
	String sA="hello SportsBike";

	
	public void testInheritance(){
		System.out.println("SportsBike  and wheels "+ wheels + sA);
	}
	
	public static void testInheritanceStatic(){
		System.out.println("SportsBike Static");
	}


	public static void main(String[] args) {
		System.out.println("SportsBike : Main method");
		Bike s =new SportsBike();
		System.out.println(s.wheels);
		System.out.println(s.sA);
		s.testInheritance();
//		s.testInheritanceStatic();
		
		System.out.println("===========================");
		SmartBike sm = new SmartBike();
		sm.testInheritance();
		sm.testInheritanceStatic();
		System.out.println("===========================");
		RaceBike r = new RaceBike();
		r.testInheritance();
		
		//Welcome.welcomemsg("Hema");
		
	}
}
