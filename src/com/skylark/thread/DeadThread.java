package com.skylark.thread;

public class DeadThread {
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Whay are you runnin?!");
			}
		});
		
		thread.start();
		thread.join();
		
		// The thread is dead at this point. F
		thread.start();
		System.out.println("RIP!");
	}
}
