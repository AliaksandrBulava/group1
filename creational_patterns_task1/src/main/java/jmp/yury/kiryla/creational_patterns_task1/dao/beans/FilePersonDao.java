/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.dao.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import jmp.yury.kiryla.creational_patterns_task1.beans.Person;
import jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao;

/**
 * File implementation for {@link PersonDao}
 * 
 * @author Yury
 *
 */
public class FilePersonDao implements PersonDao {
    
    /**
     * File for storing people
     */
    private static final String FILENAME = "person.txt";
    
    /**
     * for set id
     */
    private long idCounter = 1;
    
    /**
     * {@link FilePersonDao} instance
     */
    private static FilePersonDao instance = null;

    /**
     * {@link FilePersonDao}'s constructor
     */
    private FilePersonDao() {
	super();
    }
    
    /**
     * Get DAO instance
     * @return {@link FilePersonDao} object
     */
    public static synchronized FilePersonDao getInstance(){
	if (instance == null){
	    instance = new FilePersonDao();
	}
	return instance;
    }

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#writePerson(jmp.yury.kiryla.creational_patterns_task1.beans.Person)
     */
    @Override
    public void writePerson(Person person) {
	try {
	    List<Person> people = readPeople();
	    if (people == null){
		people = new ArrayList<Person>();
	    }
	    
	    
	    people.add(person);
	    person.setId(idCounter++);
	    
	    File file = new File(FILENAME);
	    
	    ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
	    ous.writeObject(people);
	    ous.flush();
	    ous.close();
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#readPerson(java.lang.String)
     */
    @Override
    public Person readPerson(String name) {
	List<Person> people = readPeople();
	if (people != null){
	    for (Person person : people){
		if (person.getName().equals(name)){
		    return person;
		}
	    }
	}
	return null;
    }

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#readPeople()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> readPeople() {
	List<Person> people = null;
	try {
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
	    people = (List<Person>) ois.readObject();
	    ois.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	return people;
    }

}
