package basic.experiments.sorting;

import java.util.Arrays;

public class BasicSorting {
    /*
    * Created to count loop value in each sorting algorithm*/
    static int count=0;

    public static void main(String[] args) {
        int[] arr = {6,5,3,6,3,4,2,1};
        sortArray(arr);



        findMinMaxInArray(arr);

        bubble_sort(arr);

        insertion_sort(arr);

        selectionSort(arr);



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
            //compare each element from 0 to i-1 and push the highest element to i-1;
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
                if(arr[i] < arr[j]){
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
