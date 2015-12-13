/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task7.beans;

/**
 * Superman class
 * 
 * @author Yury
 *
 */
public class Superman {
    /**
     * {@link Superman}'s constructor
     */
    private Superman() {
	super();
    }
    
    /**
     * Storing Superman instance
     * @author Yury
     *
     */
    private static class SupermanHolder {
	private static final Superman instance = new Superman();
    }
    
    /**
     * Getting Superman
     * @return the {@link Superman} object
     */
    public static Superman getInstance(){
	return SupermanHolder.instance;
    }

    /**
     * Superman action
     */
    public void action(){
	System.out.println("I am Superman!!!");
    }
}
