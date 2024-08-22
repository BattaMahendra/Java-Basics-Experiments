package string;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        
          int count = Integer.MIN_VALUE;
        
        for(int i =0; i< s.length(); i++){
            
            int innerCount = Integer.MIN_VALUE;
            
            Map<Character, Integer> map = new HashMap<>();
            
            for(int j =i; j< s.length(); j++){
                
                if(map.containsKey(s.charAt(j))){
                    
                    count = Math.max(count, innerCount);
                    break;
                    }
                map.put(s.charAt(j),0);
                innerCount++;
                
            }
            
        }
        
        return count;
        
    
    }

    public static void main(String[] args) {

        lengthOfLongestSubstring("abcabc");

    }
}