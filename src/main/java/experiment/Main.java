package experiment;

import basic.experiments.pojos.Employee;

import java.util.*;

public class Main {

    static final int i;

    static {
        i =9;
    }


    public static final void staticMethod(){
        System.out.println("hi");
    }

    public static void main(String[] args) {

//        Employee emp = null;
//        System.out.println("This "+emp.getId());

       // Solution solution = new Solution();

       // isomorphicString("apple", "bbnbm");

        //frequencySort("tree");

        int[] nums = new int[]{7 ,4 ,1 ,5 ,3};
       // selectionSort(nums);

       // insertionSort(nums);

       // wordPattern("abba", "dog cat cat dog");

        int[] arr = new int[]{17,18,5,4,6,1};

        replaceElements(arr);



    }

    public static int[] replaceElements(int[] arr) {

        Stack<Integer> stack = new Stack<Integer>();

        int max = Integer.MIN_VALUE;

        stack.push(-1);

        for(int i = arr.length-1; i >0; i--){

            max = Math.max(max, arr[i]);

            stack.push(max);

        }

        for(int i = 0; i <= stack.size(); i++){

            arr[i] = stack.pop();
        }

        return arr;

    }


    public static boolean wordPattern(String pattern, String s) {

        Map<Character, String> store = new HashMap<Character, String>();

        String[] str = s.split(" ");

        if(pattern.length() != str.length) return false;

        for(int i = 0; i < str.length; i++){

            String value = store.put( pattern.charAt(i), str[i]);
            if(value != null && !value.equals(str[i])){

                return false;
            }
        }

        return true;

    }

    public static int[] insertionSort(int[] nums) {
        int n = nums.length; // Size of the array

        for(int i =1; i < nums.length; i++){

            int j = i-1;

            while(j >= 0 && nums[j] > nums[i]){

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }

        return nums;
    }

    public static int[] selectionSort(int[] nums) {


        int k = 0;
        for(int i =0; i < nums.length; i++){

            int smallest = nums[i];

            for(int j = i; j < nums.length; j++){

                if(smallest > nums[j]) {

                    smallest = Math.min(smallest,nums[j]);
                    k = j;

                }

            }

            nums[k] = nums[i];
            nums[i] = smallest;
        }

        return nums;

    }

    public static List<Character> frequencySort(String s) {
        // Your code goes here

        int[] arr = new int[26];
        int max = 0;
        int min = s.length();

        for(Character c: s.toCharArray()){
            arr[c - 'a']++;
            max = Math.max(arr[c-'a'], max);
            min = Math.min(arr[c-'a'], min);
        }

        List<Character> finalList = new ArrayList<>();

        for(int i = max; i >= min; i--){

            List<Character> tempList = new ArrayList<Character>();
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == i){
                    char c = (char)(j+97);
                    System.out.println(c);
                    tempList.add(c);
                }
            }
            tempList.sort(null);
            finalList.addAll(tempList);

        }

        return finalList;
    }

    public static boolean isomorphicString(String s, String t) {
        //your code goes here

        if(s.length() != t.length()) return false;

        Map<Character, Character> store = new HashMap<Character, Character>();

        for(int i = 0; i < s.length(); i++){

            Character c = store.getOrDefault(s.charAt(i), null);

            Character v = store.put(s.charAt(i), t.charAt(i));

            if(c != null && c != v) return false;
        }

        return true;
    }

    public int printParams(int i){
        System.out.println(i);
        return i;
    }

    public  char printParams(int i, char c){
        System.out.println(i);
        return c;
    }
}

class Solution {
    public int secondMostFrequentElement(int[] nums) {

        Map<Integer, Integer> store = new HashMap<>();

        for(int i = 0; i<nums.length; i++){

            store.put(nums[i], store.getOrDefault(nums[i], 0)+1);
        }

        int fFreq = 0;
        int sFreq = 0;
        int fEle = Integer.MIN_VALUE;
        int sEle = Integer.MIN_VALUE;

        for(Integer i: store.keySet()){

            int freq = store.get(i);


            if(freq >  fFreq){
                sFreq = fFreq;
                sEle = fEle;
                fFreq = freq;
                fEle = i;
            }

            // else if (freq == fFreq){
            //     sFreq = fFreq;
            //     sEle = Math.min(i,fEle);
            //     fEle = i;
            // }

            else if(freq < fFreq && freq > sFreq){

                sFreq = freq;
                sEle = i;

            }


            if(freq == sFreq){

                sEle = Math.min(i, sEle);
            }
        }


        return sEle == Integer.MIN_VALUE ? -1 : sEle;

    }
}

class MainChild1{

    public int printParams(int i){
        System.out.println(i);
        return i;
    }

}
class MainChild2 extends MainChild1
{
//    public char printParams(int i){
//        System.out.println(i);
//        return '';
//    }

    public static void main(String[] args) {
        String s1 = "knowledge";
        String s2 = s1;            // s2 points to the same "knowledge"
        s1 = s1.concat(" base");   // creates a new String "knowledge base"

        System.out.println(s1+"  --  "+s2);
    }




}