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

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.exceptions.DAOException;

/**
 * {@link AuditoriumDAO}'s JDBC implementation
 * 
 * @author Yury
 *
 */
public class AuditoriumJdbcDAO extends AbstractJdbcDAO implements AuditoriumDAO {

    /**
     * {@link AuditoriumJdbcDAO} instance
     */
    private static AuditoriumJdbcDAO instance = null;

    /**
     * insert auditorium statement
     */
    private static final String INSERT_AUDITORIUM = "INSERT INTO AUDITORIUMS(NAME) VALUES (?)";

    /**
     * update auditorium statement
     */
    private static final String UPDATE_AUDITORIUM = "UPDATE AUDITORIUMS SET NAME=? WHERE ID=?";

    /**
     * delete auditorium statement
     */
    private static final String DELETE_AUDITORIUM = "DELETE FROM AUDITORIUMS WHERE ID=?";

    /**
     * select auditorium by id statement
     */
    private static final String SELECT_AUDITORIUM_BY_ID = "SELECT ID,NAME FROM AUDITORIUMS WHERE ID=?";

    /**
     * select auditorium by name statement
     */
    private static final String SELECT_AUDITORIUM_BY_NAME = "SELECT ID,NAME FROM AUDITORIUMS WHERE NAME=?";

    /**
     * select auditoriums statement
     */
    private static final String SELECT_AUDITORIUMS = "SELECT ID,NAME FROM AUDITORIUMS";

    /**
     * @param dataSource
     *            {@link DataSource}
     */
    private AuditoriumJdbcDAO(DataSource dataSource) {
	super(dataSource);
    }

    /**
     * Get {@link AuditoriumJdbcDAO} instance
     * 
     * @param dataSource
     * @return
     */
    public static synchronized AuditoriumJdbcDAO getInstance(DataSource dataSource) {
	if (instance == null) {
	    instance = new AuditoriumJdbcDAO(dataSource);
	}
	return instance;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO#saveAuditorium(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium)
     */
    @Override
    public void saveAuditorium(Auditorium auditorium) {
	if (auditorium == null || auditorium.getName() == null || auditorium.getName().isEmpty()) {
	    throw new IllegalArgumentException("Invalid auditorium object");
	}

	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT_AUDITORIUM, Statement.RETURN_GENERATED_KEYS)) {
	    ps.setString(1, auditorium.getName());

	    if (ps.executeUpdate() > 0) {
		try (ResultSet rs = ps.getGeneratedKeys()) {
		    if (rs.next()) {
			auditorium.setId(rs.getLong(1));
		    } else {
			throw new DAOException("There is not id generated for Auditorium");
		    }
		}
	    } else {
		throw new DAOException("Creating auditorium failed");
	    }
	} catch (SQLException e) {
	    throw new DAOException("Creating Auditorium exception", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO#updateAuditorium(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium)
     */
    @Override
    public void updateAuditorium(Auditorium auditorium) {
	if (auditorium == null || auditorium.getName() == null || auditorium.getName().isEmpty()) {
	    throw new IllegalArgumentException("Invalid Auditorium object");
	}

	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_AUDITORIUM)) {
	    ps.setString(1, auditorium.getName());
	    ps.setLong(2, auditorium.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new DAOException("Error during Auditorium update", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO#removeAuditorium(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium)
     */
    @Override
    public void removeAuditorium(Auditorium auditorium) {
	if (auditorium == null) {
	    throw new IllegalArgumentException("Invalid Auditorium object");
	}

	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_AUDITORIUM)) {
	    ps.setLong(1, auditorium.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new DAOException("Error during Auditorium delete", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO#getAuditorium(long)
     */
    @Override
    public Auditorium getAuditorium(long id) {
	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_AUDITORIUM_BY_ID)) {
	    ps.setLong(1, id);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return createAuditorium(rs);
		}
	    }

	} catch (SQLException e) {
	    throw new DAOException("Error during Auditorium executing", e);
	}
	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO#getAuditorium(java.lang.String)
     */
    @Override
    public Auditorium getAuditorium(String name) {
	if (name == null || name.isEmpty()) {
	    throw new IllegalArgumentException("Invalid name");
	}

	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_AUDITORIUM_BY_NAME)) {
	    ps.setString(1, name);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return createAuditorium(rs);
		}
	    }

	} catch (SQLException e) {
	    throw new DAOException("Error during Auditorium executing", e);
	}

	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO#getAuditoriums()
     */
    @Override
    public List<Auditorium> getAuditoriums() {
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_AUDITORIUMS);
		ResultSet rs = ps.executeQuery()) {
	    List<Auditorium> users = new ArrayList<>();

	    while (rs.next()) {
		users.add(createAuditorium(rs));
	    }

	    return users.isEmpty() ? null : users;
	} catch (SQLException e) {
	    throw new DAOException("Error during Auditorium executing", e);
	}
    }

    /**
     * Create Auditorium object
     * 
     * @param rs
     *            {@link ResultSet}
     * @return {@link Auditorium}
     * @throws SQLException
     *             if exception occurred
     */
    private Auditorium createAuditorium(ResultSet rs) throws SQLException {
	Auditorium auditorium = new Auditorium();
	auditorium.setId(rs.getLong("ID"));
	auditorium.setName(rs.getString("NAME"));
	return auditorium;
    }
}
