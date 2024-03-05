package collections.linked_list;

/*
Internal implementation of linked list class in java for understanding
 */
public class CustomLinkedList {

    Node headNode;
    static class  Node{

        Object dataToBeStored;
        Node nextLink;

        Node(Object data){
            dataToBeStored =data;
        }

    }

    public static CustomLinkedList insertNode(CustomLinkedList customLinkedList , Object data){
            Node newNode = new Node(data);
            newNode.nextLink = null;
            if(customLinkedList.headNode==null) customLinkedList.headNode = newNode;
            else {
                Node n = customLinkedList.headNode;
                while(n.nextLink != null) {
                    n = n.nextLink;
                }
                n.nextLink = newNode;
            }

            return customLinkedList;
    }

    public static void printLinkedList(CustomLinkedList c){
        Node node = c.headNode;
        while (node != null) {
            System.out.println("\n"+node.dataToBeStored);
            node = node.nextLink;

        }
    }
}
