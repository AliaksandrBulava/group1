/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task1.threads;

/**
 * @author Yury_Kiryla
 *
 */
public class SynchronizedThread implements Runnable {
	/**
	 * Synch object
	 */
	private Object lock1;
	
	/**
	 * Synch object
	 */
	private Object lock2;

	/**
	 * @param lock1
	 * @param lock2
	 */
	public SynchronizedThread(Object lock1, Object lock2) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
        synchronized (lock1) {
            System.out.println(name + " acquired lock on Object1: " + lock1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
 
            synchronized (lock2) {
                System.out.println(name + " acquired lock on Object2: " + lock2);
            }
            System.out.println(name + " released lock on Object2: " + lock2);
        }
        System.out.println(name + " released lock on Object1: " + lock2);
		
	}

	
}
