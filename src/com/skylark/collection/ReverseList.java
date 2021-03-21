package com.skylark.collection;

import java.util.Collections;
import java.util.LinkedList;

public class ReverseList {
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		
		l.add(5);
		l.add(0, 6);
		
		Collections.reverse(l);
		System.out.println(l);
	}
}
