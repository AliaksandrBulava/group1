/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans;

import java.util.List;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Ticket;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.TicketDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.BookingService;

/**
 * @author Yury
 *
 */
public class BookingServiceBean implements BookingService {
    
    /**
     * {@link TicketDAO}
     */
    private TicketDAO ticketDAO;

    /**
     * @param ticketDAO
     */
    public BookingServiceBean(TicketDAO ticketDAO) {
	super();
	this.ticketDAO = ticketDAO;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.BookingService#bookTicket(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User, jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event)
     */
    @Override
    public Ticket bookTicket(User user, Event event) {
	if (user != null && event != null) {
	    Ticket ticket = new Ticket();
	    ticket.setUser(user);
	    ticket.setEvent(event);
	    ticketDAO.saveTicket(ticket);
	    return ticket;
	}
	return null;
    }

	/**
	 * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.BookingService#get(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User)
	 */
	@Override
	public List<Ticket> get(User user) {
		if (user != null) {
			return ticketDAO.getTickets(user);
		}
		return null;
	}

    
}
