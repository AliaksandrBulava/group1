package jmp.yury.kiryla.infrastructure_build_maven_gradle.services;

import java.util.List;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Auditorium;

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
}
