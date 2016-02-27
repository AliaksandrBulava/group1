/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.exceptions.DAOException;

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
	 * @param dataSource
	 *            the {@link DataSource} object
	 */
	public AbstractJdbcDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	/**
	 * returns SQL connection from DataSource
	 * 
	 * @return {@link Connection} object
	 */
	protected Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new DAOException("Error getting connection from DataSource", e);
		}
	}

	/**
	 * Create db structure
	 * 
	 * @param ds
	 *            {@link DataSource}
	 */
	public static void dbInit(DataSource ds) {
		try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
			stmt.execute(
					"CREATE TABLE USERS(ID INT AUTO_INCREMENT, NAME VARCHAR(50) NOT NULL, PRIMARY KEY (ID), UNIQUE (NAME))");
			stmt.execute(
					"CREATE TABLE AUDITORIUMS(ID INT AUTO_INCREMENT, NAME VARCHAR(50) NOT NULL, PRIMARY KEY (ID), UNIQUE (NAME))");
			stmt.execute(
					"CREATE TABLE EVENTS(ID INT AUTO_INCREMENT, NAME VARCHAR(50) NOT NULL, AUDITORIUM_ID INT NOT NULL, DATE DATE NOT NULL, START_TIME TIME NOT NULL, END_TIME TIME NOT NULL, PRIMARY KEY (ID), UNIQUE (NAME), FOREIGN KEY (AUDITORIUM_ID) REFERENCES AUDITORIUMS(ID))");
			stmt.execute(
					"CREATE TABLE TICKETS(ID INT AUTO_INCREMENT, USER_ID INT NOT NULL, EVENT_ID INT NOT NULL, PRIMARY KEY (ID), UNIQUE (USER_ID,EVENT_ID), FOREIGN KEY (USER_ID) REFERENCES USERS(ID) ON DELETE CASCADE, FOREIGN KEY (EVENT_ID) REFERENCES EVENTS(ID))");
		} catch (SQLException e) {
			throw new DAOException("Error during DB initialization", e);
		}
	}
}
