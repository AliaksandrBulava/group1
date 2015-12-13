/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.services.factory;

import jmp.yury.kiryla.creational_patterns_task1.services.PersonReader;
import jmp.yury.kiryla.creational_patterns_task1.services.PersonWriter;

/**
 * Person Storing Factory
 * 
 * Implementation Abstract Factory Pattern
 * 
 * @author Yury
 *
 */
public interface PersonStoringFactory {
    /**
     * Get Person Reader
     * @return the {@link PersonReader} object
     */
    public PersonReader getPersonReader();
    
    /**
     * Get Person Writer
     * @return the {@link PersonWriter} object
     */
    public PersonWriter getPersonWriter();
}
