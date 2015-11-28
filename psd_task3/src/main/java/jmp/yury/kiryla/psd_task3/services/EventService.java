/**
 * 
 */
package jmp.yury.kiryla.psd_task3.services;

import jmp.yury.kiryla.psd_task3.beans.Event;

/**
 * Event Service
 * 
 * @author Yury
 *
 */
public interface EventService {

    /**
     * register new event
     * @param event the {@link Event} object
     */
    public void register(Event event);
}
