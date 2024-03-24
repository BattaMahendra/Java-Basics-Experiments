package string;

import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public static void main(String[] args) {
        //extract the digits from a String
        String input = "143Kishore";
        bruteForceApproach(input);
        regexApproach(input);

        //Find first non repetetive character in Array
        String s = "111aaaabbbbbbbbbcchccccccjjjjj";
        indexBasedApproach(s);
        System.out.println(sortApproach(s));
        mapBased(s);
    }

    private static void indexBasedApproach(String s) {
        char ch = 0;
        for(char chr : s.toCharArray()){
            if(s.indexOf(chr) == s.lastIndexOf(chr)){
                ch = chr;
                break;
            }
        }
        System.out.println(ch);
    }

    private static Character sortApproach(String s) {
        Map<Character,Integer> storeMap = new HashMap<>();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        char firstNonRepetitive ;
        int length = ch.length-1;
        //checking for first and last indexes in Array
        if( ch[0]!=ch[1]) return ch[0];
        else if( ch[length]!=ch[length-1]) return ch[length];
        for(int i=1; i<ch.length-1; i++){
             if (ch[i]!=ch[i-1] && ch[i]!=ch[i+1] ) return ch[i];
        }
        return null;
    }

    private static void mapBased(String s) {
        Map<Character,Integer> storeMap = new HashMap<>();
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(storeMap.containsKey(ch[i]))
                storeMap.put(ch[i] , storeMap.get(ch[i])+1);
            else storeMap.put(ch[i],0);
        }
        System.out.println(storeMap);
        storeMap.entrySet().stream().filter(entry -> entry.getValue()==0)
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    private static void regexApproach(String input) {
        int value = Integer.parseInt(input.replaceAll("[^0-9]", ""));
    }

    private static void bruteForceApproach(String input) {
        char[] c = input.toCharArray();
        char[] numArray = {'0','1','2','3','4','5','6','7','8','9'};
        String num ="";
        for(int i=0; i<c.length;i++){
            for(int j=0; j<numArray.length; j++){
                if(c[i]==numArray[j]){
                    num +=c[i];
                }
            }
        }
        System.out.println(Integer.parseInt(num));
    }
}
