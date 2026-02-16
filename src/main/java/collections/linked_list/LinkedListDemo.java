package collections.linked_list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();




        /**
         *
         * Implements interfaces List , Dequeue ( which internally implements Queue)
         * thus linkedList have properties of List and as well Dequeue
         *
         * 1. Internally uses doubly linked list
         * 2. It implements both List and Dequeue Interfaces unlike arraylist
         * 3. Preferred for frequent insertions and deletions
         * 4. Traversal and random access is slow compared to ArrayList (To access an element, we need to iterate from the beginning to the element.)
         * 5. More memory overhead as Linked-list contains nodes ( each node stores data + 2 references: prev and next)
         *      Arraylist is better as it internally uses array which stores elements in contiguous memory locations
         *
         *
         * | Operation                        | ArrayList          | LinkedList                                         | Notes                                                            |
         * | -------------------------------- | ------------------ | -------------------------------------------------- | ---------------------------------------------------------------- |
         * | **Access by index** (`get(i)`)   | **O(1)**           | **O(n)**                                           | ArrayList can jump directly, LinkedList must traverse            |
         * | **Insert at end** (`add()`)      | Amortized **O(1)** | **O(1)**                                           | ArrayList may resize, LinkedList just adds a node                |
         * | **Insert in middle/start**       | **O(n)**           | **O(1)** if already at node (but O(n) to find it)  | LinkedList is better only if you already have the node reference |
         * | **Remove by index**              | **O(n)**           | **O(n)** to find node, but removing itself is O(1) |                                                                  |
         * | **Search by value** (`contains`) | **O(n)**           | **O(n)**                                           | Both must check each element                                     |*/

    }
}
