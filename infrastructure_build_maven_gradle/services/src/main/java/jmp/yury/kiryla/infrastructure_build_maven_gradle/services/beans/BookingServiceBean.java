/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.services.beans;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Ticket;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.BookingService;

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
     * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.services.BookingService#bookTicket(jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User, jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event)
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

}
