/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task4.impl;

/**
 * Thread implementation
 * 
 * @author Yury
 *
 */
public class Executor implements Runnable {

    /**
     * {@link Resource}
     */
    private Resource resource;

    /**
     * {@link Executor}'s constructor
     * 
     * @param resource the {@link Resource}
     */ 
    public Executor(Resource resource) {
	super();
	this.resource = resource;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	String value = resource.getValue();
	System.out.println("[" + Thread.currentThread().getName() + "] got " + value);
    }

}
