package arrays;

import java.util.Arrays;

public class RotateArrays {

    public static void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int[]arr,int st,int end){
        while(st<end){
            swap(arr,st,end);
            st++;
            end--;
        }
    }
    public static void rightRotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;                          //[1,2,3,4,5,6,7]
        reverse(nums,0,n-k-1);  //[4,3,2,1,5,6,7]
        reverse(nums,n-k,n-1);  //[4,3,2,1,7,6,5]
        reverse(nums,0,n-1);    //[5,6,7,1,2,3,4]

    }

    public static void leftRotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k =3;
        rightRotate(nums,k);
        System.out.println(Arrays.toString(nums));
        int[] arr= {1,2,3,4,5,6,7};
        leftRotate(arr,k);
        System.out.println(Arrays.toString(arr));

    }
}
