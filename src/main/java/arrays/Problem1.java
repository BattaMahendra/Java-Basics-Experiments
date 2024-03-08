package arrays;

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        populateArray(arr);

        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

    private static void populateArray(int[][] arr) {
        int num =0;
        for (int i = 0; i< arr.length; i++){
            for (int j = 0; j< arr[i].length; j++){

                arr[i][j]=num++;


            }
        }
    }
}
