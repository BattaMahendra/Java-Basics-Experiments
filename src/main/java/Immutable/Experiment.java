package Immutable;

import java.util.HashMap;
import java.util.Map;

public class Experiment {

	public static void main(String[] args) {
		Map<Integer , String> tempMap = new HashMap<>();
		tempMap.put(1, "hello");
		tempMap.put(2, "jack");
		CustomImmutable custom = new CustomImmutable(1, 2,tempMap);
		
		System.out.println(custom);
		
	}
}
