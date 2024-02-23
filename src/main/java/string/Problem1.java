package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Problem1 {
	
	public static void main(String[] args) {
		
		String s = "abcabcabc";
		problemSol(s);
		
		String p2 ="{[()]}";
		
		
	}

	//input - aaabbbccc
	//output - a3b3c3
	private static void problemSol(String s) {
		char[] charArr = s.toCharArray();
		//Arrays.sort(charArr);
		int count =1;
		Map<Character , Integer> storemap = new HashMap<>();
		 
		for(int i =0; i<charArr.length; i++) {
			
			if(!storemap.containsKey(charArr[i]))
			storemap.put(charArr[i], count);
			else storemap.put(charArr[i], storemap.get(charArr[i])+1);
		}
		StringBuilder st = new StringBuilder();
		storemap.entrySet().forEach(entry -> {
			st.append(entry.getKey()+""+entry.getValue());
		});
		
		System.out.println(st);
	}

}
