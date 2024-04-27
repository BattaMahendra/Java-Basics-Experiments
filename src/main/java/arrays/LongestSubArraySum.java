package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {
    public static void main(String[] args) {

       int[] arr = {2,-1,0,0,1,1};

       int k = 3;

        bruteForce(arr, k);

         mapBased(arr, k);
    }

    private static int mapBased(int[] arr, int k) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        int n = arr.length;
        long sum =0;
        int maxLen=0;
        for(int i =0; i<n; i++){
            sum += arr[i];
            if(sum == k) maxLen = Math.max(maxLen,i+1);

            long remaining = sum - k;
            if(preSumMap.containsKey(remaining))
                maxLen = Math.max(maxLen, i - preSumMap.get(remaining));

            preSumMap.putIfAbsent(sum , i);
        }
        System.out.println(maxLen);
        return maxLen;
    }

    private static void bruteForce(int[] arr, int k) {
        int n = arr.length;
        int initial=0, terminal=0;
        int uppercount =0;


        for(int i =0; i<n; i++ ){
            int count =0,sum=0;
            for(int j=i; j<n; j++){

                sum = sum + arr[j];
                count++;
                if(sum == k && (terminal-initial+1) < count) {
                    initial = i;
                    terminal = j;
                    break;
                }
            }
        }

        int[] subArray = new int[terminal-initial+1];
        int normal =-1;
        for(int i = initial; i<= terminal; i++){
            subArray[++normal] = arr[i];
        }
        System.out.println(Arrays.toString(subArray));
    }
}
