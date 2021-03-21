package com.skylark.core;

public class TestingWhichMethodIsShownInStacktrace {
	public static void main(String[] args) {
		new TestingWhichMethodIsShownInStacktrace().m1();
	}

	public void m1() {
		try {
			m2();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void m2() throws Exception {
		// Not this
		throw m3();
	}
	
	public Exception m3() {
		// ... but this
		return new Exception();
	}
}
