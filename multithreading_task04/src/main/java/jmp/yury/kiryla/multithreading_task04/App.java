/**
 * 
 */
package jmp.yury.kiryla.multithreading_task04;

import jmp.yury.kiryla.multithreading_task04.cars.Car;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	ThreadGroup threadGroup = new ThreadGroup("Cars");
	
	//Ferrari
	Car ferrari = new Car("Ferrari", 100);
	Thread ferrariThread = new Thread(threadGroup, ferrari);
	
	//Bugatti
	Car bugatti = new Car("Bugatti", 90);
	Thread bugattiThread = new Thread(threadGroup, bugatti);
	
	//Lamborgini
	Car lamborgini = new Car("Lamborgini", 110);
	Thread lamborginiThread = new Thread(threadGroup, lamborgini);
	
	//Porche
	Car porche = new Car("Porche", 100);
	Thread porcheThread = new Thread(threadGroup, porche);
	
	ferrariThread.start();
	bugattiThread.start();
	lamborginiThread.start();
	porcheThread.start();
	
	

    }

}
