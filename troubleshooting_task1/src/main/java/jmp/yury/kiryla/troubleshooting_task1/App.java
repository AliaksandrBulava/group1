/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task1;

import jmp.yury.kiryla.troubleshooting_task1.threads.SynchronizedThread;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	Object lock1 = new String("Lock1");
    	Object lock2 = new String("Lock2");

    	Thread thread1 = new Thread(new SynchronizedThread(lock1, lock2));
    	Thread thread2 = new Thread(new SynchronizedThread(lock2, lock1));
    	
    	thread1.start();
    	thread2.start();
    }

}
