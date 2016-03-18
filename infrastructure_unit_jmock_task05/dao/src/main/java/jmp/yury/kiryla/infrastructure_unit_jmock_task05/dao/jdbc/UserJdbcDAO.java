/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.UserDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.exceptions.DAOException;

/**
 * {@link UserDAO}'s jdbc implementation
 * 
 * @author Yury
 *
 */
public class UserJdbcDAO extends AbstractJdbcDAO implements UserDAO {
    /**
     * {@link UserJdbcDAO} instance
     */
    private static UserJdbcDAO instance = null;

    /**
     * insert user statement
     */
    private static final String INSERT_USER = "INSERT INTO USERS(NAME) VALUES (?)";

    /**
     * update user statement
     */
    private static final String UPDATE_USER = "UPDATE USERS SET NAME=? WHERE ID=?";

    /**
     * delete user statement
     */
    private static final String DELETE_USER = "DELETE FROM USERS WHERE ID=?";

    /**
     * select user by id statement
     */
    private static final String SELECT_USER_BY_ID = "SELECT ID,NAME FROM USERS WHERE ID=?";

    /**
     * select user by name statement
     */
    private static final String SELECT_USER_BY_NAME = "SELECT ID,NAME FROM USERS WHERE NAME=?";

    /**
     * select users statement
     */
    private static final String SELECT_USERS = "SELECT ID,NAME FROM USERS";

    /**
     * @param dataSource
     *            {@link DataSource} object
     */
    private UserJdbcDAO(DataSource dataSource) {
	super(dataSource);
    }

    /**
     * Get {@link UserJdbcDAO} instance
     * 
     * @param dataSource
     *            {@link DataSource} object
     * @return {@link UserJdbcDAO}
     */
    public static synchronized UserJdbcDAO getInstance(DataSource dataSource) {
	if (instance == null) {
	    instance = new UserJdbcDAO(dataSource);
	}
	return instance;
    }

    /**
     * @see UserDAO#saveUser(User)
     */
    @Override
    public void saveUser(User user) {
	if (user == null || user.getName() == null || user.getName().isEmpty()) {
	    throw new IllegalArgumentException("Invalid User object");
	}

	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
	    ps.setString(1, user.getName());

	    if (ps.executeUpdate() > 0) {
		try (ResultSet rs = ps.getGeneratedKeys()) {
		    if (rs.next()) {
			user.setId(rs.getLong(1));
		    } else {
			throw new DAOException("There is not id generated for User");
		    }
		}
	    } else {
		throw new DAOException("Creating user failed");
	    }
	} catch (SQLException e) {
	    throw new DAOException("Creating User exception", e);
	}
    }

    /**
     * @see UserDAO#updateUser(User)
     */
    @Override
    public void updateUser(User user) {
	if (user == null || user.getName() == null || user.getName().isEmpty()) {
	    throw new IllegalArgumentException("Invalid User object");
	}

	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_USER)) {
	    ps.setString(1, user.getName());
	    ps.setLong(2, user.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new DAOException("Error during User update", e);
	}
    }

    /**
     * @see UserDAO#removeUser(User)
     */
    @Override
    public void removeUser(User user) {
	if (user == null) {
	    throw new IllegalArgumentException("Invalid User object");
	}

	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_USER)) {
	    ps.setLong(1, user.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new DAOException("Error during User delete", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.UserDAO#getUser(long)
     */
    @Override
    public User getUser(long id) {
	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {
	    ps.setLong(1, id);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return createUser(rs);
		}
	    }

	} catch (SQLException e) {
	    throw new DAOException("Error during User executing", e);
	}
	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.UserDAO#getUser(java.lang.String)
     */
    @Override
    public User getUser(String name) {
	if (name == null || name.isEmpty()) {
	    throw new IllegalArgumentException("Invalid name");
	}

	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_NAME)) {
	    ps.setString(1, name);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return createUser(rs);
		}
	    }

	} catch (SQLException e) {
	    throw new DAOException("Error during User executing", e);
	}

	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.UserDAO#getUsers()
     */
    @Override
    public List<User> getUsers() {
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_USERS);
		ResultSet rs = ps.executeQuery()) {
	    List<User> users = new ArrayList<>();

	    while (rs.next()) {
		users.add(createUser(rs));
	    }

	    return users.isEmpty() ? null : users;
	} catch (SQLException e) {
	    throw new DAOException("Error during Users executing", e);
	}
    }

    /**
     * Create new User object
     * 
     * @param rs
     *            {@link ResultSet}
     * @return {@link User}
     * @throws SQLException
     *             if any exception occurs
     */
    private User createUser(ResultSet rs) throws SQLException {
	User user = new User();
	user.setId(rs.getLong("ID"));
	user.setName(rs.getString("NAME"));
	return user;
    }
}
