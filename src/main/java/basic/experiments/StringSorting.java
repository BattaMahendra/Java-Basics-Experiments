package basic.experiments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringSorting {
	
	public static String s ="s1a2u3r4a5v6"; 
	public static String s1 ="13a22u31r46a52v61"; 
	public static String s2="javajavajee";
	
	public static String sortString(String s) {
		String temp1=s.replaceAll("[0-9]", ""); //saurav
		String temp2=s.replaceAll("[^0-9]", ""); //123456
		
		return temp2+temp1;
	}
	
	public static int[] splitOnlyNumber(String s) {
		
		
		int length = s.toCharArray().length;
		String temp ="";
		char[] charArray = s.toCharArray();
		int[] arr =new int[length];
		int tempInt =0;
		for (int i =0; i<length; i++) {
			
			if(Character.isDigit(charArray[i])) {
				temp = temp.concat(String.valueOf(charArray[i]));
			}else if(!temp.equals("")){
				arr[tempInt++]=Integer.parseInt(temp);
				temp="";
			}
		}
		
		if(!temp.equals("")) arr[tempInt++]=Integer.parseInt(temp);
		
		return arr;
	}
	
	public static int findSumOfDigits(String s ) {
		int sum=0;
		int length = s.toCharArray().length;
		char[] charArray = s.toCharArray();
		for (int i =0; i<length; i++) {
			if(Character.isDigit(charArray[i])) sum+=Character.getNumericValue(charArray[i]);
		}
		
		return sum;
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
	//	countCharsInString(s2);
//		System.out.println(
		
		
		
		//System.out.println(findSumOfDigits("s1a2u3r4a5v6"));
		for(int i:splitOnlyNumber(s1)) {
			System.out.println(i);
		}
		
		String[] str=s1.split("[^0-9]");
		for(String i:str) {
			System.out.println(i);
		}
		
		
	}
}
