package Hemas_Practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Practice {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,1,1,1,1,7,8,9,5,2,36,4,78,222,24,9);

        //find the duplicates in the above list

        HashSet<Integer> hashSet = new HashSet<>();
        //Hashset stores only unique values
        //if a value is unique it returns true
        //if that value is already present in the hashset then it returns false
        for(int i=0; i<list.size(); i++){

        }

        //List internal methods to find out duplicates

        for(int i=0; i<list.size(); i++){

            int value = list.get(i);

            if( list.indexOf(value) != list.lastIndexOf(value)){
                System.out.println(value);
            }

        }


    }
}
