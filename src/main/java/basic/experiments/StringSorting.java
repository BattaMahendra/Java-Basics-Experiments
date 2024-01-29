package basic.experiments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringSorting {
	
	public static String s ="s1a2u3r4a5v6";
	public static String s2="javajavajee";
	
	public static String sortString(String s) {
		String temp1=s.replaceAll("[0-9]", "");
		String temp2=s.replaceAll("[^0-9]", "");
		
		
		return temp2+temp1;
	}
	
	public static void countCharsInString(String s) {
		Map<Character, Integer> hashMap =new HashMap<>();
		
		s.chars().mapToObj(intChar -> (char)intChar)
		.collect(Collectors.toList())
		.stream()
		.map(ch ->{
			if(hashMap.containsKey(ch)) {
				hashMap.put(ch, hashMap.get(ch)+1);
			}else hashMap.put(ch, 1);
			return null;
		}).collect(Collectors.toList());
		System.out.println(hashMap);
	}

	public static void main(String[] args) {
		countCharsInString(s2);
//		System.out.println(
		
	}
}
