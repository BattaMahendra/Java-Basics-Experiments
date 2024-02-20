package Immutable;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

@ToString
/*
 * we need to make class final so that it 
 * can't be extended
 */
public final class CustomImmutable {

	private  final int variable;

	private  final Integer variable2;

	private final Map<Integer , String> map ;

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
		System.out.println(c);

	}


}
