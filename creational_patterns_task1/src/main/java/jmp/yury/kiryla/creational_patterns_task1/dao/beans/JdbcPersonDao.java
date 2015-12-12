/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.dao.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jmp.yury.kiryla.creational_patterns_task1.beans.Person;
import jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao;

/**
 * JDBC implementation {@link PersonDao}
 * 
 * @author Yury
 *
 */
public class JdbcPersonDao implements PersonDao {
    /**
     * Driver Name
     */
    private static final String DRIVER_NAME = "org.h2.Driver";

    /**
     * Database url
     */
    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    
    /**
     * Create PERSON table statement
     */
    private static final String CREATE_PERSON_TABLE = "create table PERSON(ID INT AUTO_INCREMENT, NAME VARCHAR(50) NOT NULL,PRIMARY KEY (ID), UNIQUE (NAME)";

    /**
     * Database connection
     */
    private static Connection connection = null;

    /**
     * Constructor
     */
    public JdbcPersonDao() {
	super();
	synchronized (JdbcPersonDao.class) {
	    if (connection == null) {
		try {
		    Class.forName(DRIVER_NAME);
		    connection = DriverManager.getConnection(DB_URL);
		    
		    //Initialize Person table
		    PreparedStatement ps = connection.prepareStatement(CREATE_PERSON_TABLE);
		    ps.execute();
		    ps.close();
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#writePerson(jmp.yury.kiryla.creational_patterns_task1.beans.Person)
     */
    @Override
    public void writePerson(Person person) {
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#readPerson(java.
     * lang.String)
     */
    @Override
    public Person readPerson(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#readPeople()
     */
    @Override
    public List<Person> readPeople() {
	// TODO Auto-generated method stub
	return null;
    }

}
