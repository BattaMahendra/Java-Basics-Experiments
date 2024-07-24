package java8.Java_Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepracticeSameProblems {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0,1,1,1,1,7,8,9,5,2,36,4,78,222,24,9);

        //sum of numbers in the list

        int sum = list.stream().mapToInt(i ->i).sum();
        int sum2 = list.stream().reduce(0,Integer::sum);
        int sum3 = list.stream().reduce(592,(i1,i2)-> i1+i2);
        System.out.println(sum+"\n"+sum2+"\n"+sum3);

        //numbers starting with 2

        list.stream().map(String::valueOf).filter(s -> s.startsWith("2")).collect(Collectors.toList());

        //find duplicates in a array list

        List<Integer> duplicates = list.stream().
                                filter( i -> list.indexOf(i) != list.lastIndexOf(i))
                .distinct()
                .collect(Collectors.toList());

        List<Integer> duplicates2 = list.
                stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().
                stream().
                filter(entry -> entry.getValue()>1).
                map(Map.Entry::getKey).
                collect(Collectors.toList());

        System.out.println(duplicates+"\n"+duplicates2);

        //sort values in map

         list.
                stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                 .values()
                 .stream().sorted(Comparator.naturalOrder()).distinct().collect(Collectors.toList());



    }
}
