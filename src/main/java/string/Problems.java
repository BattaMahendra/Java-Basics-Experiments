package string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problems {

    public static void main(String[] args) {
        String given  = "LEVEL";
        isPalindromeTraditional(given);

        System.out.println("is given word palindrome:  "+
                IntStream.
                        range(0,given.length()).
                        allMatch(i -> given.charAt(i) == given.charAt(given.length()-1-i))

        );
    }

    private static void isPalindromeTraditional(String given) {
        char[] charArray = given.toCharArray();
        String reversed = "";
        for(int i=0; i<charArray.length; i++){
            reversed = reversed + charArray[charArray.length-1-i];
        }
        if(given.equals(reversed)) System.out.println(given +" : is palindrome ");
        else System.out.println(reversed+ ": not a palindrome");
    }
}
