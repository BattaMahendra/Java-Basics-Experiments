package collections.maps.hashing;


import java.util.Arrays;

/*Refer article : https://takeuforward.org/hashing/hashing-maps-time-complexity-collisions-division-rule-of-hashing-strivers-a2z-dsa-course/*/
public class BasicHashing {

    /*
    * Given an array of [1,2,5,6,7,9,2] of some size with some integers
    * Now you have some problem statement given with values like 2,4,1,9
    * Now your job is to find out the frequency of given values i.e(2,4,1,9) in the above array
    * Then Naive approach will be this */
    public static void main(String[] args) {

        //values to be searched
        int[] queries ={2,4,1,9};

        //given array
        int[] arr = {1,2,5,6,7,8,2};

        //The naive approach
        for (int numberToBeSearched: queries) {
             findFrequencyOfGivenNumberInArray(numberToBeSearched, arr);
        }

        // Hashing technique
        /*First create a hash array with the element value to be searched , for example
        * in the above scenario (2,4,1,9)the max element to be searched is 9 so we will create hash array
        * with size max_element_to_be_searched + 1 i.e 9+1 = 10
        * basically index starts from zero and ends with 9 . Inittially every value will be 0
        * we iterate and make the frequency of all elements in the given array
        * so the hash array index will represent the original array number and hash array value represents frequency*/

        int[] hash = new int[10];
        for (int element: arr) {
            hash[element]++;
        }
        System.out.println( Arrays.toString(hash) );

        /*Now using above hash arry we can easily find the frequency of given number in the given array
        * its just hash[ query_value] gives out the frequency*/

    }

    /*
    * This operation takes O(N) considering arr contains N elements. Now consider we have
    * given Q queries to search with then ovet all complexity with two for loops
    * becomes O(M X N) suppose what if we have an array size of 10^5 abd queries to be
    * searched are 10^5 then whole operation becomes 10^10 which is very big and usually
    * 10^8 operations take 1 second time then 10^10 takes 100 seconds.
    * This is the disadvantage , now lets focus on hashing */
    private static int findFrequencyOfGivenNumberInArray(int numberToBeSearched, int[] arr) {
        int counter =0;
        for (int i = 0; i< arr.length; i++){
            if(arr[i]== numberToBeSearched) counter++;
        }
        return counter;
    }


}
