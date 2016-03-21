/**
 * 
 */
package jmp.yury.kiryla.web_services_task2.client;

import java.rmi.RemoteException;

import jmp.yury.kiryla.web_services_task2.service.RandomNumberGenerator;
import jmp.yury.kiryla.web_services_task2.service.RandomNumberGeneratorService;


/**
 * @author Yury_Kiryla
 *
 */
public class App {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorService().getRandomNumberGeneratorPort();
		System.out.println("Generated numbers:");
		for (int i = 0; i < 6; i++) {
			System.out.println(randomNumberGenerator.randomNumber(1, 49));
		}

	}

}
