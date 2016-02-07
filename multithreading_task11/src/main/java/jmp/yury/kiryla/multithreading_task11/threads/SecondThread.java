/**
 * 
 */
package jmp.yury.kiryla.multithreading_task11.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * 2nd thread is printing sum of the numbers in the collection
 * 
 * @author Yury
 *
 */
public class SecondThread implements Runnable {
    /**
     * {@link Collection}
     */
    private List<Integer> list;

    /**
     * @param list
     */
    public SecondThread(List<Integer> list) {
	super();
	this.list = list;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	while (true) {

	    int sum = 0;

	    List<Integer> localList = new ArrayList<Integer>(list);
	    
	    for (int i : localList) {
		sum += i;
	    }

	    System.out.println("Sum of the numbers:" + sum);
	}
    }

}
