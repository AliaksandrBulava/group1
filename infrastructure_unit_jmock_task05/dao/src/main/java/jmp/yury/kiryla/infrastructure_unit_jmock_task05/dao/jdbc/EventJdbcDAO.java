/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.exceptions.DAOException;

/**
 * {@link EventDAO}'s JDBC implementation
 * 
 * @author Yury
 *
 */
public class EventJdbcDAO extends AbstractJdbcDAO implements EventDAO {
    /**
     * {@link EventJdbcDAO} instance
     */
    private static EventJdbcDAO instance = null;
    
    /**
     * insert event statement
     */
    private static final String INSERT_EVENT = "INSERT INTO EVENTS(NAME,AUDITORIUM_ID,DATE,START_TIME,END_TIME) VALUES (?,?,?,?,?)";
    
    /**
     * update event statement
     */
    private static final String UPDATE_EVENT = "UPDATE EVENTS SET NAME=?,AUDITORIUM_ID=?,DATE=?,START_TIME=?,END_TIME=? WHERE ID=?";
    
    /**
     * delete event statement
     */
    private static final String DELETE_EVENT = "DELETE FROM EVENTS WHERE ID=?";
    
    /**
     * select event by id statement
     */
    private static final String SELECT_EVENT_BY_ID = "SELECT EVENTS.ID,EVENTS.NAME,AUDITORIUMS.ID,AUDITORIUMS.NAME,EVENTS.DATE,EVENTS.START_TIME,EVENTS.END_TIME FROM EVENTS,AUDITORIUMS WHERE EVENTS.ID=? AND EVENTS.AUDITORIUM_ID=AUDITORIUMS.ID";
    
    /**
     * select event by name statement
     */
    private static final String SELECT_EVENT_BY_NAME = "SELECT EVENTS.ID,EVENTS.NAME,AUDITORIUMS.ID,AUDITORIUMS.NAME,EVENTS.DATE,EVENTS.START_TIME,EVENTS.END_TIME FROM EVENTS,AUDITORIUMS WHERE EVENTS.NAME=? AND EVENTS.AUDITORIUM_ID=AUDITORIUMS.ID";
    
    /**
     * select events statement
     */
    private static final String SELECT_EVENTS = "SELECT EVENTS.ID,EVENTS.NAME,AUDITORIUMS.ID,AUDITORIUMS.NAME,EVENTS.DATE,EVENTS.START_TIME,EVENTS.END_TIME FROM EVENTS,AUDITORIUMS WHERE EVENTS.AUDITORIUM_ID=AUDITORIUMS.ID";
    
    /**
     * @param dataSource
     *            {@link DataSource} object
     */
    private EventJdbcDAO(DataSource dataSource) {
	super(dataSource);
    }

    /**
     * Get {@link EventJdbcDAO} instance
     * 
     * @param dataSource
     *            {@link DataSource} object
     * @return {@link EventJdbcDAO}
     */
    public static synchronized EventJdbcDAO getInstance(DataSource dataSource) {
	if (instance == null) {
	    instance = new EventJdbcDAO(dataSource);
	}
	return instance;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO#saveEvent(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event)
     */
    @Override
    public void saveEvent(Event event) {
	if (event == null || event.getName() == null || event.getName().isEmpty() || event.getAuditorium() == null || event.getDate() == null || event.getStartTime() == null || event.getEndTime() == null) {
	    throw new IllegalArgumentException("Invalid Event object");
	}
	
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT_EVENT, Statement.RETURN_GENERATED_KEYS)) {
	    ps.setString(1, event.getName());
	    ps.setLong(2, event.getAuditorium().getId());
	    ps.setDate(3, Date.valueOf(event.getDate()));
	    ps.setTime(4, Time.valueOf(event.getStartTime()));
	    ps.setTime(5, Time.valueOf(event.getEndTime()));

	    if (ps.executeUpdate() > 0) {
		try (ResultSet rs = ps.getGeneratedKeys()) {
		    if (rs.next()) {
			event.setId(rs.getLong(1));
		    } else {
			throw new DAOException("There is not id generated for Event");
		    }
		}
	    } else {
		throw new DAOException("Creating event failed");
	    }
	} catch (SQLException e) {
	    throw new DAOException("Creating Event exception", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO#updateEvent(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event)
     */
    @Override
    public void updateEvent(Event event) {
	if (event == null || event.getName() == null || event.getName().isEmpty() || event.getAuditorium() == null || event.getDate() == null || event.getStartTime() == null || event.getEndTime() == null) {
	    throw new IllegalArgumentException("Invalid Event object");
	}
	
	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_EVENT)) {
	    ps.setString(1, event.getName());
	    ps.setLong(2, event.getAuditorium().getId());
	    ps.setDate(3, Date.valueOf(event.getDate()));
	    ps.setTime(4, Time.valueOf(event.getStartTime()));
	    ps.setTime(5, Time.valueOf(event.getEndTime()));
	    ps.setLong(6, event.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new DAOException("Error during event update", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO#removeEvent(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event)
     */
    @Override
    public void removeEvent(Event event) {
	if (event == null) {
	    throw new IllegalArgumentException("Invalid Event object");
	}
	
	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_EVENT)) {
	    ps.setLong(1, event.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new DAOException("Error during Event delete", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO#getEvent(long)
     */
    @Override
    public Event getEvent(long id) {
	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_EVENT_BY_ID)) {
	    ps.setLong(1, id);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return createEvent(rs);
		}
	    }

	} catch (SQLException e) {
	    throw new DAOException("Error during Event executing", e);
	}
	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO#getEvent(java.lang.String)
     */
    @Override
    public Event getEvent(String name) {
	if (name == null || name.isEmpty()) {
	    throw new IllegalArgumentException("Invalid name");
	}

	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_EVENT_BY_NAME)) {
	    ps.setString(1, name);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return createEvent(rs);
		}
	    }

	} catch (SQLException e) {
	    throw new DAOException("Error during Event executing", e);
	}

	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO#getEvents()
     */
    @Override
    public List<Event> getEvents() {
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_EVENTS);
		ResultSet rs = ps.executeQuery()) {
	    List<Event> users = new ArrayList<>();

	    while (rs.next()) {
		users.add(createEvent(rs));
	    }

	    return users.isEmpty() ? null : users;
	} catch (SQLException e) {
	    throw new DAOException("Error during Events executing", e);
	}
    }
    
    /**
     * Create Event object
     * @param rs {@link ResultSet}
     * @return {@link Event}
     * @throws SQLException if error occured
     */
    private Event createEvent(ResultSet rs) throws SQLException {
	Event event = new Event();
	
	event.setId(rs.getLong("EVENTS.ID"));
	event.setName(rs.getString("EVENTS.NAME"));
	
	Auditorium auditorium = new Auditorium();
	auditorium.setId(rs.getLong("AUDITORIUMS.ID"));
	auditorium.setName(rs.getString("AUDITORIUMS.NAME"));
	event.setAuditorium(auditorium);
	
	event.setDate(rs.getDate("EVENTS.DATE").toLocalDate());
	event.setStartTime(rs.getTime("EVENTS.START_TIME").toLocalTime());
	event.setEndTime(rs.getTime("EVENTS.END_TIME").toLocalTime());
	
	return event;
    }
}
