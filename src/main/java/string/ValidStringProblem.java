package string;

import java.util.HashMap;

public class ValidStringProblem {

    public static void main(String[] args) {
        String inputStirng ="ifhqp83yr902384ybv vuqwyrp8f qc38519yr p9y8dsjf%#";

        String s1 = "silent";
        String s2 = "listen";

        //check anagram

        System.out.println( anagram(s1, s2));

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
