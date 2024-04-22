package arrays;

import java.util.TreeSet;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] arr = {1,7,7,7,7,7,7,7};
//        int n = arr.length;
//        for(int i = 0; i <; i--){
//            for(int j=0; j<i; j++){
//                if (arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//
//            if(i < n-2 && if)
//
//        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i: arr) {
            treeSet.add(i);
        }
       for (int i=0; i<2; i++){
           if(i==1) System.out.println(treeSet.pollLast());
           treeSet.pollLast();
       }

    }
}
