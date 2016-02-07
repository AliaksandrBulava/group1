/**
 * 
 */
package jmp.yury.kiryla.multithreading_task11;

import java.util.ArrayList;
import java.util.List;

import jmp.yury.kiryla.multithreading_task11.threads.FirstThread;
import jmp.yury.kiryla.multithreading_task11.threads.SecondThread;
import jmp.yury.kiryla.multithreading_task11.threads.ThirdThread;

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

	Thread firstThread = new Thread(new FirstThread(collection));
	firstThread.start();
	
	Thread secondThread = new Thread(new SecondThread(collection));
	secondThread.start();
	
	Thread thirdThread = new Thread(new ThirdThread(collection));
	thirdThread.start();
	
	while (firstThread.isAlive()){
	    Thread.sleep(100);
	}
	
	secondThread.interrupt();
	thirdThread.interrupt();
    }

}
