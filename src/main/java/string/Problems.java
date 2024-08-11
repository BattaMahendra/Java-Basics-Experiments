package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problems {

    public static void main(String[] args) {
        String given  = "LEVEL";
        isPalindromeTraditional(given);

        //find highest and lowest frequency of chars in a string
        String name = "Mahendra";
        findHighestAndLowestFrequencyElements(name);


    }

    private static void findHighestAndLowestFrequencyElements(String name) {
        char[] charArray = name.toCharArray();

        //add elements into map
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c: charArray){
            charMap.put(c , charMap.getOrDefault(c,1));

            //instead of above line we can also use
            //map.merge(key, value, BiFunction)
            charMap.merge(c, 1 , Integer::sum);
        }

        //declare max and min values and elements
        int max = 0;
        int min = charArray.length;
        char maxEle = 0;
        char minEle = 0;

        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){

            if(entry.getValue() < min){
                min = entry.getValue();
                minEle = entry.getKey();
            }
            if(entry.getValue() > max){
                max = entry.getValue();
                maxEle = entry.getKey();
            }
        }

        System.out.println("max repeated char: "+ maxEle +" with count : "+ max);
        System.out.println("min repeated char: "+ minEle +" with count : "+ min);
    }

    private static void isPalindromeTraditional(String given) {
        char[] charArray = given.toCharArray();
        String reversed = "";
        for(int i=0; i<charArray.length; i++){
            reversed = reversed + charArray[charArray.length-1-i];
        }
        if(given.equals(reversed)) System.out.println(given +" : is palindrome ");
        else System.out.println(reversed+ ": not a palindrome");

        //Method-2 --> Using IntStream
        System.out.println("is given word palindrome:  "+
                IntStream.
                        range(0,given.length()/2).
                        allMatch(i -> given.charAt(i) == given.charAt(given.length()-1-i))

        );
    }
}
