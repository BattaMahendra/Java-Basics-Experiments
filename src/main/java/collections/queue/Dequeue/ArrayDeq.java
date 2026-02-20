package collections.queue.Dequeue;

import java.util.ArrayDeque;

public class ArrayDeq {


    public static void main(String[] args) {

        ArrayDeque<Integer> adq = new ArrayDeque<>();

        // it doesn't allow null values
        //adq.offer(null);

        //Array Deque is predominantly used as a stack in cases of single thread stack
        usingArrayDequeForStackOperations(adq);

        /*
        * Deque operations */
        DequeOperations(adq);


    }

    private static void DequeOperations(ArrayDeque<Integer> adq) {
        System.out.println("\n====================================== Using array deque for both end operations ===============================\n");
        System.out.println("adq before deque operations demo: "+ adq);

        //adding elements at starting
        adq.offerFirst(4);
        adq.offerFirst(5);
        System.out.println("adq after offerFirst() operation: "+ adq);
        //peeking elements at starting
        adq.peekFirst();

        adq.pollFirst();
        System.out.println("adq after pollFirst() operation: "+ adq);

        // adding elements at the end of array
        adq.offerLast(0);
        adq.offerLast(-1);
        adq.offer(-2); // we can also use offer() method for same outcome ( this is because of standard queue operations)
        System.out.println("adq after offerLast() operation: "+ adq);

        //removing elements at the end of array
        adq.peekLast(); // for looking at rear end element without removing
        adq.poll();
        System.out.println("adq after poll() : "+ adq);
        adq.pollLast();
        System.out.println("adq after  pollLast() method: "+ adq);

    }

    /*
     * ArrayDeque is famous for the usage of stack operations
     *
     * why ?
     * Usually in java original stack (implements Vector interface) is heavily synchronized  and thread safe
     *
     * Where as a ArrayDeque operates on internal dynamic array and best to use on single thread stack
     * */

    private static void usingArrayDequeForStackOperations(ArrayDeque<Integer> adq) {
        System.out.println("\n ===================================== Using array deque for stack operations ==========================================\n");
        //push operation
        adq.push(1);
        adq.push(2);
        adq.push(3);
        adq.push(4);

        //peek operation (allows us to see the last element of the stack without popping)
        System.out.println(adq.peek());
        System.out.println("ArrayDeque Stack after the peek(): "+ adq);

        //pop operation (popping out last item)
        System.out.println(adq.pop());
        System.out.println("ArrayDeque Stack after the pop(): "+ adq);


    }
}
