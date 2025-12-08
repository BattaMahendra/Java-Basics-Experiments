package collections.generics;

import java.util.ArrayList;
import java.util.List;

public class Generic<B> {
    public B getaField() {
        return aField;
    }

    public void setaField(B aField) {
        this.aField = aField;
    }

    B aField;



    //public static B b;  // Generics are not possible with static variables

    /*Because the above static will be shared by all objects of class
    * What if in future we crate Objects like following
    *
    * Generic<Car> car = new Generic<>();
    * Generic<Bike> bike = new Generic<>();
    * Generic<SmartPhone> mobile = new Generic<>();
    *
    * Now what will be condition of static field B b; Static has to same for all objects,
    * but now it is different for each object.
    * */

    /*
    * not only K,V,E,N,T  we can use any combination of Alphabets as generics*/
    public <MAHENDRA> MAHENDRA printAndRetrun(MAHENDRA b){
        System.out.println(b);


        return b;
    }

    public static void get(){
        List<? extends  Number> l = new ArrayList<>();

        Number n = 4;
        Integer i = new Integer(7);
        Double k = new Double(8.0);


    }

    /*They can have constructors like following*/

    public Generic(B b){
        this.aField = b;
        // B b1 = new B();        // compilation error
    }

    // no args constructor
    public Generic(){

    }

    /*
    * But we can't instantiate the Type parameter itself : B b = new B(); ==> not possible */

}

/**
 *  Generics were introduced to avoid run time exceptions caused due to typecasting errors.
 *
 *  Generics are the symbols <> + Object type in <>
 *  they enforce type safety while writing the code
 *  Generics are a compile-time feature - They help you write safer code, but disappear at runtime. They don't
 *  matter for JVM. For eg: if we have two variables of list
 *      List<String> StringList = new ArrayList<>(); // compiled as List stringList = new ArrayList();
 *      List<Integer> integerList = new ArrayList<>(); // compiled as List integerList = new ArrayList();
 *
 *      Which means at run time JVM removes all generics. you can check that for yourself with following code
 *      System.out.println(stringList.getClass().getName() == integerList.getClass().getName()); // prints true
 *
 *     The above process is called type erasure ( which means the generic type is erased at runtime by JVM)
 *     It only exists at compile time to help you write better code. Once code compiles , types are erased
 *
 *     Because of type erasure
 *          1. We can't have static data members of Generic i.e private static T t; (not possible)
 *          2. We can't create generic exceptions ( because at run time , the type is erased)
 *
 *   Limitations:
 *
 *   Lets suppose A generic class  G<B> and a non generic class NonGeneric(NG)
 *    1. G<B> can extend NG
 *    2. Generic class can extend other generic class only if they have same param
 *        i.e, class genericSubClass<T, V> extends GenericSuperClass<T>
 *    3. NGC can not extend GC
 *    4. NGC can extend if GC<NGC>
 *
 *
 *   In above class we cant create B b = new B(); it is not allowed
 *
 *
 *
 *  */

/**
 *
 * Common interview-style questions / exercises

 Explain type erasure — what gets erased and what the runtime sees.

 Why is List<Integer> not a subtype of List<Number>?
    Ans
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = intList;  // Suppose this was allowed

        numList.add(3.14); // double is a Number, so allowed!

        // But now intList contains a Double, not an Integer! ❌ Type safety broken
        Integer x = intList.get(0); // ClassCastException at runtime


 Explain and give examples of ? extends T and ? super T.

 Why can't you create new T[]?

 What are raw types and why are they dangerous?

 Demonstrate a generic method that swaps elements in an array.

 Explain why you cannot create a generic exception class MyException<T> extends Exception.

        📝 Interview-Ready Answer

        1. You cannot create a generic exception class (MyException<T> extends Exception) because:
        2. type erasure removes generic type info at runtime.
        3. The JVM would not be able to distinguish between MyException<String> and MyException<Integer> in a catch block.
                MyException<String> and MyException<Integer> would both just be MyException at runtime.
        4. This breaks compile-time type checking of exceptions, so Java forbids it.

 Show how to implement a toArray(Class<T> clazz) to get a T[].
 */
