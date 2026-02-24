package string.String_Props;

import java.util.stream.IntStream;

/**
 * When to use what?
 *
 *      Use String        → When data won’t change often. (Eg: Fixed data, constants, security-sensitive)
 *      Use StringBuilder → When data changes frequently in single-threaded context.(Eg: Single-threaded modifications)
 *      Use StringBuffer  → When data changes frequently in multithreaded context.(Eg: Multi-threaded modifications)
 *      */

public class string_VS_Builder_VS_Buffer {

    public static void main(String[] args) {


        /*
        * String

                Immutable → Once created, cannot be changed.
                Every modification (like concatenation, substring, replace) creates a new String object.
                Thread-safe because it’s immutable.
                Stored in String Pool (if created using literals).
                *
                * Cons

                    Performance: Slower in repeated modifications (because new objects are created).
                * */

        String s = "Mahendra";
        for(int i =0; i <10; i++){
            s= s+i; // every time creates new object as string is immutable
            System.out.println(s +" and hashcode is "+s.hashCode() +" and memory location is : "+System.identityHashCode(s));
        }


        System.out.println("\n\n");
/*
*
* StringBuilder

     ==> Mutable → Content can be modified without creating new objects.
     ==> Performance: Faster than String and StringBuffer for single-threaded operations.
     ==> Introduced in Java 5 as a faster alternative to StringBuffer.
     *
     * cons : ==> Not synchronized → Not thread-safe.
     *
     * 🧠 Mental Rule (One Line)
     * ✅️ If you’re modifying strings repeatedly → use StringBuilder.
     * ☝️ If not → use String.
*
* */
        //StringBuilder
        StringBuilder sb = new StringBuilder("Mahendra");
        for(int i=0; i<10; i++){
            sb.append(i); //appends the value to same object
            System.out.println(sb +" and hashcode is "+sb.hashCode()+" and memory location is : "+System.identityHashCode(sb));
        }

        /*
        *
        * StringBuffer

            ==> Mutable like StringBuilder.
            ==> Synchronized → Thread-safe (methods are synchronized).
            ==> Best when multiple threads are modifying the same string object.
            *
            * Cons
            *
            *  ==> Performance: Slower than StringBuilder because of synchronization overhead.
            * */
    }
}
