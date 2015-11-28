/**
 * 
 */
package jmp.yury.kiryla.psd_task1;

import jmp.yury.kiryla.psd_task1.services.FirstService;
import jmp.yury.kiryla.psd_task1.services.SecondService;

/**
 * Main class
 * 
 * @author Yury Kiryla
 *
 */
public class App {

    /**
     * Test Application
     * 
     * @param args
     */
    public static void main(String[] args) {
	FirstService firstService = new FirstService(15.3);
	System.out.println("Result for First service: " + firstService.calculating());
	System.out.println();
	
	SecondService secondService = new SecondService();
	secondService.process();
    }
}
