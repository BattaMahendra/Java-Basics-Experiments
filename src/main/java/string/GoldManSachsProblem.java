package string;

import java.sql.SQLOutput;
import java.util.*;

public class GoldManSachsProblem {

    public static void main(String[] args) {
//        Given a list of student names and corresponding marks,
//        return the highest average marks (and print the corresponding student name - optional).
//                The marks can be negative as well and a student may have multiple marks.

//                Example:
        String[][] objectArray = {
                {"Charles", "84"},
                {"John", "100"},
                {"Andy", "37"},
                {"John", "23"},
                {"Charles", "20"}
        };

        highestAverageMarks(objectArray);


        //reverse given sentence

        String sentence = "Hi I will crack gold man sachs job";

        reverseSentence(sentence);

        //find median of two sorted arrays of different sizes
        /*
        * Example:
            arr1[] = {2, 3, 5, 8}
            arr2[] = {10, 12, 14, 16, 18, 20}
            The merged array is :
                arr3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
                if the number of the elements are even,
                so there are two middle elements,
                take the average between the two :
                (10 + 12) / 2 = 11.
                if the number is odd you can return the middle element
            */
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };

        int i = arr1.length;
        int j = arr2.length;

        int[] arr3 = new int[i + j];
        TreeSet<Integer> set = new TreeSet<>();
       for(int k: arr1) set.add(k);
       for(int k: arr2) set.add(k);
       int m =0;
       for(int l: set) arr3[m++] = l;
       if(arr3.length %2 == 0) System.out.println(arr3[arr3.length %2] + arr3[(arr3.length %2) - 1]);
       else System.out.println(arr3[arr3.length %2]);



        System.out.println(Arrays.toString(arr3));



    }

    private static void reverseSentence(String sentence) {
        String[] strArray  = sentence.split(" ");
        int length = strArray.length;
        for(int i =0; i< length/2; i++){

            String temp = strArray[i];
            strArray[i] = strArray[length-1-i];
            strArray[length-1-i] = temp;
        }

        System.out.println(Arrays.toString(strArray));

        //Method-2
        String[] strArray2  = sentence.split(" ");
        Collections.reverse(Arrays.asList(strArray2));
        System.out.println(String.join(" ", strArray2));
    }

    private static void highestAverageMarks(String[][] objectArray) {
        Map<String, Integer> noOfSubjects = new HashMap<>();
        Map<String, Integer> totalMarks = new HashMap<>();

        for(int i = 0; i < objectArray.length; i++){

            String name = objectArray[i][0];
            Integer marks = Integer.parseInt( objectArray[i][1] );
            noOfSubjects.put(name, noOfSubjects.getOrDefault(name,0)+1);
            totalMarks.put(name , totalMarks.getOrDefault(name,0)+marks);
        }

        System.out.println(noOfSubjects +"\n"+ totalMarks);

        double maxAverage = Double.MIN_VALUE;
        for(String name: noOfSubjects.keySet()){

            maxAverage = Math.max(maxAverage, (double) totalMarks.get(name) /noOfSubjects.get(name));

        }
        System.out.println(maxAverage);
    }
}
