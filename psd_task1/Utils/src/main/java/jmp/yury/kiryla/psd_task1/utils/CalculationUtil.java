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
    
    /**
     * Calculate new Value from old Value
     * @param oldValue the Old Value
     * @return new Value
     */
    public static long calculateValue(double oldValue){
	long newValue = Math.round(oldValue);
	newValue += 10;
	return newValue;
    }
}
