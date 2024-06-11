package arrays;

import java.util.ArrayList;
import java.util.List;

public class ReturnAllPossibleSubArrays {

    public static void main(String[] args) {
        /*
        * Given an arrya return all possible sub arrays without duplicates in it in any order
        * Eg:
            nums = [1,2,3]
            O/p: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
            has context menu */
        int[] arr = {1};
        System.out.println( naiveApproach(arr));
    }

    private static List<? extends Number> naiveApproach(int[] arr) {
        List output = new ArrayList();
        output.add(new ArrayList<>());
        List internalTotal = new ArrayList();
        for(int i = 0; i< arr.length; i++){
            List internal1 = new ArrayList();
            internal1.add(arr[i]);
            internalTotal.add(arr[i]);
            output.add(internal1);
            for(int j =i+1; j< arr.length; j++){
                List internal = new ArrayList();
                internal.add(arr[i]);
                internal.add(arr[j]);
                output.add(internal);
            }

        }
        if(arr.length!=0 && arr.length!=1 ) output.add(internalTotal);
        return output;
    }
}
