package collections.maps.Set;

import java.util.*;

public class HashSetExample {



    public static void main(String[] args) {

       HashSet<Integer> hashSet = new HashSet<>();

       //adding elemens

        boolean b = hashSet.add(1);
        System.out.println(b);
        hashSet.add(2);
        hashSet.add(3);
        boolean b2 = hashSet.add(1);
     System.out.println(b2);

        //check for elements
        hashSet.contains(1); // returns true or false

        HashSet<Integer> hashSet2 = new HashSet<>();

        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(1);


        //union of hashsets

        hashSet.addAll(hashSet2);
        System.out.println(hashSet);

        //intersection of hashsets
        hashSet.retainAll(hashSet2);
        System.out.println(hashSet);

        //check whether its a subset
        boolean bool = hashSet.containsAll(hashSet2);
        System.out.println(bool);

        /*
        *
        * Learn about internal mechanism of HashSet
        * EnumSet
        * LinkedHashSet
        * TreeSet
        *
        * Collections.synchronizedSet(hashset);
        * CopyOnWriteArraySet
        * ConcurrentHashMap.newKeySet() (BEST general-purpose choice)
        * */



     }



}
