/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task5.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Create Connection Operations
 * 
 * @author Yury
 *
 */
public class CreateConnectionOperations {
    /**
     * Driver Name
     */
    private static final String DRIVER_NAME = "org.h2.Driver";

    /**
     * Database url
     */
    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    
    /**
     * {@link Connection} to DB
     */
    private Connection connection;
    
    /**
     * Prepare connection
     */
    public void prepare(){
	try {
	    Class.forName(DRIVER_NAME);
	    connection = DriverManager.getConnection(DB_URL);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Return prepared connection
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
}
