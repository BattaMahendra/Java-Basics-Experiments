package java8.Java_Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics {


    public static void intermediateOperations(){
        System.out.println("\n=============================================================\n");
        IntStream.range(0,10)
                .filter( i -> {
                        System.out.println("filter method was called: "+i);
                        return i%2 == 0; })
                 .map(i -> {
                            System.out.println("map method was called: "+i);
                            return i+2; })
                //an intermediate operation used for debugging and logging in streams.
                //It accepts as Consumer functional interface as input and return the original stream to next operatiosn.
                //no changes are applied to original stream.
                .peek(c -> {
                    //here even though we change the value of c , after peek() completion original stream wil be returned
                        c = c+100;
                        System.out.println("we are in peek method"+c);
                    })
                .sorted()
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
    }


    /*Creating streams
    * */

    public static void main(String[] args) {

        creationOfStreams();
        intermediateOperations();

    }
}
