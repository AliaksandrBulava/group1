/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1;

import jmp.yury.kiryla.creational_patterns_task1.demo.Demo;
import jmp.yury.kiryla.creational_patterns_task1.services.factory.beans.FilePersonStoringFactory;
import jmp.yury.kiryla.creational_patterns_task1.services.factory.beans.JdbcPersonStoringFactory;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Demo demo = new Demo();
	
	demo.process(new JdbcPersonStoringFactory());

	demo.process(new FilePersonStoringFactory());
    }

}
