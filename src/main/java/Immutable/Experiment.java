package Immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Experiment {

	public static void main(String[] args) throws CloneNotSupportedException {
		Map<Integer , String> tempMap = new HashMap<>();
		tempMap.put(1, "hello");
		tempMap.put(2, "jack");
		CustomImmutable custom = new CustomImmutable(1, 2,tempMap);
		
		System.out.println(custom);
		
		Map<String , String> tempMap2 = new HashMap<>();
		tempMap2.put("hello", "hello");
		tempMap2.put("Jack", "jack");
		
		List<String> models = new ArrayList<>();
		models.add("15 pro max");
		
		Battery b = new Battery(5700, "Sony");
		
		
		SmartPhone s = new SmartPhone(0, "Apple", tempMap2, models, b);
		System.out.println(s+"\n");
		
		s.getSpecifications().put("update", "update");
		s.getBattery().setCapacity(0);
		System.out.println(s+"\n");
		
		
	}
}
