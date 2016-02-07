/**
 * 
 */
package jmp.yury.kiryla.multithreading_task11;

import java.util.ArrayList;
import java.util.List;

import jmp.yury.kiryla.multithreading_task11.threads.FirstThreadImpl;
import jmp.yury.kiryla.multithreading_task11.threads.SecondThreadImpl;
import jmp.yury.kiryla.multithreading_task11.threads.ThirdThreadImpl;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
	List<Integer> collection = new ArrayList<Integer>();

	FirstThreadImpl firstThreadImpl = new FirstThreadImpl(collection);
	Thread firstThread = new Thread(firstThreadImpl);
	firstThread.start();
	
	SecondThreadImpl secondThreadImpl = new SecondThreadImpl(collection);
	Thread secondThread = new Thread(secondThreadImpl);
	secondThread.start();
	
	ThirdThreadImpl thirdThreadImpl = new ThirdThreadImpl(collection);
	Thread thirdThread = new Thread(thirdThreadImpl);
	thirdThread.start();
	
	firstThread.join();
	
	secondThreadImpl.setStopFlag(true);
	thirdThreadImpl.setStopFlag(true);
	
	secondThread.join();
	thirdThread.join();
	
	System.out.println("Complete");
    }

}
