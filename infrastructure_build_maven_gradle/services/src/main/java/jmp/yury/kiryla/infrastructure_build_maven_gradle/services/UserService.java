/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.services;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User;

/**
 * User service
 * 
 * @author Yury
 *
 */
public interface UserService {
    /**
     * Register new User
     * @param name Name
     * @return {@link User} object
     */
    public User register(String name);
    
    /**
     * Delete user
     * @param user the {@link User}
     */
    public void delete(User user);
    
    /**
     * Search user by name
     * @param name Name
     * @return {@link User}
     */
    public User searchUser(String name);
}
