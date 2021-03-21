package com.skylark.core;

import java.util.Arrays;

public class SplitString {
	public static void main(String[] args) {
		String str = "asd caio caohioew caosn aic";
		String words[] = str.split(" ");
		Arrays.sort(words);
		System.out.println(String.join(", ", words));
	}
}
