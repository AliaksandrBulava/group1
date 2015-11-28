/**
 * 
 */
package jmp.yury.kiryla.psd_task1.services;

import jmp.yury.kiryla.psd_task1.utils.CalculationUtil;

/**
 * First Service
 * 
 * @author Yury Kiryla
 *
 */
public class FirstService {
    /** Value */
    private double value;

    /**
     * Constructor for {@link FirstService}
     * 
     * @param value Value
     */
    public FirstService(double value) {
	super();
	this.value = value;
    }
    
    /**
     * Process method
     * @return calculated value
     */
    public long process(){
	CalculationUtil calculationUtil = new CalculationUtil();
	return calculationUtil.calculateValue(value);
    }
}
