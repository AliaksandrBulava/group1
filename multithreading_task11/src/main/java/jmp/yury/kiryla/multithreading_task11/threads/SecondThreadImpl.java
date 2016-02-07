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
public class SecondThreadImpl implements Runnable {
    /**
     * {@link Collection}
     */
    private List<Integer> list;
    
    /**
     * Indicate that thread will be finished
     */
    private boolean stopFlag = false;

    /**
     * @param list
     */
    public SecondThreadImpl(List<Integer> list) {
	super();
	this.list = list;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	while (!stopFlag) {

	    int sum = 0;

	    List<Integer> localList = new ArrayList<Integer>(list);
	    
	    for (int i : localList) {
		sum += i;
	    }

	    System.out.println("Sum of the numbers:" + sum);
	}
    }

    /**
     * @param stopFlag the stopFlag to set
     */
    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

}
