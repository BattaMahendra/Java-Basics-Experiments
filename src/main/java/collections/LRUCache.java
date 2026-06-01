package collections;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<K,V> {

    private final HashMap<K,V> map = new HashMap<>();
    private final LinkedList<K> list = new LinkedList<>();   // operates as a Queue
    private final int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public V put(K k , V v){

        if(map.containsKey(k)){
            list.remove(k);
        }
        // check if capacity is full
        else if(map.size() == capacity){
            map.remove(list.pollLast());   // removes in queue and also in map
        }



        list.offerFirst(k);
        return map.put(k,v);
    }

    public V get(K k){
         if (!map.containsKey(k)){
             return null;
         }
         list.remove(k);
         list.offerFirst(k);
         return map.get(k);
    }


    public static void main(String[] args) {
        LRUCache<Integer, String > cache = new LRUCache<>(3);

        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four");
        System.out.println(cache.list);
        System.out.println(cache.get(1));
        System.out.println(cache.list);
        System.out.println(cache.get(2));
        System.out.println(cache.list);
        System.out.println(cache.get(4));
        System.out.println(cache.list);
    }
}
