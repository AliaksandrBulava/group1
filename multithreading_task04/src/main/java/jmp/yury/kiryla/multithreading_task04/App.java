/**
 * 
 */
package jmp.yury.kiryla.multithreading_task04;

import java.util.HashMap;
import java.util.Map;

import jmp.yury.kiryla.multithreading_task04.cars.Car;

/**
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
	Map<Thread, Car> cars = new HashMap<Thread, Car>();
	
	//Ferrari
	Car ferrari = new Car("Ferrari", 100);
	Thread ferrariThread = new Thread(ferrari);
	cars.put(ferrariThread, ferrari);
	
	//Bugatti
	Car bugatti = new Car("Bugatti", 90);
	Thread bugattiThread = new Thread(bugatti);
	cars.put(bugattiThread, bugatti);
	
	//Lamborgini
	Car lamborgini = new Car("Lamborgini", 110);
	Thread lamborginiThread = new Thread(lamborgini);
	cars.put(lamborginiThread, lamborgini);
	
	//Porche
	Car porche = new Car("Porche", 100);
	Thread porcheThread = new Thread(porche);
	cars.put(porcheThread, porche);
	
	for (Thread thread : cars.keySet()){
	    thread.start();
	}
	
	boolean isFinished = false;
	Car winner = null;
	
	new Thread(new Disqualifer(porche, 5000)).start();;
	
	while (!isFinished){
	    
	    isFinished = true;
	    for (Map.Entry<Thread, Car> entry : cars.entrySet()){
		if (entry.getKey().isAlive()){
		    isFinished = false;
		} else if (winner == null && !entry.getValue().isDisqualified()) {
		    winner = entry.getValue();
		}
	    }
	}

	
	System.out.println("Winner is " + winner.getName());
    }

    private static class Disqualifer implements Runnable{
	private Car car;
	
	private long time;

	/**
	 * @param car
	 * @param time
	 */
	public Disqualifer(Car car, long time) {
	    super();
	    this.car = car;
	    this.time = time;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
	    try {
		Thread.sleep(time);
		car.disqualify();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    
	}
	
	
    }
}
