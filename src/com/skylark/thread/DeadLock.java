package com.skylark.thread;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		t1.start();
		t2.start();
	}
	
	static class Thread1 implements Runnable {
		public void run() {
			lock1.lock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock2.lock();
			lock2.unlock();
			lock1.unlock();
		}
	}
	
	static class Thread2 implements Runnable {
		public void run() {
			lock2.lock();System.out.println("Lock2");
			lock1.lock();System.out.println("Lock1");
			lock2.unlock();System.out.println("UnLock2");
			lock1.unlock();System.out.println("UnLock1");
		}
	}
}
