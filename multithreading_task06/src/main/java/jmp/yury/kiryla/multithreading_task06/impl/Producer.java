/**
 * 
 */
package jmp.yury.kiryla.multithreading_task06.impl;

import java.util.Queue;
import java.util.Random;

/**
 * Producer implementation
 * 
 * @author Yury
 *
 */
public class Producer implements Runnable {
    /**
     * {@link Queue} object
     */
    private Queue<String> queue;
    
    private String name;

    /**
     * Max queue length
     */
    private static final int QUEUE_LENGTH = 20;

    /**
     * {@link Random}
     */
    private Random rand = new Random();

    /**
     * @param queue
     * @param maxCapacity
     */
    public Producer(Queue<String> queue, String name) {
	super();
	this.queue = queue;
	this.name = name;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	while (true) {
	    String message = createMessage();

	    synchronized (queue) {
		while (queue.size() == QUEUE_LENGTH) {
		    try {
			System.out.println("[" + Thread.currentThread().getName() + "] " + "Waiting while queue is full");
			queue.wait();
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		}
		queue.add(message);
		queue.notifyAll();
	    }

	    System.out.println("[" + Thread.currentThread().getName() + "] " + "Produced: " + message);
	    
	    try {
		Thread.sleep(rand.nextInt(100));
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * create message
     * 
     * @return generated message
     */
    private String createMessage() {
	return name + "-" + rand.nextInt();
    }

}
