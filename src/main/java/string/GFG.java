package string;

import java.util.Arrays;

class GFG {
	public static void main (String[] args) {
		String input = "abcabcabc";
		char[] character = input.toCharArray();
		Arrays.sort(character);
		char temp = input.charAt(0);
		StringBuilder output = new StringBuilder();
		int count =1;
		System.out.println(character);
		for(int i =1; i<character.length;i++) {
			char temp1 = character[i];
			if(temp == temp1){
				count++;
			}else{
				output.append(temp);
				output.append(count);
				count = 1;
				temp = temp1;
			}
		}
		output.append(temp);
		output.append(count);
		System.out.println(output);
		// return output.toString();	
	}
}
