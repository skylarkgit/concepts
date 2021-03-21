package com.skylark.thread;

import java.util.concurrent.ThreadLocalRandom;

public class WaitNotify {

	public static void test() {
		Object obj = new Object();

	}	
	public static void main(String[] args) {
		Data data = new Data();
	    Thread sender = new Thread(new Sender(data));
	    Thread receiver = new Thread(new Receiver(data));
	    
	    sender.start();
	    receiver.start();
	}
}

class Receiver implements Runnable {
    private Data load;
 
    public Receiver(Data data) {
    	this.load = data;
    }
 
    public void run() {
        for(String receivedMessage = load.receive();
          !"End".equals(receivedMessage);
          receivedMessage = load.receive()) {
            
            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println(e); 
            }
        }
    }
}

class Sender implements Runnable {
    private Data data;
 
    public Sender(Data data) {
    	this.data = data;
    }
 
    public void run() {
        String packets[] = {
          "First packet",
          "Second packet",
          "Third packet",
          "Fourth packet",
          "End"
        };
 
        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                System.err.println(e); 
            }
        }
    }
}

class Data {
    private String packet;
    
    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;
 
    public void send(String packet) {
    	synchronized (this) {
	        while (!transfer) {
	            try { 
	                wait();
	            } catch (InterruptedException e)  {
	                Thread.currentThread().interrupt(); 
	                System.err.println(e);
	            }
	        }
	        transfer = false;
	        
	        this.packet = packet;
	        notifyAll();
    	}
    }
 
    public String receive() {
    	synchronized (this) {
		
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                System.err.println(e); 
            }
        }
        transfer = true;

        this.notifyAll();
    	
		}
        return packet;
    }
}

