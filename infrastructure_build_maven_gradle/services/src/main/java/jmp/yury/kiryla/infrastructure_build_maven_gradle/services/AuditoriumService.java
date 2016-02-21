package jmp.yury.kiryla.infrastructure_build_maven_gradle.services;

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
}
