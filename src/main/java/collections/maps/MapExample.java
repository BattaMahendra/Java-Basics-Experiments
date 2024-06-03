package collections.maps;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"one");
        map.put(new Object(),"two");
        map.put("Hello","three");
        map.put(new ArrayList<>(),"four");

        //you can observe here the map doesn't follow insertion order
        map.entrySet().forEach(System.out::println);


        /*
        * HashMap
        * 1. All unique keys and can have duplicate values
        * 2. Can contain one null key and multiple null values
        * 3. non synchronised
        * 4. based on hashcode method
        * 5. Java HashMap maintains no insertion order.
        * 6. The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.
        * 7. Retrieval and insertion operations (get(), put()) are typically constant time on average (O(1)),
        *    but this can degrade to O(n) in the worst-case scenario.
        * */
        hashmap();

        /*
        *1. Miantains insertion order
        *2. It internally uses a doubly linked list along with a hash table for storing key-value pairs.
        *3. Retrieval and insertion operations are slightly slower compared to HashMap due to
        *   maintaining the insertion order (still generally O(1)).
        * */
        linkedHashMap();

        /*
        * Certainly, here are the points numbered and expanded with more information:

1. **TreeMap maintains the natural ordering of its keys or orders them based on a custom Comparator provided during its initialization**:
   - By default, TreeMap orders its keys according to their natural ordering, which typically means in ascending order for numeric types and lexicographical order for strings.
   - Alternatively, you can provide a custom Comparator implementation during TreeMap initialization to specify a different ordering for the keys.

2. **It is implemented as a red-black tree, which provides log(n) time complexity for most operations, including retrieval, insertion, and deletion (where n is the number of elements in the map)**:
   - Red-black trees are self-balancing binary search trees, ensuring that the height of the tree remains logarithmic.
   - This balanced structure allows TreeMap operations such as retrieval, insertion, and deletion to have logarithmic time complexity, making TreeMap efficient for large datasets.

3. **The elements are sorted based on their keys**:
   - TreeMap maintains its elements sorted based on the natural ordering of keys or the ordering specified by the provided Comparator.
   - This sorted nature allows TreeMap to efficiently support operations like range queries and finding the minimum and maximum keys.

4. **Iterating over the elements of a TreeMap will give them in sorted order (either natural order or the order specified by the comparator)**:
   - When you iterate over a TreeMap using iterators like Iterator or forEach, the elements are returned in sorted order based on their keys.
   - This sorted iteration behavior is a useful feature of TreeMap, especially when you need to process elements in a specific order.

5. **TreeMap does not allow null keys but allows null values (providing the comparator supports them)**:
   - TreeMap's keys must be non-null because it relies on the ordering of keys for its internal structure.
   - However, TreeMap allows null values to be associated with keys, assuming the provided Comparator (if any) can handle null values.

6. **It is useful when the elements need to be stored in a sorted order based on their keys**:
   - TreeMap is particularly useful when you need to maintain a sorted collection of key-value pairs.
   - Use TreeMap when you require efficient sorted operations and when the ordering of elements based on keys is essential to your application logic.
        * */
        treeMap();


        //thread safe hashmap

        HashMap h = new HashMap();
        //we can convert above hashmap into synchronised map by using
        Map threadSafeMap =  Collections.synchronizedMap(h);

        //howeever the above map is not recomended as it is slow and it is synchronised for all operations
        //the solution is Concurrent HashMap

        //concurrent hashmaps can't have null values and null keys just like Hashtable
        ConcurrentHashMap<String , String> concurrentHashMap = new ConcurrentHashMap<>();

        //the above class comes from util.concurrent package and it is more efficient than Hash table and synchronised maps
        // refer to this website : https://www.geeksforgeeks.org/concurrenthashmap-in-java/
        //or read the Map-Info file in this package




    }

    private static void treeMap() {
        TreeMap<Integer , String> t = new TreeMap<Integer , String>();
        t.put(1,"one" );
        t.put(2,"two" );
        t.put(4,"four");
        t.put(5,"five");
        System.out.println("================================= Tree Map ============================");
        System.out.println(t.toString());
    }

    private static void linkedHashMap() {
        Map<String, Integer> stringIntegerMap = new LinkedHashMap<>();
        stringIntegerMap.put("one" ,1);
        stringIntegerMap.put("two" ,2);
        stringIntegerMap.put("four",4);
        stringIntegerMap.put("five",5);
        System.out.println("=======================LinkedHashmap insertion order==================");
        System.out.println(stringIntegerMap.toString());
        //les do try this in hashmap
        System.out.println("======================= Hashmap insertion order fails ==================");
        Map hashmap = new HashMap(stringIntegerMap);
        System.out.println(hashmap.toString());
    }

    private static void hashmap() {
        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1,"one");
        integerStringMap.put(1,"one");
        integerStringMap.put(2,"two");
        integerStringMap.put(4,"four");
        integerStringMap.put(5,"five");


        System.out.println("================== Using basic sorted for keys ==================");
        integerStringMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("================== Using basic reverse sorted for keys ==================");
        integerStringMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(System.out::println);
        System.out.println("================== Using basic reverse sorted for values ==================");
        integerStringMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

        System.out.println("/n=======compute if absent============");

        //sencond arguement is a function which takes key as input and should return a type of value which will be inserted into key value pair
        //if the mentioned key is not present in the map
        integerStringMap.computeIfAbsent(5 , key -> "five modified"); //doesn't execute as key 5 is already present
        integerStringMap.computeIfAbsent(6 , key -> "six inserted using compute if absent");
        System.out.println(integerStringMap);
        System.out.println("/n=======compute if present ============");
        integerStringMap
                .computeIfPresent(5,
                                (k,v) -> k ==5 && v.equals("five") ? v+" modified":"five unmodified");

        System.out.println(integerStringMap.toString());


    }
}
