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
    public void save(Event event);
    
    /**
     * Update existed Event
     * @param event the {@link Event} object
     */
    public void update(Event event);
    
    /**
     * Remove existed Event
     * @param event the {@link Event} object
     */
    public void remove(Event event);
    
    /**
     * Get Event by id
     * @param id ID value
     * @return {@link Event}
     */
    public Event get(long id);
    
    /**
     * Get Event by name
     * @param name Name
     * @return {@link Event}
     */
    public Event get(String name);
    
    /**
     * Get all Events
     * @return {@link Event}s list
     */
    public List<Event> get();
}
