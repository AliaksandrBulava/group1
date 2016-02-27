/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao;

import java.util.List;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Ticket;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;

/**
 * Ticket DAO
 * 
 * @author Yury
 *
 */
public interface TicketDAO {
    /**
     * Save new Ticket
     * @param ticket the {@link Ticket} object
     */
    public void saveTicket(Ticket ticket);
    
    /**
     * Remove ticket
     * @param ticket the {@link Ticket} object
     */
    public void removeTicket(Ticket ticket);
    
    /**
     * Get ticket by id
     * @param id ID
     * @return {@link Ticket} object
     */
    public Ticket getTicket(long id);
    
    /**
     * Get all tickets
     * @return {@link Ticket} list
     */
    public List<Ticket> getTickets();
    
    /**
     * Get tickets for particular event
     * @param event the {@link Event} object
     * @return {@link Ticket} list
     */
    public List<Ticket> getTickets(Event event);
    
    /**
     * Get tickets for specific user
     * @param user the {@link User} object
     * @return {@link Ticket} list
     */
    public List<Ticket> getTickets(User user);
}
