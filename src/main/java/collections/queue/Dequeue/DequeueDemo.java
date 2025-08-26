package collections.queue.Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeueDemo {

    /**
     * Deque ==> Double ended queue
     * Deque is special type of queue where we can perform queue operations from both ends
     *
     * It can also act as a Stack and it is preferred over java stack
     **/

    public static void main(String[] args) {

        // deque is instantiated in tow ways ( array and linkedList)
        Deque<String> arrayDeque = new ArrayDeque<>();

        //LinkedList also implements Deque interface
        Deque<String> linkedListDeque = new LinkedList<>();
        linkedListDeque.add("Mahi");


        /* the below method doesn't work as get() method belongs to List interface*/
        //linkedListDeque.get("Mahi");

        /*
        * But the same will work with out reference type (it is with class reference type) */
        LinkedList<String> l =new LinkedList<String>();
        l.get(1);




        /*
        * Linked list also extends List interface but in above case we used reference as Deque
        * so the list internal methods can't be called by object linkedListDeque
        * because reference type methods are verified during compile time itself
        * so when we try to reference linkedListDeque.get() doesn't work as get() method is specific to List interface and
        *    compiler searches for it in Queue interface and won't be able to find it
        *
        * Key concept in Inheritance
        *
        * A class implementing multiple interfaces
        * For example class A implements interfaces B and C
        *
        * if we use  B b = new A(); then we can't access specific methods of Interface C
        * Because at the compile time compiler searches for methods of C in B and can't find so it doesn't allow
        *
        * But JVM will allow all methods at runtime
        * i.e observe following
        * new A(). with out any parent reference can access both parents specific methods as compiler doesn;t
        * have any reference to check
        *
        * Even A a = new A(); also allows 'a' to access all methods of both parents */

    }
}
