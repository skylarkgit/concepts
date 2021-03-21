package com.skylark.collection;

import java.util.HashMap;
import java.util.Map;

public class NullPut {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put(null, "firstVal");
		System.out.println(map.put(null, "secondVal"));
		System.out.println(map.get(null));
	}
}
