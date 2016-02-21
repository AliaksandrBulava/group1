/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.dao;

import java.util.List;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User;

/**
 * User DAO
 * 
 * @author Yury
 *
 */
public interface UserDAO {
    /**
     * Save new user
     * 
     * @param user the {@link User} object
     */
    public void save(User user);
    
    /**
     * Update existed user
     * @param user the {@link User} object
     */
    public void update(User user);
    
    /**
     * Remove existed user
     * @param user the {@link User} object
     */
    public void remove(User user);
    
    /**
     * Get User by id
     * @param id ID value
     * @return {@link User}
     */
    public User get(long id);
    
    /**
     * Get User by name
     * @param name Name
     * @return {@link User}
     */
    public User get(String name);
    
    /**
     * Get all Users
     * @return {@link User}s list
     */
    public List<User> get();
}
