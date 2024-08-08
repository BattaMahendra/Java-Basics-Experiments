package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Problem1 {
	
	public static void main(String[] args) {
		
//		String s = "abcabcabc";
//		problemSol(s);
//		
		String p2 ="{[()]}";
		
		String s2 = "a3b2c1";
		problem2(s2);

		
	}

	/*
	 * input - a3b3c3
	 * output - aaabbbccc
	 */
	private static StringBuilder problem2(String s2) {
		
		if(s2.toCharArray().length %2 != 0) return null;
		char[] chars = new char[s2.length()/2];
		char[] repeat = new char[s2.length()/2];
		int count =0;
		int count1 =0;
		for(int i=0; i<s2.toCharArray().length; i++) {
			if(i%2==0) chars[count++]= s2.toCharArray()[i];
			else repeat[count1++] = s2.toCharArray()[i];
		}
		StringBuilder st = new StringBuilder();
		for(int i=0; i<chars.length; i++) {
			
			for(int j=0; j< repeat[i]-'0'; j++) {
				st.append(chars[i]);
			}
		}
		
		System.out.println(st);
		return st;
	}



	//input - aaabbbccc
	//output - a3b3c3
	private static void problemSol(String s) {
		
		char[] charArr = s.toCharArray();
		Arrays.sort(charArr);
		
		
		Map<Character , Integer> storemap = new HashMap<>();
		 
		for(int i =0; i<charArr.length; i++) {
			
			if(!storemap.containsKey(charArr[i])) storemap.put(charArr[i], 1);
			
			else storemap.put(charArr[i], storemap.get(charArr[i])+1);
		}
		StringBuilder st = new StringBuilder();
		
		storemap.entrySet().forEach(entry -> {
			st.append(entry.getKey()+""+entry.getValue());
		});
		
		System.out.println(st);
	}

	/*
	 * more efficient approach for above problem*/
	public static String compressString(String input) {
		if (input == null || input.isEmpty()) {
			return "";
		}

		StringBuilder compressed = new StringBuilder();
		int count = 1;

		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				count++;
			} else {
				compressed.append(input.charAt(i - 1)).append(count);
				count = 1;
			}
		}

		// Append the last character and its count
		compressed.append(input.charAt(input.length() - 1)).append(count);
		System.out.println(compressed);
		return compressed.toString();
	}

}
