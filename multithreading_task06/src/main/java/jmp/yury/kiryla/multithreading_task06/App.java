/**
 * 
 */
package jmp.yury.kiryla.multithreading_task06;

import java.util.LinkedList;
import java.util.Queue;

import jmp.yury.kiryla.multithreading_task06.impl.Consumer;
import jmp.yury.kiryla.multithreading_task06.impl.Producer;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Queue<String> queue = new LinkedList<String>();
	
	Producer producer1 = new Producer(queue, "producer1");
	Producer producer2 = new Producer(queue, "producer2");
	Producer producer3 = new Producer(queue, "producer3");
	Producer producer4 = new Producer(queue, "producer4");
	
	Consumer consumer1 = new Consumer(queue);
	Consumer consumer2 = new Consumer(queue);
	Consumer consumer3 = new Consumer(queue);
	Consumer consumer4 = new Consumer(queue);
	
	new Thread(producer1).start();
	new Thread(producer2).start();
	new Thread(producer3).start();
	new Thread(producer4).start();
	
	new Thread(consumer1).start();
	new Thread(consumer2).start();
	new Thread(consumer3).start();
	new Thread(consumer4).start();

    }

}
