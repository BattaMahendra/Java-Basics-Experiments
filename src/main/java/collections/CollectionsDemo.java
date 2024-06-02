package collections;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionsDemo {
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
            if(count == 0)
            c.add("modification "+ count++);    //modifying the collection inside its own iteration

        });
    }
}
