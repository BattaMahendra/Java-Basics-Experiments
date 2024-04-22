package arrays;

import java.util.TreeSet;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] arr = {22,22,21,21,20,6,2,9,1,4,8,3,7,2,10,10,9,8,22};

        secondLargestElementUsingTreeSet(arr);
        //  {1,2,3,4,5,6}
        findSecondLargestElement(arr);

    }

    private static void secondLargestElementUsingTreeSet(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i: arr) {
            treeSet.add(i);
        }
        for (int i=0; i<2; i++){
            if(i==1) System.out.println(treeSet.pollLast());
            treeSet.pollLast();
        }
    }

    private static void findSecondLargestElement(int[] arr) {
        int large = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE, thirdLarge = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0; i < n; i++){
             if(arr[i]>large){
                 thirdLarge = secondLarge;
                 secondLarge = large;
                 large = arr[i]; // 7

             }
             else if(arr[i] > secondLarge && arr[i] < large){
                 thirdLarge = secondLarge;
                 secondLarge = arr[i]; // 7
             }
            else if(arr[i] > thirdLarge && arr[i] < secondLarge && arr[i] < large){
                thirdLarge = arr[i];
            }
        }

        System.out.println("\n"+large +"\n"+secondLarge+"\n"+thirdLarge);
    }
}
