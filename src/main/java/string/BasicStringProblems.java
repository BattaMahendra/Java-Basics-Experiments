package string;

import java.util.Arrays;
import java.util.List;

public class BasicStringProblems {

    public static void main(String[] args) {

        //check if a string contains given substring or not

        checkForSubstring();

        //check if given words contains vowels or not

//        List<String> namesList = Arrays.asList("","Hello","Namaste","Vanakkam","Namaskara","Namaskaram");
//        namesList.stream().filter(str -> {
//
//            return str.indexOf('a')
//        })

        String s = " Hello        World      ";
        s =s.trim();
        System.out.println(s);
        System.out.println(Arrays.toString(s.split(" ")));

        String num = "12345";
        int i = Integer.valueOf(num);
        System.out.println(i);
        System.out.println(num.substring(4,5));

        System.out.println(('7'-'0')+2);
        System.out.println(('7')+2);

        String s1 = "30";
        String s2 = "3";
        System.out.println(s2.substring(0,1));




        System.out.println(s2.compareTo(s1 ) ) ;





    }

    private static void checkForSubstring() {
        List<String> namesList = Arrays.asList("Hello","Namaste","Vanakkam","Namaskara","Namaskaram");

        //substring to be checked - "Nama"
        namesList.stream().filter(str -> str.contains("Nama")).forEach(System.out::println);


    }
}
