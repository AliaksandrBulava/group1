/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.services;

import java.util.List;

import jmp.yury.kiryla.creational_patterns_task1.beans.Person;
import jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao;

/**
 *  Person Reader
 * 
 * @author Yury
 *
 */
public class PersonReader {
    /**
     * {@link PersonDao}
     */
    private PersonDao personDao;

    /**
     * {@link PersonReader}'s constructor
     * @param personDao the {@link PersonDao} object
     */
    public PersonReader(PersonDao personDao) {
	super();
	this.personDao = personDao;
    }
    
    /**
     * Get Person
     * @param name the Person's name
     * @return the {@link Person} object
     */
    public Person readPerson(String name){
	if (name != null && ! name.isEmpty()){
	    return personDao.readPerson(name);
	}
	return null;
    }
    
    /**
     * Get people
     * @return list {@link Person} objects
     */
    public List<Person> readPeople(){
	return personDao.readPeople();
    }

}
