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
    public <B> B printAndRetrun(B b){
        System.out.println(b);


        return b;
    }

}

/**
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
 *
 *
 *  */

/**
 *
 * Common interview-style questions / exercises

 Explain type erasure — what gets erased and what the runtime sees.

 Why is List<Integer> not a subtype of List<Number>?

 Explain and give examples of ? extends T and ? super T.

 Why can't you create new T[]?

 What are raw types and why are they dangerous?

 Demonstrate a generic method that swaps elements in an array.

 Explain why you cannot create a generic exception class MyException<T> extends Exception.

 Show how to implement a toArray(Class<T> clazz) to get a T[].
 */
