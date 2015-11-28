/**
 * 
 */
package jmp.yury.kiryla.psd_task1.services;

import java.util.Random;

import jmp.yury.kiryla.psd_task1.utils.CalculationUtil;

/**
 * Second Service
 * 
 * @author Yury
 *
 */
public class SecondService {

    /**
     * Process method
     */
    public void process(){
	double value = new Random().nextDouble() * 50;	
	System.out.println("Value from second service: " + CalculationUtil.calculateValue(value));
    }
}
