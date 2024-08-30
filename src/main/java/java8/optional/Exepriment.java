package java8.optional;

import java.util.Optional;

public class Exepriment {

    public static void main(String[] args) {

        /*
        * Comparing same code with Optional.orElse() and Optional.orElseGet()
        * Optional.orElseGet() is more efficient if fallback value computation is costly
        * */

        System.out.println("============ Using orElse()  ==============");

        String value = Optional.ofNullable("Mahendra")
                .orElse(getDefaultValue()); // getDefaultValue() is called even if Optional has a value
        System.out.println(value);

        System.out.println("============ Using orElseGEt()  ==============");

        String value2 = Optional.ofNullable("Mahendra")
                .orElseGet(()->getDefaultValue()); // getDefaultValue() is called even if Optional has a value
        System.out.println(value2);


    }


    static String getDefaultValue() {
        System.out.println("Computing default value even if it is not necessary");
        return "Default";
    }

}
