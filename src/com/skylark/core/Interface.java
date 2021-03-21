package com.skylark.core;

public class Interface {
	public static void main(String[] args) {
		System.out.println("Main");
		System.out.println(Dummy.s);
		
		// Will run the static block
		new DummyImpl();
		new DummyImpl();
	}
}

interface Dummy {
	public String s = "Why it works?";
	
	void method();
}

class DummyImpl implements Dummy {
	static {
		// Runs only before the first instance is created
		System.out.println("s = " + s);
	}
	
	// Will cry if no access specifier is specified, public void method() -> void method()
	public void method() {
		System.out.println("The Method");
	}
}