package experiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        System.out.println(hashMap.put(1,"Mahendra"));
        System.out.println(hashMap.put(1,"Manjunath"));
        System.out.println(hashMap.remove(1));

        String s = "M";
        Integer i = 77;
        System.out.println(s.hashCode());
        System.out.println(i.hashCode());

        HashSet<Object> set = new HashSet<>();
        set.add(s);
        set.add(i);

        List<String> names  = new ArrayList<>();
        names.add("4");
        names.add("2");
        names.add("3");
        names.add("1");

        String str  = names.stream().findAny().get();
        System.out.println(str);

    }
}
