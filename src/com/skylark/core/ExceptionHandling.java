package com.skylark.core;

public class ExceptionHandling {
	public static void method1() throws Exception {
		try {
			int f = 5/0;
			throw new Exception();
		}
		finally {
			System.out.println("Finally");
		}
//		System.out.println("Post Finally"); <-- Unreachable code
	}
	public static void main(String[] args) {

		try {
			method1();
		}
		catch(Exception e) {
			System.out.println("exception");
		}
		System.out.println("finished");
	}
	
}
