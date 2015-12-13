/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task7;

import jmp.yury.kiryla.creational_patterns_task7.beans.Superman;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	Superman superman1 = Superman.getInstance();
	Superman superman2 = Superman.getInstance();
	
	System.out.println("Is there one Superman: " + (superman1 == superman2));
	
//	Superman superman3 = new Superman();

    }

}
