/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.services;

import java.time.LocalDate;
import java.time.LocalTime;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Auditorium;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event;

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
}
