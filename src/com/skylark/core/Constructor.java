package com.skylark.core;

public class Constructor {

	public void Constructor() {
		System.out.println("Hi, I am not really a constructor");
	}
	
	public static void main(String[] args) {
		Constructor c = new Constructor();
		c.Constructor();
	}
}
