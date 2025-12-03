package collections;

import java.util.*;

/**
 * 🌍 Why was there a need for Collections (its arrival)?
 *
 * Before Java 2 (JDK 1.2), developers used:
 * 1. Arrays → Fixed size, no built-in methods for operations like sorting, searching.
 * 2. Legacy classes → Vector, Hashtable, Stack, Properties.
 *      These existed, but had inconsistent APIs and limited flexibility.
 *
 * */
public class CollectionDemo {
    /*
    Array is a linear data structure that is a collection of similar data types.
     Arrays are stored in contiguous memory locations.
      It is a static data structure with a fixed size.
      It combines data of similar types.
    Pros:
    efficient memory management
    faster retrieval

    cons:
    fixed size
    insertion and deletion issues
    less flexibility

     */

    public static void main(String[] args) {
        collectionCompatabilityWithDifferentObjects();
    }

    static int count =0;
    private static void collectionCompatabilityWithDifferentObjects() {
    /*
    collection is a main interface in java which has some common methods
    which are all useful across all collection implemented classes and interfaces
     */
        Collection c = new ArrayList();
        //adding different types of data types into collection class
        c.add("I am a String");
        c.add(1);
        c.add('K');
        c.add(new Object());
        c.add(new ArrayList<>());

        System.out.println(c);

        //experimenting on collections
        //java will throw a concurrent modification exception if modify collection while iterating
        c.forEach(object -> {
//            if(count == 0)
//            c.add("modification "+ count++);    //modifying the collection inside its own iteration
        });

        System.out.println("Using iterator");
        Iterator iterator = c.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            //modifying the collection
            iterator.remove();                 // JVM doesn't throw concurrent modification exception
            }                                  // if modification is done using iterator


        /**
         * Difference between Collection and Collections
         *
         * 1. Collection - An interface which is implemented by other interfaces List, Set, Queue
         * 2. Collections - An utility class which have some static utility methods for manipulating collections
         * */

        ArrayList<String> list = new ArrayList<>();
        list.add("Uday");
        list.add("Mahi");
        list.add("Sabari");
        list.add("Ranga");


        System.out.println();
        list.forEach(System.out::print);

        Collections.sort(list);
        System.out.println();
        list.forEach(System.out::print);

        /*
        * One of main difference between collections
        * Type Safety at compile time
        * Generics can enforce type safety at compile time itself
        *
        * Observe below*/

        String[] i = new String[5];
        Object[] o = i;   // compiles successfully
        //o[0] = 1;         // run time error - leading to bugs

        // Collections can work with Generics
        List<String> l = new ArrayList<>();
        //List<Object> lO = l;   // compile time error itself
        System.out.println("\n\n====================");

        /**
         * TRICKY
         * */

        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(1);
        collection.add(null);
        collection.add(null);
        collection.add(null);

        System.out.println(collection.size());
        System.out.println(collection);


    }
}
