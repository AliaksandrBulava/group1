/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task4.impl;

/**
 * Shared resource implementation
 * 
 * @author Yury
 *
 */
public class Resource {
    /**
     * Value returned from Resource
     */
    private static final String VALUE = "Value";

    /**
     * Resource instance
     */
    private static Resource instance = null;

    /**
     * {@link Resource} constructor
     */
    private Resource() {
	super();
    }

    /**
     * @return the instance
     */
    public static synchronized Resource getInstance() {
	if (instance == null) {
	    instance = new Resource();
	}
	return instance;
    }

    public String getValue() {
	System.out.println("[" + Thread.currentThread().getName() + "] getting value from Resource");

	synchronized (instance) {
	    // simulate long processing time
	    try {
		Thread.sleep(10000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    return VALUE;
	}
    }
}
