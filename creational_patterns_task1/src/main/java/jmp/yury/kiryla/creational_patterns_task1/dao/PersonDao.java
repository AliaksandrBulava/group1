/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.dao;

import java.util.List;

import jmp.yury.kiryla.creational_patterns_task1.beans.Person;

/**
 * Person DAO
 * 
 * @author Yury
 *
 */
public interface PersonDao {
    /**
     * Store Person
     * @param person the {@link Person} object
     */
    public void writePerson(Person person);
    
    /**
     * Get Person
     * @param name the Person's name
     * @return the {@link Person} object
     */
    public Person readPerson(String name);
    
    /**
     * Get people
     * @return list {@link Person} objects
     */
    public List<Person> readPeople();
}
