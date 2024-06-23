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

        minAndMax(list);

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

        //sort the following list

        sortingGivenList(list);

        /**
         * Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
         *
         * Given a list of strings, write a Java 8 program to join the strings
         * with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.
         */

        joinListOfStrings();

        /**
         * Check if two strings are anagrams or not using Java 8 streams
         * Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.
         */
        String first = "listen";
        String second = "silent";

        //using basic hashing approach
        boolean value =  hashingApproachForAnagram(first, second);

        //using java 8
        isAnagramUsingJava8(first, second);

        /**
         * Find the sum of all digits of a number in Java 8
         *
         * Write a Java 8 program to find the sum of all digits of a given number.
         *
         */
        int num = 12345;
        //basic approach
        basicSum(num);
        // Using Java 8 stream to sum up the digits
        int sum = String.valueOf(Math.abs(num)).chars()
                .map(Character::getNumericValue)
                .sum();
        /**
         * Sort a list of strings according to the increasing order of their length
         *
         * Write a Java 8 program to sort a given list of strings according to the increasing order of their length.
         */
        sortByLengthOfStringList();

        /**
         * Find the common elements between two arrays
         *
         * Write a Java 8 program to find the common elements between two arrays using streams.
         */
        String[] words1 = {"hey", "hello", "Hii", "give", "damn", "said"};
        String[] words2 = {"hey", "how", "Hii", "give", "what", "said"};

        //using list internal methods
        List<String> wordList1 = Arrays.asList(words1);
        List<String> wordList2 = Arrays.asList(words2);

        for(String s: wordList1){
            wordList2.contains(s);
        }

        String s = "helohellok";

        //first repeated character in a string
        System.out.println("\nFirst repeated character in given string is "+ firstRepeatedChar(s));

        //first non-repetitive character or first unique character in a string

        usingStringInternalFunctions(s);


    }

    private static void usingStringInternalFunctions(String s) {
        //using string internal methods
        for (char c : s.toCharArray()) {
            if(s.indexOf(c) == s.lastIndexOf(c)){
                System.out.println("The first non repeated  character is "+c);
                break;
            }
        }

    }

    private static Character firstRepeatedChar(String s) {
        Set<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()){
            if(charSet.add(c) != false) return c;
        }
        return null;
    }

    private static void sortByLengthOfStringList() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }


    private static void basicSum(int num) {
        int sum = 0;
        while(num !=0){
            sum = sum + num %10;
            num = num /10;
        }
        System.out.println("\nSum of digits in given number is: "+sum);
    }

    private static void isAnagramUsingJava8(String first, String second) {
        char[] f = first.toCharArray();
        char[] s = second.toCharArray();

        //sorting arrays
        Arrays.sort(f);
        Arrays.sort(s);

        //method 1: comparing arrays
        if( Arrays.equals(f,s)) System.out.println("is anagram");
        else System.out.println("not anagram");

        //method 2: using string
        boolean result = Arrays.toString(f).equals(Arrays.toString(s)) ? true : false;
        System.out.println(result);
    }

    private static boolean hashingApproachForAnagram(String first, String second) {
        int[] hashArray = new int[256];
        if(first.length()!=second.length()) return false;
        //populating the hashArray with first word and second word
        for(int i = 0; i < first.length(); i++) {
            hashArray[first.charAt(i)]++;
            hashArray[second.charAt(i)]--;
        }

        for(int i=0; i< first.length(); i++){
            if( hashArray[first.charAt(i)] != 0 || hashArray[second.charAt(i)] != 0) return false;
        }

        return true;

    }

    private static void minAndMax(List<Integer> list) {
        Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).orElse(Integer.MAX_VALUE);

        //using Integer::compareTo
        Integer max2 = list.stream().max(Integer::compareTo).orElse(Integer.MAX_VALUE);
        Integer min = list.stream().min((i, j)->  i-j).orElse(-1);

        System.out.println("Max and min values in list: "+max+" "+ min);

        System.out.println("\nUsing IntSummaryStatistics");
        IntSummaryStatistics summaryStatistics = list.stream()
                .collect(summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getAverage());
    }

    private static void joinListOfStrings() {
        List<String> languageList = Arrays.asList("java", "c++", "c", "C sharp", "python", "kotlin", "scala");
        String joinWithPrefixSuffixAndDelimiter = languageList
                .stream()
                .collect(joining(",", "[", "]"));
        System.out.println("\nAfter joing the given array list with prefix: [ and suffix: ] and delimiter: , is \n"+joinWithPrefixSuffixAndDelimiter);
    }


    private static void sortingGivenList(List<Integer> list) {
        System.out.println("\nSorting a given list");
        List<Integer> sortedList = list.stream().sorted().collect(toList());
        System.out.println("Using sorted() : "+sortedList);

        sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(toList());
        System.out.println("reverse sorted: "+sortedList);

        sortedList = list.stream().sorted((i, j) -> i - j).collect(toList());
        /*
        * if i-j > 0 then j comes first
        * if i-j == 0 then no change
        * if i-j < 0 then i comes first
        * */
        System.out.println("using customComparator : "+sortedList);
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
