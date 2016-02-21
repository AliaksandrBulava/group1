/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.dao;

import java.util.List;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Auditorium;

/**
 * {@link Auditorium} DAO
 * 
 * @author Yury
 *
 */
public interface AuditoriumDAO {
    
    /**
     * Add new Auditorium
     * @param auditorium {@link Auditorium}
     */
    public void saveAuditorium(Auditorium auditorium);
    
    /**
     * Update Auditorium
     * @param auditorium the {@link Auditorium} object
     */
    public void updateAuditorium(Auditorium auditorium);
    
    /**
     * Remove Auditorium
     * @param auditorium {@link Auditorium} object
     */
    public void removeAuditorium(Auditorium auditorium);
    
    /**
     * Get Auditorium by id
     * @param id ID
     * @return {@link Auditorium}
     */
    public Auditorium getAuditorium(long id);
    
    /**
     * Get Auditorium by name
     * @param name Auditorium's name
     * @return {@link Auditorium} object
     */
    public Auditorium getAuditorium(String name);
    
    /**
     * Get all Auditoriums
     * @return {@link Auditorium}s list
     */
    public List<Auditorium> getAuditoriums();
}
