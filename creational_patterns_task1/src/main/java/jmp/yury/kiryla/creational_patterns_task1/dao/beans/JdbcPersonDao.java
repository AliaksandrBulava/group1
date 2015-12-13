/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.dao.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
     * Insert PERSON statement
     */
    private static final String INSERT_PERSON = "insert into PERSON(NAME) values(?)";

    /**
     * Select PERSON by NAME statement
     */
    private static final String SELECT_PERSON = "select ID,NAME from PERSON where NAME=?";

    /**
     * Select all people from PERSON table statement
     */
    private static final String SELECT_PEOPLE = "select ID,NAME from PERSON";

    /**
     * Name order for statements
     */
    private static final int NAME_ORDER = 1;

    /**
     * Key for executing id
     */
    private static final String ID_KEY = "ID";

    /**
     * Key for executing name
     */
    private static final String NAME_KEY = "NAME";

    /**
     * Database connection
     * 
     * 
     */
    // Do not need to close for used db type
    private static Connection connection = null;

    /**
     * Constructor
     */
    public JdbcPersonDao() {
	super();
	if (connection == null) {
	    try {
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(DB_URL);

		// Initialize Person table
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

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#writePerson(jmp.yury.kiryla.creational_patterns_task1.beans.Person)
     */
    @Override
    public void writePerson(Person person) {
	try {
	    PreparedStatement ps = connection.prepareStatement(INSERT_PERSON);
	    ps.setString(NAME_ORDER, person.getName());
	    ps.execute();
	    ps.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#readPerson(java.
     *      lang.String)
     */
    @Override
    public Person readPerson(String name) {
	Person person = null;

	try {
	    PreparedStatement ps = connection.prepareStatement(SELECT_PERSON);
	    ps.setString(NAME_ORDER, name);
	    ResultSet rs = ps.executeQuery();

	    if (rs != null && rs.next()) {
		person = getPerson(rs);
		rs.close();
	    }

	    ps.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return person;
    }

    /**
     * 
     * @see jmp.yury.kiryla.creational_patterns_task1.dao.PersonDao#readPeople()
     */
    @Override
    public List<Person> readPeople() {
	List<Person> people = new ArrayList<Person>();

	try {
	    PreparedStatement ps = connection.prepareStatement(SELECT_PEOPLE);

	    ResultSet rs = ps.executeQuery();

	    if (rs != null) {
		while (rs.next()) {
		    people.add(getPerson(rs));
		}
		rs.close();
	    }

	    ps.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return null;
    }

    /**
     * Create new Person object from Result Set
     * 
     * @param rs
     *            the {@link ResultSet} object
     * @return {@link Person} object
     * @throws SQLException
     *             If exception occurs
     */
    private Person getPerson(ResultSet rs) throws SQLException {
	Person person = new Person();
	person.setId(rs.getLong(ID_KEY));
	person.setName(NAME_KEY);
	return person;
    }
}
