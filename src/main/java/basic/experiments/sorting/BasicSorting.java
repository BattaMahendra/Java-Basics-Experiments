package basic.experiments.sorting;

import java.util.Arrays;

public class BasicSorting {

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,1,0};
        int counter =0;

        for(int i =0; i< arr.length; i++){
            for (int j=0; j<arr.length; j++){
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
