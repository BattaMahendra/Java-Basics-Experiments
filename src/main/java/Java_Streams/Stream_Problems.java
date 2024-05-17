package Java_Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream_Problems {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,1,1,7,8,9,5,2,36,4,78,222,24,9);

        sumOfNumbersInTheList(list);

        averageOfNumbersInTheList(list);

        numbersStartingWith2(list);

        duplicatesInList(list);

       Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).orElse(-1);

       Integer min = list.stream().min((i,j)-> i-j).orElse(-1);

        System.out.println("Max and min values in list: "+max+" "+ min);


    }

    private static void duplicatesInList(List<Integer> list) {

        //method -1: using HashSet
        List<Integer> duplicateIntegers;
        Set<Integer> set = new HashSet<>();
        duplicateIntegers =list.stream()
                               .filter(i -> !set.add(i)) //set.add() method returns false if the element already exists.
                               .distinct()
                               .collect(Collectors.toList());
        System.out.println("Duplicates using set : "+duplicateIntegers);

        //method-2: using Collections.frequency
        duplicateIntegers =list.stream()
                               .filter(i -> Collections.frequency(list,i)>1)
                               .distinct()
                               .collect(Collectors.toList());
        System.out.println("Duplicates using frequency method : "+duplicateIntegers);

        //method-3: using Collectors.counting()
        duplicateIntegers =list.stream()
                               .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                .entrySet()
                                .stream().filter(entry -> entry.getValue()>1)
                                .map(entry -> entry.getKey())
                                .distinct()
                                .collect(Collectors.toList());
        System.out.println("Duplicates using counting method : "+duplicateIntegers);
    }

    private static void numbersStartingWith2(List<Integer> list) {
        List<Integer> numbersStartingWith2 = list.stream()
                .map(i ->
                     String.valueOf(i)
                ).filter(s -> s.startsWith("2")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
        System.out.println("List of integers starting with 2 :"+numbersStartingWith2);
    }

    private static void averageOfNumbersInTheList(List<Integer> list) {
        OptionalDouble average = list.stream().mapToInt(i -> i).average();
        System.out.println("Average of numbers in the list:"+ list +" is  "+average);

        //square & filter and find avarage

        Double average2 = list.stream()
                                        .map(i -> i*i)
                                        .filter(i -> i>100).mapToInt(i -> i)
                                        .average().orElse(0);
        System.out.println("Average of numbers in the list:"+ list +" is  "+average2);
    }

    private static void sumOfNumbersInTheList(List<Integer> list) {
        //to find the sum of numbers-->we can do that in 2 ways
        //  int sum = list.stream().reduce(0,(totalSum, element)-> totalSum + element);
        int sum = list.stream().reduce(0,Integer::sum);
        System.out.println("Sum of numbers in the list:"+list+" is  "+sum);
    }
}
