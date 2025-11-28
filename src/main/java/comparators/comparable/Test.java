package comparators.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    static List<Product> products ;
    static {
        products = Arrays.asList(
                new Product(3, "Laptop", 75000.0, 4.5),
                new Product(1, "Phone", 35000.0, 4.7),
                new Product(5, "Tablet", 20000.0, 4.2),
                new Product(2, "Monitor", 15000.0, 4.1),
                new Product(4, "Keyboard", 2000.0, 3.9)
              //  ,null //adding null values to spice up things
              //  null  //To deal with nulls → prefer Comparator.nullsFirst / nullsLast.
        );
    }
    public static void main(String[] args) {

        /*
        * Let's suppose if we use sort() method on the Product list then default sort is applied
        * which we defined in Product class compareTo method*/
        System.out.println("\nProducts before sorting\n");
        products.forEach(System.out::println);

        //Let's sort
        Collections.sort(products);
        System.out.println("\nAfter sorting by sort() method\n");
        products.forEach(System.out::println);


    }
}
