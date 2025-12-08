package collections.generics;

import java.util.ArrayList;
import java.util.List;

/*
* PECS rule
* Producer extends --> should be used for read mode , you can't write items
* Consumer super  --> only for write mode , you can not read items
* */
class Fruit {}
class Apple extends Fruit {}
class Orange extends Fruit {}

/*
* Every Apple is a Fruit
* Every Orange is a Fruit
* Every Fruit is an Object */
public class PECS {
    // Producer -> should be used for reading mode
    static void printFruits(List<? extends Fruit> basket) {
        for (Fruit f : basket) {
            System.out.println(f);
        }
        // basket.add(new Apple()); //❌ Not allowed
        /*
        * Why above line not allowed ?
        * Because compiler doesn't know at the moment whether incoming list is List<Orange> or List<Apple>
        * What if at run time List is List<Orange> , then it would break at runtime
        * */
    }

    // Consumer - super ==> should be used for writing mode
    static void addApples(List<? super Apple> basket) {
        basket.add(new Apple()); // ✅ Safe
        // basket.add(new Fruit()); // ❌ Not allowed
        /*
        * Why not allowed ?
        * as we can see List param is super Apple , which means Apple and its super classes but not subclasses of apple
        * here List can be either List<Apple> , List<Fruit> and List<Object>
        *  now in above line what if the List was of type List<Apple>
        *  new Apple() will always allowed as in above line because of rule it should be Apple or its supertypes
        *  where Apple would fit in all cases
        */
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();

        printFruits(apples);   // ✅ producer
        addApples(fruits);     // ✅ consumer
    }
}
