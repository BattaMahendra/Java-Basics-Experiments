package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadOnlyArrayList {

    public static void main(String[] args) {
        // Create a regular ArrayList
        ArrayList<String> mutableList = new ArrayList<>();
        mutableList.add("Apple");
        mutableList.add("Banana");
        mutableList.add("Orange");

        // Create a read-only view of the ArrayList
        List<String> readOnlyList = Collections.unmodifiableList(mutableList);

        // Try to modify the read-only list - this will throw UnsupportedOperationException
        // readOnlyList.add("Grape");  // Uncommenting this line would throw UnsupportedOperationException

        // Access elements in the read-only list
        System.out.println("Read-only List: " + readOnlyList);

        // Original list can still be modified
        mutableList.add("Grape");

        // Print the read-only list again to see the changes reflect
        System.out.println("Read-only List after modifying original list: " + readOnlyList);




    }
}
