/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task5.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read 3 first characters of every line in file and put them to ArrayList
 * 
 * @author Yury
 *
 */
public class Reader {
    
    public List<String> getList(String filename) {
	List<String> lines = new ArrayList<String>();
	
	Scanner scanner = null;
	
	try {
	    scanner = new Scanner(getClass().getResourceAsStream(filename));
	    while (scanner.hasNextLine()) {
		String line = scanner.nextLine();
		String entry = line.substring(0, 3);
		lines.add(entry);
		
		// Just for get heap dump
		Thread.sleep(10);
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	} finally {
	    if (scanner != null) {
		scanner.close();
	    }
	}
	
	return lines;
    }

}
