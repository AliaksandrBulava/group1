/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Auditorium;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Ticket;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.exceptions.DAOException;

/**
 * {@link TicketDAO}'s JDBC implementation
 * 
 * @author Yury
 *
 */
public class TicketJdbcDAO extends AbstractJdbcDAO implements TicketDAO {
    /**
     * {@link TicketJdbcDAO} instance
     */
    private static TicketJdbcDAO instance = null;
    
    /**
     * insert ticket statement
     */
    private static final String INSERT_TICKET = "INSERT INTO TICKETS(USER_ID,EVENT_ID) VALUES (?,?)";
    
    /**
     * delete ticket statement
     */
    private static final String DELETE_TICKET = "DELETE FROM TICKETS WHERE ID=?";
    
    /**
     * select ticket by id statement
     */
    private static final String SELECT_TICKET_BY_ID = "SELECT TICKETS.ID,USERS.ID,USERS.NAME,EVENTS.ID,EVENTS.NAME,AUDITORIUMS.ID,AUDITORIUMS.NAME,EVENTS.DATE,EVENTS.START_TIME,EVENTS.END_TIME FROM TICKETS,USERS,EVENTS,AUDITORIUMS WHERE TICKETS.ID=? AND TICKETS.USER_ID=USERS.ID AND TICKETS.EVENT_ID=EVENTS.ID AND EVENTS.AUDITORIUM_ID=AUDITORIUMS.ID";
    
    /**
     * select all tickets statement
     */
    private static final String SELECT_TICKETS = "SELECT TICKETS.ID,USERS.ID,USERS.NAME,EVENTS.ID,EVENTS.NAME,AUDITORIUMS.ID,AUDITORIUMS.NAME,EVENTS.DATE,EVENTS.START_TIME,EVENTS.END_TIME FROM TICKETS,USERS,EVENTS,AUDITORIUMS WHERE TICKETS.USER_ID=USERS.ID AND TICKETS.EVENT_ID=EVENTS.ID AND EVENTS.AUDITORIUM_ID=AUDITORIUMS.ID";
    
    /**
     * select tickets by event statement
     */
    private static final String SELECT_TICKETS_BY_EVENT = "SELECT TICKETS.ID,USERS.ID,USERS.NAME,EVENTS.ID,EVENTS.NAME,AUDITORIUMS.ID,AUDITORIUMS.NAME,EVENTS.DATE,EVENTS.START_TIME,EVENTS.END_TIME FROM TICKETS,USERS,EVENTS,AUDITORIUMS WHERE TICKETS.EVENT_ID=? AND TICKETS.USER_ID=USERS.ID AND TICKETS.EVENT_ID=EVENTS.ID AND EVENTS.AUDITORIUM_ID=AUDITORIUMS.ID";
    
    /**
     * select tickets by user statement
     */
    private static final String SELECT_TICKETS_BY_USER = "SELECT TICKETS.ID,USERS.ID,USERS.NAME,EVENTS.ID,EVENTS.NAME,AUDITORIUMS.ID,AUDITORIUMS.NAME,EVENTS.DATE,EVENTS.START_TIME,EVENTS.END_TIME FROM TICKETS,USERS,EVENTS,AUDITORIUMS WHERE TICKETS.USER_ID=? AND TICKETS.USER_ID=USERS.ID AND TICKETS.EVENT_ID=EVENTS.ID AND EVENTS.AUDITORIUM_ID=AUDITORIUMS.ID";
    
    /**
     * @param dataSource
     *            {@link DataSource} object
     */
    private TicketJdbcDAO(DataSource dataSource) {
	super(dataSource);
    }

    /**
     * Get {@link TicketJdbcDAO} instance
     * 
     * @param dataSource
     *            {@link DataSource} object
     * @return {@link TicketJdbcDAO}
     */
    public static synchronized TicketJdbcDAO getInstance(DataSource dataSource) {
	if (instance == null) {
	    instance = new TicketJdbcDAO(dataSource);
	}
	return instance;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO#saveTicket(jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Ticket)
     */
    @Override
    public void saveTicket(Ticket ticket) {
	if (ticket == null || ticket.getUser() == null || ticket.getEvent() == null) {
	    throw new IllegalArgumentException("Invalid User object");
	}
	
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT_TICKET, Statement.RETURN_GENERATED_KEYS)) {
	    ps.setLong(1, ticket.getUser().getId());
	    ps.setLong(2, ticket.getEvent().getId());

	    if (ps.executeUpdate() > 0) {
		try (ResultSet rs = ps.getGeneratedKeys()) {
		    if (rs.next()) {
			ticket.setId(rs.getLong(1));
		    } else {
			throw new DAOException("There is not id generated for Ticket");
		    }
		}
	    } else {
		throw new DAOException("Ticket user failed");
	    }
	} catch (SQLException e) {
	    throw new DAOException("Creating Ticket exception", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO#removeTicket(jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Ticket)
     */
    @Override
    public void removeTicket(Ticket ticket) {
	if (ticket == null) {
	    throw new IllegalArgumentException("Invalid ticket object");
	}

	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_TICKET)) {
	    ps.setLong(1, ticket.getId());
	    ps.execute();
	} catch (SQLException e) {
	    throw new DAOException("Error during ticket delete", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO#getTicket(long)
     */
    @Override
    public Ticket getTicket(long id) {
	try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_TICKET_BY_ID)) {
	    ps.setLong(1, id);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    return createTicket(rs);
		}
	    }

	} catch (SQLException e) {
	    throw new DAOException("Error during ticket executing", e);
	}
	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO#getTickets()
     */
    @Override
    public List<Ticket> getTickets() {
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_TICKETS);
		ResultSet rs = ps.executeQuery()) {
	    return createTicketList(rs);
	} catch (SQLException e) {
	    throw new DAOException("Error during tickets executing", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO#getTickets(jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event)
     */
    @Override
    public List<Ticket> getTickets(Event event) {
	if (event == null) {
	    throw new IllegalArgumentException("Invalid event object");
	}
	
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_TICKETS_BY_EVENT)) {
	    
	    ps.setLong(1, event.getId());
	    
	    try (ResultSet rs = ps.executeQuery()){
		return createTicketList(rs);
	    }
	} catch (SQLException e) {
	    throw new DAOException("Error during tickets executing", e);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO#getTickets(jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User)
     */
    @Override
    public List<Ticket> getTickets(User user) {
	if (user == null) {
	    throw new IllegalArgumentException("Invalid user object");
	}
	
	try (Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(SELECT_TICKETS_BY_USER)) {
	    
	    ps.setLong(1, user.getId());
	    
	    try (ResultSet rs = ps.executeQuery()){
		return createTicketList(rs);
	    }
	} catch (SQLException e) {
	    throw new DAOException("Error during tickets executing", e);
	}
    }
    
    /**
     * Create new Ticket object
     * @param rs {@link ResultSet}
     * @return {@link Ticket}
     * @throws SQLException if error occurred
     */
    private Ticket createTicket(ResultSet rs) throws SQLException {
	Ticket ticket = new Ticket();
	
	ticket.setId(rs.getLong("TICKETS.ID"));
	
	User user = new User();
	user.setId(rs.getLong("USERS.ID"));
	user.setName(rs.getString("USERS.NAME"));
	ticket.setUser(user);
	
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
	ticket.setEvent(event);
	
	return ticket;
    }
    
    /**
     * Create Tickets List
     * @param rs {@link ResultSet}
     * @return {@link Ticket} list
     * @throws SQLException if exception occurred
     */
    private List<Ticket> createTicketList(ResultSet rs) throws SQLException {
	List<Ticket> tickets = new ArrayList<>();
	
	while (rs.next()) {
	    tickets.add(createTicket(rs));
	}
	return tickets.isEmpty() ? null : tickets;
    }
}
