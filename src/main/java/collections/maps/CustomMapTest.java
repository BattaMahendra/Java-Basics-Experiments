package collections.maps;

public class CustomMapTest {

    public static void main(String[] args) {
        CustomMap<String , Integer> map = new CustomMap<>();

        map.put("Mahendra",24);
        map.put("Kishore",24);

        System.out.println(map);

        CustomMap<Integer , Integer> map2 = new CustomMap<>();
        map2.put(16,16);
        map2.put(32,16);
        map2.put(48,16);
        map2.put(64,16);
        map2.put(80,16);
        map2.put(48,17);
        System.out.println(map2);
    }
}
