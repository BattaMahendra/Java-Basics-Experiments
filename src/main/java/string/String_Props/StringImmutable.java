package string.String_Props;

public class StringImmutable {

    /**
     * String is not a primitive but rather a class and String class is final
     * */

    public static void main(String[] args) {

        /**
         * When we use double quotes to create a String, it first looks for String with the same value in the String pool,
         * if found it just returns the reference else it creates a new String in the pool and then returns the reference.*/

        String s = "Mahendra"; // from string pool
        String m = "Mahendra"; // from string pool

        /*However using new operator, we force String class to create a new String object in heap space.*/
        String n = new String("Mahendra"); // different memory location created because of new

        System.out.println("identity hash codes of above literals: \ns --> "+ System.identityHashCode(s)
                +" \nm --> "+ System.identityHashCode(m) + " \nn --> "+System.identityHashCode(n));

        /* We can use intern() method to force heap memory to put the new object in pool or take existing object from pool*/

        String o = n.intern();

        System.out.println("====================================");
        System.out.println(s==m); // true because both are from String pool
        System.out.println(s==n); // false as n is new object from heap memory
        System.out.println(s==o); // true as intern() in o forces it to get it from string pool
        System.out.println(o==n); // false as o got its value from pool where as n is still from heap


        System.out.println("==============   HASH CODES  ======================");
        /*
        * But remember hash codes of all objects remain same as object hashcode is calculated from value of string
        * i.e "Mahendra"*/

        System.out.println(s.hashCode());
        System.out.println(m.hashCode());
        System.out.println(n.hashCode());
        System.out.println(o.hashCode());

        System.out.println("====================================");

        //equals() method
        String a = "Hello";
        String b = new String("Hello");
        System.out.println(a == b);       // false (different memory refs)
        System.out.println(a.equals(b));  // true  (same value)

        //modification of literal
        String x = "Mahendra";
        s.toUpperCase();  // "MAHENDRA" created and kept in pool but not assigned to anything
        System.out.println(x); // prints "Mahendra", not "MAHENDRA"
        /*
        * In above example s.toUpperCase() -> "MAHENDRA" is created and stored in string constant pool
        * It is never to be used again but still exists in pool
        * From Java 8 onwards String pool is inside java heap memory and is covered by Garbage collection
        * So eventually jvm removes the unreferenced string objects in pool through garbage collection
        * So that String pool doesn't run out of memory with unwanted and unreferenced string objects in pool */

        //usage of concatenation in loops
        String result = "";
        for(int i=0; i<1000; i++) {
            result += i; // BAD → creates 1000 new string objects (instead use String Builder)
        }

    }
}


/**
 *
 * 3. Why is String Immutable? (Interview Gold ✨)
 *
 * There are multiple reasons:
 *
 * 1. Security
 *
 *              Strings are used in many sensitive areas:
 *              file paths (new File("C:/data/file.txt"))
 *              network connections (Socket("localhost"))
 *              database URLs, usernames, passwords
 *              If strings were mutable, a hacker could change "jdbc:mysql://localhost" to "jdbc:hacked://evil".
 *
 * 2. Caching / String Pool
 *
 *      Java maintains a String Constant Pool (SCP).
 *      If strings were mutable, "abc" could suddenly change to "xyz", breaking all cached references.
 *
 * 3. Thread-safety
 *
 *      Since strings cannot be changed, multiple threads can share the same String object without synchronization.
 *
 * 4. Hashing Performance
 *
 *          Strings are heavily used as keys in HashMap, HashSet.
 *          If a string’s value could change, its hashCode() would also change → making it impossible to reliably retrieve values.*/