package basic.experiments.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicSorting {
    /*
    * Created to count loop value in each sorting algorithm*/
    static int count=0;

    public static void main(String[] args) {
        int[] arr = {6,5,3,6,3,4,2,1};
        sortArray(arr);

        System.out.println("\nBefore recursive bubble sort :"+ Arrays.toString(arr));
        recursive_bubble_sort(arr, arr.length);
        System.out.println("After recursive bubble sort :"+ Arrays.toString(arr));

        System.out.println("\nBefore merge sort :"+ Arrays.toString(arr));
        merge_sort(arr, 0, arr.length-1);
        System.out.println("After merge sort :"+ Arrays.toString(arr));


        findMinMaxInArray(arr);

        bubble_sort(arr);

        insertion_sort(arr);

        selectionSort(arr);






    }

    public static void recursive_bubble_sort(int[] arr, int n){
        if( n==1 ) return;

        for(int j =0; j <= n-2; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
        recursive_bubble_sort(arr, n-1);

        }

    /*
    * Please refer to article : https://takeuforward.org/data-structure/merge-sort-algorithm/*/
    public static void merge_sort(int[] arr, int low , int high){
        if(low >= high) return;
        int mid = (low + high)/2;
        merge_sort(arr, low, mid);
        merge_sort(arr, mid+1, high);
        merge(arr, low, mid, high);

    }
/*
* The following merge method merges the give two hypothetical arrays
*/
    public static void merge(int[] arr , int low , int mid , int high){

        int left = low;
        int right = mid+1;
        List<Integer> temporary = new ArrayList<>();

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temporary.add( arr[left] );
                left++;
            }else {
                temporary.add(arr[right]);
                right++;
            }
        }
        //if the items are still left in left side
        while(left <= mid){
            temporary.add(arr[left] );
            left++;
        }

        //items on the right side are still left

        while(right <= high){
            temporary.add(arr[right]);
            right++;
        }

        //getting the sorted and merged values into original array from temporary list
        for (int i = low; i <= high; i++) {
            arr[i] = temporary.get(i-low);
        }


    }

    private static void insertion_sort(int[] arr) {
        count =0;
        System.out.println("\nBefore insertion sort :"+ Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++){

//            for(int j =i; j>0 && arr[j-1] > arr[j]; j--){
//                swap(arr,j-1,j);
//                count++;
//            }
            /*We can write above code using while loop also*/
            int j = i;
            //compare each element from j = 0 to j =i and push the max element to right
            while(j>0 &&  arr[j-1] > arr[j]){
                swap(arr,j-1,j);
                count++;
            }
        }
        System.out.println("After insertion sort :"+ Arrays.toString(arr)+" with count :"+ count);
    }

    private static void bubble_sort(int[] arr) {
        count =0;
        System.out.println("\nBefore bubble sort :"+ Arrays.toString(arr));
        for (int i = arr.length-1; i>=0; i--){
             boolean check = false;
            //compare each element from 0 to i-1 and push the highest element to i-1 i.e last;
            for(int j =0; j <= i-1; j++){
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    check = true;
                }

                count++;
            }
            //if the array is in ascending order already , cancel the next loops
            if(check == false) break;
        }
        System.out.println("After bubble sort :"+ Arrays.toString(arr)+" with count :"+ count);
    }

    private static void selectionSort(int[] arr) {
        count = 0;
        System.out.println("\nBefore selection sort :"+ Arrays.toString(arr));

        for(int i = 0; i< arr.length; i++){

            /*
            * Finding minimum number index between i and n-1
            * Then store the index in min variable*/
            int min =i;
            for(int j = i; j< arr.length; j++){
                if(arr[j] < arr[i] ) min = j;
                count++;
            }
            /*
            * After finding minimum number index , swapping it with index i */
            int temp = arr[i] ;
            arr[i] = arr[min];
            arr[min] = temp;
        }

        System.out.println("After selection sort :"+ Arrays.toString(arr)+" with count :"+ count);
    }

    private static void swap(int[] arr, int i , int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    private static void findMinMaxInArray(int[] arr) {
        int min = arr[0];
        int max = 0;
        for (int i: arr) {
            min = Math.min(min,i);
            max = Math.max(max, i);
        }

        System.out.println("Minimum number in array is "+ min);
        System.out.println("Maximum number in array is "+ max);
    }

    private static void sortArray(int[] arr) {
        count =0;
        int counter =0;

        for(int i = 0; i< arr.length; i++){
            for (int j = 0; j< arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] =temp;

                }
                count++;
                counter++;
            }
        }
        System.out.println(counter);
        System.out.println("\n\n\n"+Arrays.toString(arr)+" with count :"+ count);
    }
}
