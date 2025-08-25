package java8.Java_Streams;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        int i = Integer.MAX_VALUE;
        int j = -1;
        System.out.println(i-j);

        List<String> list = new ArrayList<>();
        list.add("Mahendra");
        list.add("Nagendra");
        list.add("Keshava");
        list.add("NagaSudha");
        list.add("Hema");
        list.add("Pavithra");

        list.stream().map(s -> {
            int k = list.indexOf(s);
            list.set(k, list.get(k)+" added");
            return s;
        }).forEach(System.out::println);

        System.out.println(list);
    }
}
