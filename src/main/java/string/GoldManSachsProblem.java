package string;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

        Map<String, Integer> noOfSubjects = new HashMap<>();
        Map<String, Integer> totalMarks = new HashMap<>();

        for(int i =0; i < objectArray.length; i++){

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


        //reverse given sentence

        String sentence = "Hi I will crack gold man sachs job";

        String[] strArray  = sentence.split(" ");
        int length = strArray.length;
        for(int i =0; i< length/2; i++){

            String temp = strArray[i];
            strArray[i] = strArray[length-1-i];
            strArray[length-1-i] = temp;
        }

        System.out.println(Arrays.toString(strArray));
        String[] strArray2  = sentence.split(" ");
        Collections.reverse(Arrays.asList(strArray2));
        System.out.println(String.join(" ", strArray2));

    }
}
