/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao;

import java.util.List;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;

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
    public void saveUser(User user);
    
    /**
     * Update existed user
     * @param user the {@link User} object
     */
    public void updateUser(User user);
    
    /**
     * Remove existed user
     * @param user the {@link User} object
     */
    public void removeUser(User user);
    
    /**
     * Get User by id
     * @param id ID value
     * @return {@link User}
     */
    public User getUser(long id);
    
    /**
     * Get User by name
     * @param name Name
     * @return {@link User}
     */
    public User getUser(String name);
    
    /**
     * Get all Users
     * @return {@link User}s list
     */
    public List<User> getUsers();
}
