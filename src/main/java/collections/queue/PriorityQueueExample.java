package collections.queue;

import basic.experiments.pojos.Emp;
import java8.Java_Streams.Employee;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        // Creating a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the priority queue
        pq.offer(3);
        pq.offer(1);
        pq.offer(5);

        // Example of basic operations
        System.out.println("Priority Queue: " + pq); // Output: Priority Queue: [1, 3, 5]

        int highestPriority = pq.poll(); // Retrieves and removes the head of the queue (the smallest element)
        System.out.println("Removed element with highest priority: " + highestPriority); // Output: Removed element with highest priority: 1

        int peekElement = pq.peek(); // Retrieves, but does not remove, the head of the queue
        System.out.println("Element with highest priority (peek): " + peekElement); // Output: Element with highest priority (peek): 3

        boolean isEmpty = pq.isEmpty(); // Checks if the queue is empty
        System.out.println("Is priority queue empty? " + isEmpty); // Output: Is priority queue empty? false

        int size = pq.size(); // Returns the number of elements in the queue
        System.out.println("Size of priority queue: " + size); // Output: Size of priority queue: 2

        pq.clear(); // Removes all elements from the queue
        System.out.println("Priority queue after clearing: " + pq); // Output: Priority queue after clearing: []


        // Example of a max heap using a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.offer(3);
        maxHeap.offer(1);
        maxHeap.offer(5);


        System.out.println("Max Heap (using reverse order comparator): " + maxHeap);
        int i =0;
        while(i < maxHeap.size())
        System.out.println(maxHeap.poll());



        System.out.println("\n\t\t==== priority queue storing objects implementing comparable ===========\n");
        // Example of custom objects in priority queue
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.offer(new Task("Task 1", 3));
        taskQueue.offer(new Task("Task 2", 1));
        taskQueue.offer(new Task("Task 3", 5));

        //throws exception
       // taskQueue.offer(null);

        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processed task: " + task.name);
        }

        System.out.println("\n\t\t==== priority queue storing objects implementing custom comparator ===========\n");
        // Example of a priority queue for tasks with custom comparator
        PriorityQueue<Task> taskQueueWithCustomComaprator = new PriorityQueue<>(new TaskComparator());

        taskQueueWithCustomComaprator.offer(new Task("Task 1", 3));
        taskQueueWithCustomComaprator.offer(new Task("Task 2", 1));
        taskQueueWithCustomComaprator.offer(new Task("Task 3", 5));

        while (!taskQueueWithCustomComaprator.isEmpty()) {
            Task task = taskQueueWithCustomComaprator.poll();
            System.out.println("Processed task: " + task.name);
        }

        /*
       * If we populate priorityQueue with custom objects which doesn't implement Comparable then it throws exception
       * */
        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();
     //   Employee.populateEmployee().forEach(employee -> employeePriorityQueue.offer(employee));

//        employeePriorityQueue.forEach(s -> System.out.println(s));


    }

    // Example of a custom class for tasks with priority
    static class Task implements Comparable<Task> {
        String name;
        int priority;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
    }

    // Example of a custom comparator for tasks
    static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            // Higher priority tasks come first (descending order)
            return Integer.compare(task2.priority, task1.priority);
        }
    }
}
