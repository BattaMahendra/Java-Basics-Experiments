package java8.Java_Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Stream_Problems {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,1,1,1,1,7,8,9,5,2,36,4,78,222,24,9);

        sumOfNumbersInTheList(list);

        averageOfNumbersInTheList(list);

        numbersStartingWith2(list);

        duplicatesInList(list);

       Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).orElse(-1);

       Integer min = list.stream().min((i,j)->  i-j).orElse(-1);

        System.out.println("Max and min values in list: "+max+" "+ min);

        //Consider a array containing 0's and 1's and now move all 1's to right and zeros to left using java 8
        Integer[] arr = {1,0,0,1,0,1,1,0,0};
        List<Integer> arrayList = Arrays.asList(arr);
        //using sort technique
        arrayList.sort(Comparator.reverseOrder());
        System.out.println(arrayList);

        /**
         * Separate odd and even numbers in a list of integers.
         *
         * Given a list of integers, write a Java 8 program to separate
         * the odd and even numbers into two separate lists.
         */
        seperateEvenOddIntoMap(list);

        // separate them in the given list itself
        seperateEvenOddInSameList(list);

        /**
         * Find the frequency of each character in a string using Java 8 streams
         *
         * Write a Java 8 program to find the frequency of each character in
         * a given string using the stream API and collectors.
         */
        characterFrequency();

    }

    private static void characterFrequency() {
        String name = "rohitroh";
        System.out.println("\nEach characters count in word: "+name);
        Map<String, Long> characterFrequency = Arrays.stream(name.split(""))
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(characterFrequency);


        Map<Character, Long> collected = name.chars()
                .mapToObj(ch -> (char) ch)
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(collected);

        Map<String, Integer> countCharacter = Arrays.stream(name.split(""))
                .collect(groupingBy(Function.identity(),
                        collectingAndThen(counting(), Long::intValue)));
        System.out.println(countCharacter);
    }


    private static void seperateEvenOddInSameList(List<Integer> list) {
        Collections.sort(list, (a, b) -> {
           if (a % 2 != 0 && b % 2 == 0) {
               return -1; // a is odd and b is even, so a should come before b
           } else if (a % 2 == 0 && b % 2 != 0) {
               return 1; // a is even and b is odd, so b should come before a
           } else {
               return 0; // both are either odd or even, maintain their relative order
           }
       });
        System.out.println("\nAfter seperating even odd in same list \n"+ list);
    }

    private static void seperateEvenOddIntoMap(List<Integer> list) {
        System.out.println("\n=============separating even and odd numbers into a map======== ");
        System.out.println("\nusing Collectors.partitioningBy ");
        Map<Boolean , List<Integer> > oddEvenMap =
                list.stream()
                        .collect(Collectors.partitioningBy(i -> i %2 == 0));
        oddEvenMap.entrySet().forEach( entry -> {
            System.out.println("\n==== "+entry.getKey()+" ==========");
            entry.getValue().forEach(i -> System.out.print(i+" "));
        });

        System.out.println("\nusing Collectors.groupingBy ");
        Map<String , List<Integer> > oddEvenMap2 =
                list.stream()
                        .collect(groupingBy(
                                i -> i%2 == 0 ? "even": "odd"
                        ));
        oddEvenMap2.entrySet().forEach( entry -> {
            System.out.println("\n==== "+entry.getKey()+" ==========");
            entry.getValue().forEach(i -> System.out.print(i+" "));
        });
    }

    private static void duplicatesInList(List<Integer> list) {

        //method -1: using HashSet
        List<Integer> duplicateIntegers;
        Set<Integer> set = new HashSet<>();
        duplicateIntegers =list.stream()
                               .filter(i -> !set.add(i)) //set.add() method returns false if the element already exists.
                               .distinct()
                               .collect(toList());
        System.out.println("Duplicates using set : "+duplicateIntegers);

        //method-2: using Collections.frequency
        duplicateIntegers =list.stream()
                               .filter(i -> Collections.frequency(list,i)>1)
                               .distinct()
                               .collect(toList());
        System.out.println("Duplicates using frequency method : "+duplicateIntegers);

        //method-3: using Collectors.counting()
        duplicateIntegers =list.stream()
                               .collect(groupingBy(Function.identity(), counting()))
                                .entrySet()
                                .stream().filter(entry -> entry.getValue()>1)
                                .map(entry -> entry.getKey())
                                .distinct()
                                .collect(toList());
        System.out.println("Duplicates using counting method : "+duplicateIntegers);


        List<Integer> uniqueElement = list
                .stream()
                .filter(number -> list.indexOf(number)
                        != list.lastIndexOf(number))
                .distinct()
                .collect(toList());
        System.out.println("Duplicates using indexOf method : "+uniqueElement);
    }

    private static void numbersStartingWith2(List<Integer> list) {
        List<Integer> numbersStartingWith2 = list.stream()
                .map(i ->
                     String.valueOf(i)
                ).filter(s -> s.startsWith("2")).map(i -> Integer.parseInt(i)).collect(toList());
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
        //to find the sum of numbers-->we can do that in 3 ways
        //  int sum = list.stream().reduce(0,(totalSum, element)-> totalSum + element);
        //int sum = list.stream().mapToInt(i -> i).sum();
        int sum = list.stream().reduce(0,Integer::sum);

        System.out.println("Sum of numbers in the list:"+list+" is  "+sum);
    }
}
