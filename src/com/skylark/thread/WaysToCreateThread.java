package com.skylark.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WaysToCreateThread {
	
	public static void main(String[] args) {
		threadUsingExecutorService();
		threadUsingRunnableInterface();
		threadUsingThreadClass();
	}
	
	public static void threadUsingRunnableInterface() {
		Thread thread = new Thread(new Thread1());
		thread.start();
	}
	
	public static void threadUsingThreadClass() {
		Thread thread = new Thread2();
		thread.start();
	}

	public static void threadUsingExecutorService() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<?> f = executor.submit(new Thread3());
		executor.shutdown();
	}
}

class Thread1 implements Runnable {
	
	@Override
	public void run() {
		System.out.println(this.getClass().getName());
	}
}

class Thread2 extends Thread {
	
	@Override
	public void run() {
		System.out.println(this.getClass().getName());
	}
}

class Thread3 implements Runnable {
	
	@Override
	public void run() {
		System.out.println(this.getClass().getName());
	}
}