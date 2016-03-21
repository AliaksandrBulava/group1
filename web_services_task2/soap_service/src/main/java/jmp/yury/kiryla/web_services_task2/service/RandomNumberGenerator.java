/**
 * 
 */
package jmp.yury.kiryla.web_services_task2.service;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Web Service implementation
 * 
 * @author Yury_Kiryla
 *
 */
@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC, use=SOAPBinding.Use.LITERAL)
public class RandomNumberGenerator {
	
	/**
	 * {@link Random} object
	 */
	Random random = new Random();
	
	/**
	 * Generate Random number
	 * @param lowerBound Lower bound
	 * @param upperBound Upper bound
	 * @return random number
	 */
	@WebMethod
	public int randomNumber(@WebParam(partName="lowerBound") int lowerBound, @WebParam(partName="upperBound") int upperBound) {
		return random.nextInt(upperBound - lowerBound) + lowerBound;
	}
}
