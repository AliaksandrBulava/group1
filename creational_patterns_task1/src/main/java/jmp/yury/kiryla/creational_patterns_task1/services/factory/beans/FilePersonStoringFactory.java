/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.services.factory.beans;

import jmp.yury.kiryla.creational_patterns_task1.dao.beans.FilePersonDao;
import jmp.yury.kiryla.creational_patterns_task1.services.PersonReader;
import jmp.yury.kiryla.creational_patterns_task1.services.PersonWriter;
import jmp.yury.kiryla.creational_patterns_task1.services.factory.PersonStoringFactory;

/**
 * File {@link PersonStoringFactory} implementation
 * 
 * @author Yury
 *
 */
public class FilePersonStoringFactory implements PersonStoringFactory {

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.services.factory.PersonStoringFactory#getPersonReader()
     */
    @Override
    public PersonReader getPersonReader() {
	return new PersonReader(FilePersonDao.getInstance());
    }

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.services.factory.PersonStoringFactory#getPersonWriter()
     */
    @Override
    public PersonWriter getPersonWriter() {
	return new PersonWriter(FilePersonDao.getInstance());
    }

    
}
