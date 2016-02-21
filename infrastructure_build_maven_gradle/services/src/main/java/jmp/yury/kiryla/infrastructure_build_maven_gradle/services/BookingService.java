/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.services;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Ticket;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User;

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
}
