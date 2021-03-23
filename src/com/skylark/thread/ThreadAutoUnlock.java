package com.skylark.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// https://www.youtube.com/watch?v=UOr9kMCCa5g
// Verifying if the lock is released when the thread is waiting

public class ThreadAutoUnlock {

	private ReentrantLock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	private List<Integer> items = new LinkedList<>();
	private int max = 10;

	public void produce() throws InterruptedException {
		lock.lock();
		try {
			while (items.size() >= max) {
				notFull.await();
			}
			int item = ThreadLocalRandom.current().nextInt();
			items.add(item);
			System.out.println(item + " added");
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void consume() throws InterruptedException {
		lock.lock();
		while (items.isEmpty()) {
			notEmpty.await();
		}
		System.out.println(items.remove(0));
		notFull.signalAll();
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadAutoUnlock tau = new ThreadAutoUnlock();
		
		final Runnable consumer = new Runnable() {
			public void run() {
				while (true) {
					try {
						tau.consume();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		final Runnable producer = new Runnable() {
			public void run() {
				while (true) {
					try {
						tau.produce();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
		
		System.out.println("Started");
		Thread.sleep(1000);
	}
}
