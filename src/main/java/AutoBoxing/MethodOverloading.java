package AutoBoxing;

public class MethodOverloading {

	public static void print(int a) {
		System.out.println("primitive");
	}
	
	public static void print(Integer a) {
		System.out.println("Integer wrapper");
	}
	
	public static void print(Integer... a) {
		System.out.println("var args");
	}
	public static void print(Short a) {
		System.out.println("Short");
	}
	
	/*
	 * we can observe that 
	 * widening >> Autoboxing >> var args
	 */
	public static void main(String[] args) {
		int a =5;
		Integer b = new Integer(6);
		Integer c =7;
		short d =8;
		byte e =9;
		long f= 10;
		print(a); //p
		print(b); //
		print(c); //
		print(d); 
		print(e); 
		//print(f);
	}
	
	
}
