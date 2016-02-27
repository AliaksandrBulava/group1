/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.services;

import java.util.List;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Ticket;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;

/**
 * Booking Service
 * 
 * @author Yury
 *
 */
public interface BookingService {
    
    /**
     * Book ticket
     * @param user {@link User}
     * @param event {@link Event}
     * @return {@link Ticket}
     */
    public Ticket bookTicket(User user, Event event);
    
    /**
     * Get tickets for requested user
     * @param user {@link User}
     * @return {@link Ticket} list
     */
    public List<Ticket> get(User user);
}
