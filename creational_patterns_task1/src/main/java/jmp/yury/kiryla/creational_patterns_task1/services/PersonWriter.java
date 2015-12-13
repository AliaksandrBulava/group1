/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.services;

import jmp.yury.kiryla.creational_patterns_task1.beans.Person;
import jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao;

/**
 * Person Writer
 * 
 * @author Yury
 *
 */
public class PersonWriter {
    /**
     * {@link PersonDao}
     */
    private PersonDao personDao;

    /**
     * Constructor for {@link PersonWriter}
     * @param personDao the {@link PersonDao} object
     */
    public PersonWriter(PersonDao personDao) {
	super();
	this.personDao = personDao;
    }

    /**
     * Store person
     * @param person the {@link Person} object
     */
    public void writePerson(Person person){
	if (person != null && person.getName() != null && !person.getName().isEmpty()){
	    personDao.writePerson(person);
	}
    }
}
