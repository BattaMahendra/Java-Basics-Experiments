package collections.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClass {

    /*
    * please refer this article for deeper understanding :  https://www.scaler.com/topics/java/generics-in-java/
    * */



    public static void main(String[] args) {
        Generic<String> object = new Generic<>();
        object.aField = "Batta Mahendra";
        object.printAndRetrun(1);

        // Understanding generics using methods

        List<String> stringList = new ArrayList<>(List.of("one","two","three"));
        List<Integer> integerListList = new ArrayList<>(List.of(1,2,3));

        //using wildcard ?
        printUsingGeneric(stringList);

        //using generic T
        printUsingGenericT(stringList);
        printUsingGenericT(integerListList);

        //using restricted generic T extends String
        //printUsingGenericT_specific(integerListList);   //compile time error as T extends String --> only String types are allowed

        //very important --> using Object
         //printUsingObject(stringList);   // compile time error --> as it accepts only List<Object> and not List<String>

      // using raw list
        print(stringList);

        // Generics can't be used with primitives like int, float, double etc..
        // instead use wrappers like Integer, Float, Double
        // why ? -> generics are designed to work with Objects. And primitives like int, float are not objects.
        // Remember as primitives exist in Java and i.e. why java is not pure object-oriented language.

        //List<int> intLIst; // compile time error as int is not an object.
        List<Integer> intList; // allowed as Integer is object.

    }

    public static <T> T[] toArray(List<T> list, Class<T> clazz) {
        // Use reflection to create an array of runtime type 'clazz'
//        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, list.size());
        return list.toArray(array);
    }

//we can restrict incoming parameter using List<? extends String> or any other class
    private static void printUsingGeneric(List<?> list) {
        System.out.println("Printing using Generics ? ");
        System.out.println(list);
//        list.add("hello");        //results in compile time error
    }


    private static <T>  void printUsingGenericT(List<T> list) {
        System.out.println("Printing using Generics T ");
        System.out.println(list);
        // list.add("hello");        //results in compile time error
    }

    /*
     * Here unlike wild card ? , we can force T to be specific type
     * Now T means either it should be a string or its subclass*/
    private static <T extends String>  void printUsingGenericT_specific(List<T> list) {
        System.out.println("Printing using Generics T  extends String");
        System.out.println(list);
        // list.add("hello");        //results in compile time error
    }

    private static void printUsingObject(List<Object> list) {
        System.out.println("Printing using Object");
        System.out.println(list);
        list.add("String");    //accepts anything
    }

    private static void print(List list) {
        System.out.println("Printing using");
        System.out.println(list);
        list.add("String");    //accepts anything
    }

    // ? VS Object in java








}
