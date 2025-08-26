package collections.list;

import java.util.Stack;

public class StackInJava {

    /*
    * Stack is the child of Vector class
    * Stack is also synchronized as like its parent
    * Follows  Last-In, First-Out (LIFO)  principle*/

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        //push() method to push elements into stack
        stack.push("Mahi");
        stack.push("Nano");
        stack.push("Sabareesh");
        stack.push("Uday");
        stack.push("Ranga");

        //peek() method to return topmost element without removing it
        System.out.println(stack.peek());

        System.out.println("Stack after the peek() method "+ stack);

        //pop() method to remove top most element

        System.out.println(stack.pop());
        System.out.println("Stack after the pop() method "+ stack);

        //search(Object o) method return index of object ( 1 - based index)

        System.out.println( stack.search("Mahi"));

        /**
         * every operation in stack is synchronized ( so thread safe)
         * But it comes at a heavy price of performance
         *
         * So better alternative is to use ArrayDeque in java*/

    }
}
