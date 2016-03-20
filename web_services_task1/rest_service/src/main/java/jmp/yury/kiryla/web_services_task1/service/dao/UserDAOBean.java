/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.service.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jmp.yury.kiryla.web_services_task1.beans.User;

/**
 * {@link UserDAO} implementation
 * 
 * @author Yury_Kiryla
 *
 */
public class UserDAOBean implements UserDAO {

    /**
     * {@link DataSource}
     */
    private DataSource ds;

    /**
     * Constructor
     */
    public UserDAOBean() {
	super();
	try {
	    InitialContext ic = new InitialContext();
	    ds = (DataSource) ic.lookup("java:comp/env/jdbc/rest_db");
	} catch (NamingException e1) {
	    throw new RuntimeException(e1);
	}
	try (Connection connection = ds.getConnection();
		PreparedStatement ps = connection.prepareStatement(
			"CREATE TABLE IF NOT EXISTS USERS(ID INT AUTO_INCREMENT, FIRST_NAME VARCHAR(50) NOT NULL, "
				+ "LAST_NAME VARCHAR(50) NOT NULL, LOGIN VARCHAR(50) NOT NULL, EMAIL VARCHAR(50) NOT NULL, LOGO BLOB, FILENAME VARCHAR(150), PRIMARY KEY (ID), UNIQUE (LOGIN))")) {
	    ps.execute();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#create(jmp.yury.kiryla.web_services_task1.beans.User)
     */
    @Override
    public void create(User user) {
	try (Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(
			"INSERT INTO USERS(FIRST_NAME,LAST_NAME,LOGIN,EMAIL) VALUES (?,?,?,?)",
			Statement.RETURN_GENERATED_KEYS)) {
	    ps.setString(1, user.getFirstName());
	    ps.setString(2, user.getLastName());
	    ps.setString(3, user.getLogin());
	    ps.setString(4, user.getEmail());

	    if (ps.executeUpdate() > 0) {
		try (ResultSet rs = ps.getGeneratedKeys()) {
		    if (rs.next()) {
			user.setId(rs.getLong(1));
		    }
		}
	    }
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#getUserById(long)
     */
    @Override
    public User getUserById(long id) {
	User user = null;
	try (Connection con = ds.getConnection();
		PreparedStatement ps = con
			.prepareStatement("SELECT FIRST_NAME,LAST_NAME,LOGIN,EMAIL FROM USERS WHERE ID=?")) {
	    ps.setLong(1, id);
	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    user = new User();
		    user.setId(id);
		    user.setFirstName(rs.getString("FIRST_NAME"));
		    user.setLastName(rs.getString("LAST_NAME"));
		    user.setLogin(rs.getString("LOGIN"));
		    user.setEmail(rs.getString("EMAIL"));
		}
	    }
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
	return user;
    }

    /**
     * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#getAll()
     */
    @Override
    public List<User> getAll() {
	List<User> users = new ArrayList<>();

	try (Connection connection = ds.getConnection();
		PreparedStatement ps = connection
			.prepareStatement("SELECT ID,FIRST_NAME,LAST_NAME,LOGIN,EMAIL FROM USERS");
		ResultSet rs = ps.executeQuery()) {
	    while (rs.next()) {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setLogin(rs.getString("LOGIN"));
		user.setEmail(rs.getString("EMAIL"));
		users.add(user);
	    }
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}

	return users;
    }

    /**
     * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#update(jmp.yury.
     *      kiryla.web_services_task1.beans.User)
     */
    @Override
    public void update(User user) {
	try (Connection con = ds.getConnection();
		PreparedStatement ps = con
			.prepareStatement("UPDATE USERS SET FIRST_NAME=?,LAST_NAME=?,EMAIL=? WHERE ID=?")) {
	    ps.setString(1, user.getFirstName());
	    ps.setString(2, user.getLastName());
	    ps.setString(3, user.getEmail());
	    ps.setLong(4, user.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}

    }

    /**
     * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#delete(jmp.yury.
     *      kiryla.web_services_task1.beans.User)
     */
    @Override
    public void delete(User user) {
	try (Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM USERS WHERE ID=?")) {
	    ps.setLong(1, user.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#addLogo(java.io.InputStream,
     *      jmp.yury.kiryla.web_services_task1.beans.User)
     */
    @Override
    public void addLogo(InputStream is, String filename, User user) {
	try (Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE USERS SET LOGO=?,FILENAME=? WHERE ID=?")) {
	    ps.setBlob(1, is);
	    ps.setString(2, filename);
	    ps.setLong(3, user.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * @see jmp.yury.kiryla.web_services_task1.service.dao.UserDAO#getLogo(jmp.yury.kiryla.web_services_task1.beans.User)
     */
    @Override
    public Map.Entry<String, InputStream> getLogo(User user) {
	try (Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT LOGO,FILENAME FROM USERS WHERE ID=?")) {
	    ps.setLong(1, user.getId());
	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return new AbstractMap.SimpleEntry<String, InputStream>(rs.getString("FILENAME"),
			    rs.getBinaryStream("LOGO"));
		}
	    }
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
	return null;
    }

}
