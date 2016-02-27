/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event;

/**
 * {@link Event} service
 * 
 * @author Yury
 *
 */
public interface EventService {
    
    /**
     * Register new Event
     * @param name Event's name
     * @param auditorium {@link Auditorium}
     * @param date Date
     * @param startTime Start Time
     * @param endTime End Time
     * @return {@link Event} object
     */
    public Event register(String name, Auditorium auditorium, LocalDate date, LocalTime startTime, LocalTime endTime);
    
    /**
     * Delete Event
     * @param event {@link Event}
     */
    public void delete(Event event);
    
    /**
     * Get all events
     * @return {@link Event} list
     */
    public List<Event> getAll();
    
    /**
     * Get event by id
     * @param id ID
     * @return {@link Event}
     */
    public Event get(long id);
}
