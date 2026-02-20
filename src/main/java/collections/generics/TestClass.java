package collections.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    /*
    * please refer this article for deeper understanding :  https://www.scaler.com/topics/java/generics-in-java/
    * */

    // a generic static method - just as any other generic method

    public static <X> void perform(X x ){
        System.out.println(x);
        // some logic
    }



    public static void main(String[] args) {

        perform(5);
        perform("Hello");
        perform(new Object());

        Generic<String> object = new Generic<>();
        object.aField = "Batta Mahendra";
        object.printAndRetrun(1);

        // Understanding generics using methods

        List<String> stringList = new ArrayList<>(List.of("one","two","three"));
        List<Integer> integerListList = new ArrayList<>(List.of(1,2,3));

        //using wildcard ?
        printUsingGeneric(stringList);
        /*Why do we need wild cards ?
        * Observe below*/

        List<Number> numbers = List.of(1,2,3,4,5,6,7,8,9);
        //let's suppose we have a method which accepts list of Numbers and prints them
        printNumberList(numbers);


        //now let's have another list of integers
        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9);
        //the method won't accept List<Integer> although Integer is subtype of Number
        //printNumberList(integerList);  //compile time error

        /*
        * To avoid above scenario we can use wild cards where observe below*/

        printNumber(numbers);
        printNumber(integerList); //using wild cards accepts both





        //using generic T
        printUsingGenericT(stringList);
        printUsingGenericT(integerListList);

        //using restricted generic T extends String
      //  printUsingGenericT_specific(integerListList);   //compile time error as T extends String --> only String types are allowed

        //very important --> using Object
        /*
        * Compilation error because Generic enforces types safety
        *
        * i.e we know String extends Object ✅
        * but List<String> extends List<Object> ❌
        *
        * What if in future if you pass integerList and BooleanList*/
//         printUsingObject(stringList);   // compile time error --> as it accepts only List<Object> and not List<String>

      // using raw list
        print(stringList);
       // print(integerList);  // results in runtime error

        // Generics can't be used with primitives like int, float, double etc..
        // instead use wrappers like Integer, Float, Double
        // why ? -> generics are designed to work with Objects. And primitives like int, float are not objects.
        // Remember as primitives exist in Java and i.e. why java is not pure object-oriented language.

        //List<int> intLIst; // compile time error as int is not an object.
        List<Integer> intList; // allowed as Integer is object.

        List s = new ArrayList<String>();
        s.add("");
        s.add(100);  // now compiles very well but later if you try to extract it then run time error.

        String secondItem = (String)s.get(1);
        // the above line leads to class cast exception in run time. and i.e the reason exactly generics are useful. They impose type safety
        //observe below

        List<String> s2 = new ArrayList<>();
        s2.add("");
        //s2.add(100);  // compile time error -- which means safety check at compile time itself.



        List<?> l = new ArrayList<Integer>();
       // l.add(1);   // compile time error.
        l.add(null); // allowed

    }
/*
*
* here there are three types
* 1. upper bounded wild cards - List<? extends  Number> --> allows Number and all subtypes of Number
* 2. Lower bounded wild cards - List<? super Number> --> allows Number and its possible parents
* 3. Unbounded wild cards - List<?> --> allows anything of List  */
    public static void printNumber(List<? extends  Number> list){
        list.forEach(System.out::println);
    }
    public static void printNumberList(List<Number> list){
        list.forEach(System.out::println);
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
        // but we can't add elements to the List as we don't know which type is coming
  //      list.add("hello");        //results in compile time error
                                    // because tomorrow what if user passes List<Integer>
                                    // then this rigid adding of "Hello" will break
        list.add(null);  // this is only allowed
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

    /*
    * Here we can't pass List<String>, List<Integer> or anything into the following method.
    * We can only pass List<Object>
    *  ==> in java List<Object> is not parent of List<Integer> or any other list.
    */
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

    /*
    *  Generally in Java List<Object> != List<String> or any thing.
    *  i.e if we have a method signature as --  private static void printUsingObject(List<Object> list)
    *  then we can't pass List<String>, List<Integer> or anything. we can only pass List<Object>
    *
    * Wild-cards
    *
    * suppose we have method  ===> public void print(List<?> list)
    * then this accepts everything like
    * print(new ArrayList<String>()); or print(new ArrayList<Integer>()); or  print(new ArrayList<Double>());
    *
    * */











}
