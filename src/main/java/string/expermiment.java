package string;

import basic.experiments.pojos.Emp;
import basic.experiments.pojos.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

		Optional<Integer> hello = new ArrayList<Employee>().stream().filter(r -> r.getId() == 2).findFirst().map(Employee::getId);
		System.out.println(hello);

		String first = "1234";
		String second = new Integer(1234).toString();

		// intern() method forces jvm to add the applied string to string pool
		String third = second.intern();

		System.out.println("============================================="+"\n");
		System.out.println(first==second);
		System.out.println(first==third);
		System.out.println(second==third);


		System.out.println("++++++++++++++++++++++++++");
		List<String> ls = new ArrayList<>();
		List<String> lo = ls;
		lo.add("Mahendra");
		System.out.println(ls);





	}

}
