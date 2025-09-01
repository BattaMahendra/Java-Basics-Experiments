package java8.Java_Streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntStream - refers to streaming of primitive values of int
 *
 * Generally Streams only process objects i.e Stream<int> is not possible , only Stream<Integer> is only possible
 *  as generics allow only objects. Primitives are not objects (in fact i.e. why java is not pure object-oriented language)
 *
* */
public class IntStreamExample {

    public static void main(String[] args) {


        creationOfIntStreams();

        commonFunctions();


    }

    private static void commonFunctions() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 1. forEach
        System.out.println("1. forEach:");
        IntStream.of(numbers).forEach(System.out::println);
        //if you want to define for loops
        IntStream.range(0,10).forEach(i -> System.out.println(i));

        // 2. sum
        System.out.println("\n2. sum:");
        int sum = IntStream.of(numbers).sum();
        System.out.println("Sum: " + sum);

        // 3. average
        System.out.println("\n3. average:");
        OptionalDouble average = IntStream.of(numbers).average();
        System.out.println("Average: " + average.orElse(0.0));

        // 4. min
        System.out.println("\n4. min:");
        OptionalInt min = IntStream.of(numbers).min();
        System.out.println("Min: " + min.orElse(0));

        // 5. max
        System.out.println("\n5. max:");
        OptionalInt max = IntStream.of(numbers).max();
        System.out.println("Max: " + max.orElse(0));

        // 6. count
        System.out.println("\n6. count:");
        long count = IntStream.of(numbers).count();
        System.out.println("Count: " + count);

        // 7. summaryStatistics
        System.out.println("\n7. summaryStatistics:");
        IntSummaryStatistics stats = IntStream.of(numbers)
                .summaryStatistics();
        System.out.println("Stats: " + stats);

        // 8. filter and collect
        System.out.println("\n8. filter and collect:");
        int[] evenNumbers = IntStream.of(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
        System.out.print("Even Numbers: ");
        IntStream.of(evenNumbers).forEach(System.out::print);

        // 9. map and sum
        System.out.println("\n\n9. map and sum:");
        int squaredSum = IntStream.of(numbers)
                .map(n -> n * n)
                .sum();
        System.out.println("Sum of Squares: " + squaredSum);

        // 10. reduce()
        System.out.println("\n\n10. reduce function ");
        int sum2 = IntStream.of(numbers)
                .reduce(0, (a,b)-> a+b);
        // .reduce(0, Integer::sum); // The above can also be written as this
    }

    private static void creationOfIntStreams() {
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6,7,8,9); //stream of integers

        // converting them into intstreams
        IntStream intStream = integerStream.mapToInt(i -> i);

        //for example if we have a list of Integers
        List<Integer> integerList = integerStream.collect(Collectors.toList());
        // we generally use mapToInt(Function) to convert normal stream into intstream
        intStream = integerList
                                .stream()
                                 .mapToInt(Integer::intValue); //return int stream

        // we can also create directly
        IntStream intRange = IntStream.range(1, 5);          // 1, 2, 3, 4
        IntStream intRangeClosed = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5
        IntStream intStream2 = IntStream.of(1, 2, 3, 4, 5); // 1, 2, 3, 4, 5

        /*
        * To convert an intstream back into normal stream we use method boxed()*/
        List<Integer> resultList = intStream
                                            .boxed()  // returns Stream<Integer>
                                            .collect(Collectors.toList());
    }
}
