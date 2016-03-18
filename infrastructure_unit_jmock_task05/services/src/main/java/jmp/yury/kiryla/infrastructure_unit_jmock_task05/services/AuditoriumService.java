package jmp.yury.kiryla.infrastructure_unit_jmock_task05.services;

import java.util.List;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Auditorium;

/**
 * {@link Auditorium} service
 * 
 * @author Yury
 *
 */
public interface AuditoriumService {
    
    /**
     * Register new {@link Auditorium}
     * @param name Name
     * @return {@link Auditorium}
     */
    public Auditorium register(String name);
    
    /**
     * Gel all Auditoriums
     * @return {@link Auditorium} list
     */
    public List<Auditorium> getAll();
    
    /**
     * Get auditorium by id
     * @param id ID
     * @return {@link Auditorium}
     */
    public Auditorium get(long id);
}
