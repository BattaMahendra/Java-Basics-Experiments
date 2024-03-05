package collections.linked_list;

public class Test {
    public static void main(String[] args) {
        CustomLinkedList c = new CustomLinkedList();
        CustomLinkedList.insertNode(c , "I");
        CustomLinkedList.insertNode(c , "AM");
        CustomLinkedList.insertNode(c , "MAHENDRA");

        CustomLinkedList.printLinkedList(c);

    }
}
