package basic.experiments.sorting;

import java.util.Arrays;

public class BasicSorting {

    public static void main(String[] args) {
        int[] arr = {6,5,3,6,3,4,2,1};
        sortArray(arr);

        findMinMaxInArray(arr);

        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {

        System.out.println("\nBefore selection sort :"+ Arrays.toString(arr));

        for(int i = 0; i< arr.length; i++){

            /*
            * Finding minimum number index between i and n-1
            * Then store the index in min variable*/
            int min =i;
            for(int j = i; j< arr.length; j++){
                if(arr[j] < arr[i] ) min = j;
            }
            /*
            * After finding minimum number index , swapping it with index i */
            int temp = arr[i] ;
            arr[i] = arr[min];
            arr[min] = temp;
        }

        System.out.println("After selection sort :"+ Arrays.toString(arr));
    }

    private static void swap(int i , int j){
        i = i + j;
        j = i - j;
        i = i - j;
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
        int counter =0;

        for(int i = 0; i< arr.length; i++){
            for (int j = 0; j< arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] =temp;

                }
                counter++;
            }
        }
        System.out.println(counter);
        System.out.println("\n\n\n"+Arrays.toString(arr));
    }
}
