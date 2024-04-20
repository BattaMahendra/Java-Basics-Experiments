package basic.experiments.sorting;

import java.util.Arrays;

public class BasicSorting {

    public static void main(String[] args) {
        int[] arr = {6};
        sortArray(arr);

        findMinMaxInArray(arr);
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
