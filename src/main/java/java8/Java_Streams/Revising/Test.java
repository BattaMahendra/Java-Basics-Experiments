package java8.Java_Streams.Revising;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0,1,1,1,1,7,8,9,5,2,36,4,78,222,24,9);
        int sum = 0;


        list.stream().mapToInt(i -> i.intValue()).sum();
        sum = list.stream().collect(Collectors.summingInt(i -> i));
        System.out.println(sum);

        //calculate averge of numbers
        int sum2 = list.stream().reduce(0, (a,b)-> a+b);
        int count = Math.toIntExact((long) list.stream().count());
        System.out.println("average is : "+sum2/count);

        //what if incoming list has some null values
        double avg = list.stream()
                            .filter(i -> i != null)  //filtering out null values
                            .filter(Objects::nonNull)   // we can also use method reference instead of above lambda
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(0.0);
        System.out.println("average is : "+avg);

        //numbers starting with 2
         long count2 = list.
                 stream().
                 map(i -> String.valueOf(i)).
                 filter(s -> s.startsWith("2")).
                 count();
        System.out.println("numbers starting with 2:"+ count2);

        //duplicates in list

        //using set
        Set<Integer> set = new HashSet<>();
        List duplicates = list.stream().filter(i -> !set.add(i)).collect(Collectors.toList());
        System.out.println(duplicates);

        //using internal method
        duplicates =list.stream().
                filter( i-> list.indexOf(i) != list.lastIndexOf(i)).
                distinct(). //to give unique duplicates
                collect(Collectors.toList());
        System.out.println(duplicates);

        //Collections.frequency()
        duplicates = list.
                     stream().
                     filter(i -> Collections.frequency(list,i)>1).
                     distinct().
                     collect(Collectors.toList());
        System.out.println(duplicates);

        // making a map and getting value

        duplicates =list.stream().
                collect(Collectors.groupingBy(i -> i, Collectors.counting())).
                entrySet().
                stream().
                filter(e -> e.getValue()>1).
                map(entry -> entry.getKey()).
                distinct().
                collect(Collectors.toList());

        System.out.println(duplicates);


        //min and max in a list

        int min =0;
        int max =0;

        //using comparable
        list.sort(Comparator.comparing(Integer::intValue).reversed());
        max = list.get(0);

        list.sort(Integer::compareTo);
        min = list.get(0);
        System.out.println(max+" "+min);

        //summary statistics
       IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(Integer::intValue));
       max = summaryStatistics.getMax();
       min = summaryStatistics.getMin();
       avg =summaryStatistics.getAverage();
       long s = summaryStatistics.getSum();
       long c =summaryStatistics.getCount();
        System.out.println(summaryStatistics);

        //using reduce
        BinaryOperator<Integer> integerBinaryOperator = (a,b) ->{
            if(a > b) return a;
            else if(a < b) return b;
            else return a;
        } ;

        //the above can be wriiten as
        integerBinaryOperator = (a, b) -> Integer.compare(a, b) >= 0 ? a : b;
        min =list.stream().reduce(-1,integerBinaryOperator);
        System.out.println(min);








    }
}
