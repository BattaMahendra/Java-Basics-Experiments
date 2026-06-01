package java8.Java_Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics {


    public static void intermediateOperations(){
        System.out.println("\n=============================================================\n");
        IntStream.range(0,10)
                .filter( i -> {
                        System.out.println("filter  "+i);
                        return i%2 == 0; })
                 .map(i -> {
                            System.out.println("map method was called: "+i);
                            return i; })
                //an intermediate operation used for debugging and logging in streams.
                //It accepts as Consumer functional interface as input and return the original stream to next operations.
                //no changes are applied to original stream.
                .peek(c -> {
                    //here even though we change the value of c , after peek() completion original stream wil be returned
                        c = c+100;
                        System.out.println(" peek "+c);
                    })
                .sorted()
                .distinct()
                .skip(2)
                .limit(10)
                .mapToObj(i -> "Value: " + i)
                .peek(s -> System.out.println("Processing string: " + s))
                .sorted(Comparator.reverseOrder())
                .dropWhile(s -> s.contains("9"))
                .takeWhile(s -> !s.isEmpty())

                .forEach(System.out::println);


    }
    public static void creationOfStreams(){

        //Empty streams
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Count of elements in empty stream: "+emptyStream.count());
        System.out.println("\n=============================================================\n");

        //Arrays & Streams
        int[] existingArray = {1,2,3,4,5,6};
        int[] evenNumbers = Arrays.stream(existingArray).filter(i -> i%2 ==0).toArray();
        System.out.println(Arrays.toString(evenNumbers));
        System.out.println("\n=============================================================\n");

        // Creating a manual stream
        Stream.of(1,2,3,4,5,6,7,8,9).filter(i -> i%2 != 0).toArray();

        //combined streams
        Stream<Integer> evenIntegerStream =  Stream.of(0,2,4);
        Stream<Integer> oddIntegerStream =  Stream.of(1,3,5);
        Stream<Integer> numbers = Stream.concat(evenIntegerStream,oddIntegerStream);
        System.out.println(numbers);

        System.out.println("\n========================== Stream.iterate() =======================================\n");

        /**
         * Important - infinite streams
         * Stream.iterate(T seed, UnaryOperator<T> f)
         *
         * 1. Lazy Evaluation: Elements are generated only when requested by a terminal operation (like forEach, collect, limit, etc.).
         * 2. Infinite Streams: The single-argument iterate method creates infinite streams,
         *       requiring a limit or other short-circuiting operation to prevent an OutOfMemoryError.
         * */
        // generates infinite even numbers starting from 0
        Stream<Integer> evenStream = Stream.iterate(0, i -> i+2);

        // seed --> starting point
        // Unary operator -> stream generator

        /*
        * But above is only stream and is lazily evaluated. i.e unless followed by a terminal operation there
        * are no results */

        //observe here
        //evenStream.map(i -> i+3); //Still doesn't come to reality as there is no terminal operation

        // when we give terminal operation -- so iterate() function is lazily evaluated
        evenStream.limit(5).forEach(System.out::print);

        /**
         * Finite streams
         *
         * Stream.iterate(T seed, Predicate<T> hasNext, UnaryOperator<T> next):
         * This overload creates a finite stream that terminates based on a predicate.
         *
         * seed: The initial element.
         * hasNext: A Predicate that determines when the stream should terminate. The stream continues as long as this predicate returns true.
         * next: A UnaryOperator function to generate the next element.
         * */
        // Generate a stream of numbers from 0 to 9
        Stream<Integer> numbersStream = Stream.iterate(0, n -> n < 10, n -> n + 1);

        // Print all numbers in the stream
        numbersStream.forEach(System.out::println); // Generate a stream of numbers from 0 to 9

        // Stream can only be used once and can't be used once its been consumed.
       // numbersStream.forEach(System.out::println);  // Throws exception

        //Generate a stream of random doubles
        Stream<Double> random = Stream.generate(Math::random);
       // Use more Stream.generate examples here...
        Stream<String> uuidStream = Stream.generate(() -> java.util.UUID.randomUUID().toString());
        Stream<Integer> constantStream = Stream.generate(() -> 1);



        // terminal operation on stream to print all ramdoms
        random.limit(10).forEach(System.out::println);


        List list = List.of(1,2,3,4);
        // Mechanism to reuse streams - best way
        Supplier<Stream<Integer>> supplier =
                () -> list.stream().filter(i -> (int)i > 0);

        supplier.get().forEach(System.out::println);  // fresh stream
        supplier.get().count();                      // Considered as fresh stream




    }



    /*Creating streams
    * */

    public static void main(String[] args) {

        creationOfStreams();
        intermediateOperations();
        lazyEvaluationOfStreams();
        shortCircuitingOperations();
        terminalOperations();
    }

    private static void terminalOperations() {
        System.out.println("\n=========================== TERMINAL OPERATIONS ==================================\n");
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");

        // 1. forEach() - Performs an action for each element
        System.out.println("forEach:");
        fruits.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 2. collect() - Transforms stream into a different form (List, Set, Map)
        List<String> upperFruits = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("collect (List): " + upperFruits);

        // 3. reduce() - Combines elements into a single result
        String combined = fruits.stream()
                .reduce("", (partialString, element) -> partialString + "-" + element);
        System.out.println("reduce (concatenation): " + combined);

        // 4. count() - Returns the number of elements
        long count = fruits.stream().filter(f -> f.length() > 5).count();
        System.out.println("count (length > 5): " + count);

        // 5. min() and max() - Returns the minimum or maximum element based on a comparator
        fruits.stream()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(s -> System.out.println("max (longest string): " + s));

        // 6. toArray() - Converts stream to an array
        String[] fruitArray = fruits.stream()
                .filter(s -> s.startsWith("A"))
                .toArray(String[]::new);
        System.out.println("toArray: " + Arrays.toString(fruitArray));

        // 7. SummaryStatistics - Useful for numeric streams
        java.util.IntSummaryStatistics stats = fruits.stream()
                .mapToInt(String::length)
                .summaryStatistics();
        System.out.println("Summary Statistics: " + stats);



    }

    private static void shortCircuitingOperations() {
        System.out.println("\n=========================== SHORT CIRCUITING ==================================\n");
        List<String> names = Arrays.asList("Mahendra", "Manju", "Uday", "Sabari", "Ranga");

        // findFirst() - returns the first element and stops processing
        String first = names.stream()
                .filter(s -> s.startsWith("M"))
                .peek(s -> System.out.println("Processing: " + s))
                .findFirst()
                .orElse("None");
        System.out.println("Result findFirst: " + first);

        // findAny() - returns any element from the stream, useful in parallel streams
        String any = names.stream()
                .filter(s -> s.contains("a"))
                .findAny()
                .orElse("None");
        System.out.println("Result findAny: " + any);

        // anyMatch() - returns true as soon as one element matches the predicate
        boolean match = names.stream()
                .peek(s -> System.out.println("Checking match: " + s))
                .anyMatch(s -> s.length() < 5);
        System.out.println("Result anyMatch: " + match);

        // allMatch() - returns false as soon as one element fails the predicate
        boolean allMatch = names.stream()
                .peek(s -> System.out.println("Checking allMatch: " + s))
                .allMatch(s -> s.length() > 3);
        System.out.println("Result allMatch: " + allMatch);

        // noneMatch() - returns false as soon as one element matches the predicate
        boolean noneMatch = names.stream()
                .peek(s -> System.out.println("Checking noneMatch: " + s))
                .noneMatch(s -> s.equals("Zebra"));
        System.out.println("Result noneMatch: " + noneMatch);

        // limit() - short-circuits by truncating the stream to a fixed size
        System.out.println("Limit operation:");
        names.stream()
                .peek(s -> System.out.println("Processing for limit: " + s))
                .limit(2)
                .forEach(System.out::println);



    }

    /**
     * Streams are lazy - intermediate operations are lazy which means they are only called when there
     * is a terminal operation
     * */

    private static void lazyEvaluationOfStreams() {
        System.out.println("\n=========================== LAZY EVALUATION ==================================\n");
        //observe this
        // Here the print statements will not get printed as there is no terminal operation
        Stream<Integer> integerStream = IntStream.range(0,10).
                filter(i -> {    // filtering out integers greater than -1
                        System.out.println("filter -> "+i);
                        return i>-1;
                          }).
                mapToObj(e -> {   // converting int to Integer
                        System.out.println("map -> "+e);
                        return Integer.valueOf(e);
                    });

        //observe this --> count is a terminal operation
        // now you can observe the intermediate operations are executed
        long count = integerStream.count();
    }
}
