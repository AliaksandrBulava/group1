/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.exceptions.DAOException;

/**
 * Abstract class for all JDBC DAO beans
 * 
 * @author Yury
 *
 */
public abstract class AbstractJdbcDAO {
    /**
     * {@link DataSource}
     */
    private DataSource dataSource;

    /**
     * @param dataSource the {@link DataSource} object
     */
    public AbstractJdbcDAO(DataSource dataSource) {
	super();
	this.dataSource = dataSource;
    }
    
    /**
     * returns SQL connection from DataSource
     * @return {@link Connection} object
     */
    protected Connection getConnection() {
	try {
	    return dataSource.getConnection();
	} catch (SQLException e) {
	    throw new DAOException("Error getting connection from DataSource", e);
	}
    }
}
