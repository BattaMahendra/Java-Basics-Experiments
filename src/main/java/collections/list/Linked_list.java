package collections.list;

import oops.inheritance.Liger;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Linked_list_Example {

    void instantiation(){

        List l = new LinkedList();

        List l2 = new LinkedList<String>( List.of("1","2"));
        //for the difference between linked list and array list please go through
        //https://www.javatpoint.com/difference-between-arraylist-and-linkedlist
        //https://www.geeksforgeeks.org/arraylist-vs-linkedlist-java/

        Vector v  = new Vector<>();
        v.add("Hello");
        v.add(new Object());
        //please read differences between vector an array list

        Stack stack = new Stack();
        stack.push("Hello");
        stack.push(new Object());
        stack.pop();

    }
}
