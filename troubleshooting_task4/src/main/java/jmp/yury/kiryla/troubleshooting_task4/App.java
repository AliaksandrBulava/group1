/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task4;

import jmp.yury.kiryla.troubleshooting_task4.impl.Executor;
import jmp.yury.kiryla.troubleshooting_task4.impl.Resource;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * Demo
     * 
     * @param args
     */
    public static void main(String[] args) {
	Resource resource = Resource.getInstance();
	for (int i = 0; i < 5; i++) {
	    new Thread(new Executor(resource)).start();
	}

    }

}
