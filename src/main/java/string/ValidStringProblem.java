package string;

import java.util.Arrays;
import java.util.HashMap;

public class ValidStringProblem {

    public static void main(String[] args) {
        String inputStirng ="ifhqp83yr902384ybv vuqwyrp8f qc38519yr p9y8dsjf%#";

        reverseString(inputStirng);

        String s1 = "silent";
        String s2 = "listen";

        //check anagram

        System.out.println( anagram(s1, s2));
        System.out.println( anagram2(s1, s2));
    }

    private static void reverseString(String inputStirng) {
        char[] charArray = inputStirng.toCharArray();
        for(int i = 0; i < inputStirng.length()/2; i++){

            char temp = charArray[i];
            charArray[i] = charArray[charArray.length -1 -i];
            charArray[charArray.length -1 -i] = temp;
        }

        //validate the reversed string
        StringBuilder stringBuilder = new StringBuilder(inputStirng);
        if( stringBuilder.reverse().toString().equals( String.valueOf(charArray) )) System.out.println("reversed");
        else System.out.println("not correct");
    }

    private static String anagram2(String s1, String s2) {
        if(s1.length() != s2.length()) return "not an anagram";

        int[] hashArray = new int[256];
        for(int i =0; i< s1.length(); i++){
            hashArray[s1.charAt(i)]++;
            hashArray[s2.charAt(i)]--;
        }

        for(int i =0; i< hashArray.length; i++){
            if(hashArray[i]!=0) return  "not an anagram";
        }

        return "it is an anagram";
    }

    private static String anagram(String s1, String s2) {
        if(s1.length() != s2.length()) return "not an anagram";

        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        for(int i = 0; i< s1.length(); i++){

            if(hashMap.containsKey(s1Array[i]))
                hashMap.put(s1Array[i], hashMap.get(s1Array[1])+1);
            else hashMap.put(s1Array[i],1);

        }
        for(int i = 0; i< s1.length(); i++){

            if(hashMap.containsKey(s2Array[i]))
                hashMap.put(s2Array[i],hashMap.get(s2Array[1])-1);
            else return "not an anagram";

        }

        for(int i: hashMap.values()){
            if(i>1) return "not an anagram";
        }

        return "an anagram";
    }
}
