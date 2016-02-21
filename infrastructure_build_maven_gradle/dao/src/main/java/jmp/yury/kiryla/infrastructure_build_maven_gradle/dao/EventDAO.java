/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.dao;

import java.util.List;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event;

/**
 * Event DAO
 * 
 * @author Yury
 *
 */
public interface EventDAO {
    /**
     * Save new Event
     * 
     * @param event the {@link Event} object
     */
    public void saveEvent(Event event);
    
    /**
     * Update existed Event
     * @param event the {@link Event} object
     */
    public void updateEvent(Event event);
    
    /**
     * Remove existed Event
     * @param event the {@link Event} object
     */
    public void removeEvent(Event event);
    
    /**
     * Get Event by id
     * @param id ID value
     * @return {@link Event}
     */
    public Event getEvent(long id);
    
    /**
     * Get Event by name
     * @param name Name
     * @return {@link Event}
     */
    public Event getEvents(String name);
    
    /**
     * Get all Events
     * @return {@link Event}s list
     */
    public List<Event> getEvents();
}
