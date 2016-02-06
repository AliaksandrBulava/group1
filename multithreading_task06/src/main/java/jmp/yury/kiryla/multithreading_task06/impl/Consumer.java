/**
 * 
 */
package jmp.yury.kiryla.multithreading_task06.impl;

import java.util.Queue;
import java.util.Random;

/**
 * Consumer implementation
 * 
 * @author Yury
 *
 */
public class Consumer implements Runnable {
    /**
     * {@link Queue} object
     */
    private Queue<String> queue;

    /**
     * @param queue
     */
    public Consumer(Queue<String> queue) {
	super();
	this.queue = queue;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	Random rand = new Random();
	while (true) {
	    String message;
	    synchronized (queue) {
		while (queue.isEmpty()) {
		    try {
			System.out.println("[" + Thread.currentThread().getName() + "] " + "Waiting while queue is empty");
			queue.wait();
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		}
		message = queue.poll();
		queue.notifyAll();
	    }
	    System.out.println("[" + Thread.currentThread().getName() + "] " + "Consumed: " + message);
	    
	    try {
		Thread.sleep(rand.nextInt(100));
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

}
