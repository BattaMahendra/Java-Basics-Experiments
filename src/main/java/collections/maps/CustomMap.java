package collections.maps;

public class CustomMap<K,V> {

    private Node[] bucketArray = new Node[16];

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
        int hashRange = 16;
        return key.hashCode() % hashRange;
    }

    public void put(K key , V value){
        int nodeValue = hash(key);
        Node presentNode = bucketArray[nodeValue];

        if(presentNode == null){
            Node newNode = new Node<>(key, value);
            bucketArray[nodeValue] = newNode;
        }else{
            Node prevNode = presentNode;

            while(presentNode != null){
                if(presentNode.key.equals(key)){
                    presentNode.value = value;
                    return;
                }

                prevNode = presentNode;
                presentNode = presentNode.next;
            }
            Node newNode = new Node<>(key, value);
            prevNode.next = newNode;
        }
    }

    public V get(K key){
        int hashCode = hash(key);
        Node presentNode = bucketArray[hashCode];

        while(presentNode != null){

            if(presentNode.key.equals(key)){
                return (V) presentNode.value;
            }
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
