package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Union {

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int arr2[] = {2,3,4,4,5,11,12};
        union(arr1, arr2);
    }

    private static void union(int[] arr1, int[] arr2) {
        List<Integer> integerList = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {

                //to avoid duplicates from array 1
                if (integerList.size() == 0 || integerList.get(integerList.size() - 1) != arr1[i])
                    integerList.add(arr1[i]);
                i++;
            } else {

                //to avoid duplicates from array 2
                if (integerList.size() == 0 || integerList.get(integerList.size() - 1) != arr2[j])
                    integerList.add(arr2[j]);
                j++;

            }
        }
        // if any elements left in array 1.
        while(i< arr1.length){
            integerList.add(arr1[i]);
            i++;
        }

        //if any elements left in array 2
        while(j< arr2.length){
            integerList.add(arr2[j]);
            j++;
        }

        System.out.println(integerList);
    }
}
