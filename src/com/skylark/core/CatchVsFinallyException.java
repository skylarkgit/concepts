package com.skylark.core;

public class CatchVsFinallyException {
	public static void main(String[] args) throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("catch");
			throw new Exception();
		} finally {
			System.out.println("finally");
			throw new Exception();
		}
	}
}
