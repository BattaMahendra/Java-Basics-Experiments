package string;

import java.util.List;
import java.util.stream.Collectors;

public class expermiment {
	
	public List<Character> convertStringToCharList(String s) {
		
		List<Character> charList =s.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
		return charList;
	}
	
	public static void main(String[] args) {
		String s = "Mahendra";
		String v = "Mahendra";
		String t = new String("Mahendra");
		String u = new String("Mahendra");
		
		System.out.println("============================================="+"\n"
		+"Objects hash codes"+ "\n"
				);
		System.out.println(s.hashCode()+"\n"+v.hashCode()+"\n"+t.hashCode()+"\n"+u.hashCode());
		System.out.println("============================================="+"\n"
				+"Objects memory locations"
				+ "\n");
		System.out.println(System.identityHashCode(s)+"\n"+System.identityHashCode(v)
		+"\n"+System.identityHashCode(t
				)+"\n"+System.identityHashCode(u
						));
		
		System.out.println("============================================="+"\n");
		System.out.println(s==v); 
		System.out.println(s==t); 
		System.out.println(u==t); 
		System.out.println(s.equals(t)); 
	}

}
