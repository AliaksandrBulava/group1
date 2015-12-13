/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.demo;

import jmp.yury.kiryla.creational_patterns_task1.beans.Person;
import jmp.yury.kiryla.creational_patterns_task1.services.PersonReader;
import jmp.yury.kiryla.creational_patterns_task1.services.PersonWriter;
import jmp.yury.kiryla.creational_patterns_task1.services.factory.PersonStoringFactory;

/**
 * App demo class
 * 
 * @author Yury
 *
 */
public class Demo {
    /**
     * Abstract factory test
     * @param factory the {@link PersonStoringFactory} object
     */
    public void process(PersonStoringFactory factory){
	System.out.println("Start process method with: " + factory.getClass().getSimpleName());
	
	Person person1 = new Person();
	person1.setName("John");
	
	PersonWriter writer = factory.getPersonWriter();
	writer.writePerson(person1);
	
	PersonReader reader = factory.getPersonReader();
	System.out.println("Person from Reader: " + reader.readPerson(person1.getName()));
	
	Person person2 = new Person();
	person2.setName("Bob");
	writer.writePerson(person2);
	
	System.out.println("Peole from Reader: " + reader.readPeople());
	
	System.out.println();
	
    }
}
