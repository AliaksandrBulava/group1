/**
 * 
 */
package jmp.yury.kiryla.multithreading_task11.threads;

import java.util.List;
import java.util.Random;

/**
 * 1st thread is infinitely writing random number to the collection
 * 
 * @author Yury
 *
 */
public class FirstThreadImpl implements Runnable {
    /**
     * {@link Collection}
     */
    private List<Integer> list;

    /**
     * {@link Random}
     */
    private Random rand = new Random();

    /**
     * @param list
     */
    public FirstThreadImpl(List<Integer> list) {
	super();
	this.list = list;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	while (true) {
	    list.add(rand.nextInt(10));
	}
    }

}
