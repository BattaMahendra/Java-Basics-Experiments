package collections.linked_list;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        CustomLinkedList c = new CustomLinkedList();
        CustomLinkedList.insertNode(c , "I");
        CustomLinkedList.insertNode(c , "AM");
        CustomLinkedList.insertNode(c , "MAHENDRA");

        CustomLinkedList.printLinkedList(c);

        //linked list from java
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Hello");
        linkedList.add("Its me");


    }
}
