import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class BasicExperiments {

    public void BasicExperiments(){

    }

    public static String reverseWords(String s) {

        s = s.trim();
        String[] arr = s.split(" ");

        int n = arr.length;

        for(int i = 0; i < n/2; i++){

            String temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }

        String ans = "";
        for(String m: arr){
            String q = m.trim();
            ans = ans+q+" ";
        }

        return ans.trim();

    }



    public static void main(String[] args) {
       Optional find =  Stream.of("one", "two", "three", "four")
                .map(String::toUpperCase)
                .filter(s -> s.length() > 3) .findFirst();

        System.out.println(find);

        System.out.println(10*20+"Mahendra");
        System.out.println("Mahendra"+10*20);

        String s = "Mahendra";

        char[]  chA = s.toCharArray();

        for(int i=0; i < chA.length; i++){
            if(chA[i]=='M'){
                chA[i] =' ';
            }
            System.out.print(chA[i]);
        }

        String.valueOf(chA).replace(" ", "");
        System.out.println("\n"+String.valueOf(chA));


//        for(int i=0;0;i++){
//            System.out.println("Hello world");
//        }

//        int[] arr = new int[]{1,2,3,-2,2,4,-1,1,2,-1};
//        //subarraySum(arr, 3);
//        longestSubarray(arr, 5);



        reverseWords("gmo   cpqa   zfu   ldqu  t");

        int[] arr = new int[]{5, 4, 1, 8, 7, 1, 3};
        maxScore(arr, 3);

        print(1,2,3,4,5);


    }

    public static void print(Integer ... nums){
        System.out.println(nums.length);
    }

    public static int maxScore(int[] arr, int k) {
        //your code goes here

        int maxSum = 0;
        int leftSum = 0;
        int rightSum = 0;

        for(int i=0; i<k; i++){

            leftSum = leftSum + arr[i];

        }
        maxSum = leftSum;
        int r = arr.length-1;
        System.out.println(maxSum);

        for(int i = k-1; i >=0; i--){

            rightSum = rightSum + arr[r];
            r--;
            leftSum = leftSum - arr[i];
            maxSum = Math.max(maxSum, leftSum+rightSum);
            System.out.println(maxSum);
        }
        return rightSum;
    }
    public static int longestSubarray(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){

            sum = sum + nums[i];
            if(sum == k) len = Math.max(len, i+1);

            if(map.containsKey(sum - k)){
                len = Math.max(len, i-map.get(sum-k));
            }

            map.put(sum, map.getOrDefault(sum-k,i));
        }
        if(map.containsKey(sum - k)){
            len = Math.max(len, nums.length-1-map.get(sum-k));
        }

        return len;

    }

    public static int subarraySum(int[] nums, int k) {

        int left = 0;
        int right = left;
        int sum = nums[left];
        int count = 0;
        while(left <= right && right < nums.length){

            sum = sum + nums[right];
            if(sum == k){
                count++;
                right++;
            }else if( sum < k && sum > 0){
                right++;
            }else if( sum > k && sum > 0){
                left++;
                right = left;
                sum = 0;
            }else if(sum < k && sum <0){

                right++;

            }else if( sum > k && sum < 0){
                left++;
                right = left;
                sum = 0;

            }

        }



        return count;

    }

//    public Integer reverseAInteger(int num){
//
//        String s = "" + num;
//
//        for(int i )
//
//    }
}
