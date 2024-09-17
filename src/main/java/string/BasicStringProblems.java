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


    }

    private static void checkForSubstring() {
        List<String> namesList = Arrays.asList("Hello","Namaste","Vanakkam","Namaskara","Namaskaram");

        //substring to be checked - "Nama"
        namesList.stream().filter(str -> str.contains("Nama")).forEach(System.out::println);


    }
}
