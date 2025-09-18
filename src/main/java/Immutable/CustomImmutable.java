package Immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.ToString;

@ToString
/*
 * 1. we need to make class final so that it can't be extended
 * 2. Data members should be private and final and should be initialized in costructor
 * 3. Setters should be avoided
 * 4. If Reference objects are data members then their copy should be returned in getter
 */
public final class CustomImmutable {

	/* Data members should be private final*/
	private  final int variable;

	private  final Integer variable2;

	private final Map<Integer , String> map ;

	/*
	* Data members should be initialized in constructor itself*/

	public CustomImmutable(int a , Integer b , Map<Integer , String> map) {

		this.variable =a;
		this.variable2=b;

		Map<Integer , String> tempMap = new HashMap<>();
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.map =tempMap;

	}

	public int getVariable() {
		return variable;
	}

	public Integer getVariable2() {
		return variable2;
	}

	public Map<Integer, String> getMap() {
		return (HashMap<Integer , String>) map;
	}

	public static void main(String[] args) {

		Map<Integer , String> map =new HashMap<Integer , String>();
		map.put(1, "HEms");
		Map<Integer , String> map2 =new HashMap<Integer , String>();
		CustomImmutable c = new CustomImmutable(0, 5,map);
		System.out.println(c);
		c.map.put(2,"Mahendra");
		System.out.println(c);

	}


}
