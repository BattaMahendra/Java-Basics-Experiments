package string;

public class expermiment {
	
	public static void main(String[] args) {
		String s = "Mahendra";
		String v = "Mahendra";
		String t = new String("Mahendra");
		System.out.println("============================================="+"\n"
		+"Objects hash codes"+ "\n"
				);
		System.out.println(s.hashCode()+"\n"+v.hashCode()+"\n"+t.hashCode());
		System.out.println("============================================="+"\n"
				+"Objects memory locations"
				+ "\n");
		System.out.println(System.identityHashCode(s)+"\n"+System.identityHashCode(v)
		+"\n"+System.identityHashCode(t
				));
		System.out.println(s==v);
		System.out.println(s==t);
		System.out.println(s.equals(t));
	}

}