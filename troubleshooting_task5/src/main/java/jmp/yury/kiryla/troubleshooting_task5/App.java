/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task5;

import java.util.List;

import jmp.yury.kiryla.troubleshooting_task5.impl.Reader;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Reader reader = new Reader();
	
	List<String> lines = reader.getList("/Task #5 - Data.txt");
	
	//Just for checking
	System.out.println(lines.isEmpty() ? "Error" : lines.get(0));
    }

}
