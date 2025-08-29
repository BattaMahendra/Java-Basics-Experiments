package java8.Java_Streams.Revising;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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




    }
}
