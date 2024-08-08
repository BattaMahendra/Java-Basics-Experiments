package collections.maps;

import java.util.Objects;

public class CustomMap<K,V> {

    private int threshold =0;
    private static final float LOAD_FACTOR = 0.75f;

    private int defaultSize;
    private Node[] bucketArray ;

    public CustomMap() {
        defaultSize = 16;
        bucketArray = new Node[defaultSize];
    }

    public CustomMap(int initialCapacity){
        defaultSize = initialCapacity;
        bucketArray = new Node[defaultSize];
    }

    public void resize(){
        Node[] oldNodeArray = bucketArray;

        bucketArray = new Node[oldNodeArray.length * 2];

        //copying old array contents into this new bucket
        for(Node<K,V> node : oldNodeArray) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    static class Node<K,V>{
        public K key;
        public V value;
        public Node next;

        Node(K key,V value ){
            this.key = key;
            this.value = value;
        }
    }

    public int hash(K key){
        int hashRange = bucketArray.length;
        return Objects.hash(key) % hashRange; //simple hashing mechanism by % operator
    }

    public V put(K key , V value){

        //calculate threshold and resize array if required
        if (threshold >= LOAD_FACTOR * bucketArray.length) {
            resize();
        }

        int nodeValue = hash(key);
        Node presentNode = bucketArray[nodeValue];

        if(presentNode == null){      // check if the node of the bucket is empty
            Node newNode = new Node<>(key, value);
            bucketArray[nodeValue] = newNode; //then add new node to the bucket
            threshold++;
        }else{
            Node prevNode = presentNode;

            while(presentNode != null){   //traverse all the linked nodes to find the last node
                if(presentNode.key.equals(key)){   //check if any linked nodes's key matches with given key
                    V returnableValue = (V)presentNode.value;
                    presentNode.value = value;  // update the value of present node and return old value
                    return returnableValue;
                }

                prevNode = presentNode;
                presentNode = presentNode.next; // keep on traversing upto  last node
            }
            Node newNode = new Node<>(key, value);
            prevNode.next = newNode;
            threshold++;
            return null;
        }

        return null;
    }

    public V get(K key){
        int hashCode = hash(key);  // calculate hash of the given key
        Node presentNode = bucketArray[hashCode];

        while(presentNode != null){

            if(presentNode.key.equals(key)){
                return (V) presentNode.value;
            }
            presentNode = presentNode.next;
        }

        return null;
    }

    public V remove (K key){

        int hash = hash(key);
        Node head = bucketArray[hash];

        if(head == null) return null;

        Node presentNode = head.next;
        Node prevNode = null;
        while( presentNode!= null){

            if(presentNode.key.equals(key)){
                if(prevNode == null) {
                   bucketArray[hash] = presentNode.next; //remove head node
                }
                else{
                    prevNode = presentNode.next; //remove any middle node
                }

                threshold--;
                return (V)presentNode.value;
            }
            prevNode = presentNode;
            presentNode = presentNode.next;

        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for(Node node: this.bucketArray){
            while(node != null) {
                sb.append(node.key + " : " + node.value + " , ");
                node = node.next;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
