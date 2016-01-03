/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task5.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Close connectio operation
 * 
 * @author Yury
 *
 */
public class CloseOperations {
    
    /**
     * Close SQL Connection
     * @param connection {@link Connection}
     */
    public void closeConnection(Connection connection) {
	if (connection != null){
	    try {
		connection.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * Close Statement
     * @param statement {@link Statement}
     */
    public void closeStatement(Statement statement) {
	if (statement != null) {
	    try {
		statement.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
    
    /**
     * Close Result Set
     * @param resultSet {@link ResultSet}
     */
    public void closeResultSet(ResultSet resultSet) {
	try {
	    if (resultSet != null && !resultSet.isClosed()) {
	        resultSet.close();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
