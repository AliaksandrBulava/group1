/**
 * 
 */
package jmp.yury.kiryla.multithreading_task04.cars;

import org.apache.log4j.Logger;

/**
 * @author Yury
 *
 */
public class Car implements Runnable {
    private static final long MAX_DISTANCE = 10000;

    Logger log = Logger.getLogger(getClass());
    
    private long friction; 
    private long distance; 
    
    private String name;
    
    private boolean isDisqualified = false;
    
    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;
    }

    @Override
    public void run() {
        try {
            while (distance < MAX_DISTANCE) {
                Thread.sleep(friction);
                
                if (isDisqualified) {
                    log.info(name + " is diqualified");
                    break;
                }
                
                distance += 100;
                log.info(name + " " + distance);
            }
        } catch (InterruptedException e) {
            log.error(e);
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * disqualify car
     */
    public void disqualify(){
	isDisqualified = true;
    }

    /**
     * @return the isDisqualified
     */
    public boolean isDisqualified() {
        return isDisqualified;
    }
    
    
}
