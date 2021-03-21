package com.skylark.exceptions;

public class FinallyOveridingReturn {

	public static void main(String[] args) {
		System.out.println(output());
	}
	
	public static boolean output() {
		try {
			return true;
		} finally {
			return false;
		}
	}
}
