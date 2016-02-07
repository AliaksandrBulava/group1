/**
 * 
 */
package jmp.yury.kiryla.multithreading_task11.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * 3rd is printing square root of sum of squares of all numbers in the
 * collection
 * 
 * @author Yury
 *
 */
public class ThirdThreadImpl implements Runnable {

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
    public ThirdThreadImpl(List<Integer> list) {
	super();
	this.list = list;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
	while (!stopFlag) {
	    double sqSum = 0;
	    List<Integer> localList = new ArrayList<Integer>(list);

	    for (int i : localList) {
		sqSum += Math.sqrt(i);
	    }
	    System.out.println("Square root sum: " + sqSum);
	}

    }

    /**
     * @param stopFlag the stopFlag to set
     */
    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

}
