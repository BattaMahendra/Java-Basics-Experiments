package collections.maps;

import java.util.Objects;

public class CustomMapTest {

    public static void main(String[] args) {
        CustomMap<String , Integer> map = new CustomMap<>();

        map.put("Mahendra",24);
        map.put("Kishore",24);

        System.out.println(map);

        CustomMap<Integer , Integer> map2 = new CustomMap<>();
        String s= null;
        Integer i = null;
        System.out.println(Objects.hash(s));
        System.out.println(Objects.hash(i));
        map2.put(16,16);
        map2.put(32,16);
        map2.put(48,16);
        map2.put(64,16);
        map2.put(80,16);
        map2.put(48,17);
        map2.put(3,17);
        map2.put(null,17);
        System.out.println(map2);
        map2.remove(16);
        System.out.println(map2);

        System.out.println(map2.get(49));
    }
}
