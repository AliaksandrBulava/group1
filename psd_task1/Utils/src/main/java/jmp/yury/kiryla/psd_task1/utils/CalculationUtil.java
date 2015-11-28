/**
 * 
 */
package jmp.yury.kiryla.psd_task1.utils;

/**
 * Calculate some value
 * 
 * @author Yury Kiryla
 *
 */
public class CalculationUtil {
    public long calculateValue(double oldValue){
	long newValue = Math.round(oldValue);
	newValue += 10;
	return newValue;
    }
}
