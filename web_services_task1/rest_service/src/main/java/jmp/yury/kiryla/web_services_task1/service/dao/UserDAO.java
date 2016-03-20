/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.service.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import jmp.yury.kiryla.web_services_task1.beans.User;

/**
 * User DAO
 * 
 * @author Yury_Kiryla
 *
 */
public interface UserDAO {
	/**
	 * Create new User
	 * @param user the {@link User} object
	 */
	public void create(User user);
	
	/**
	 * Get User by Id
	 * @param id ID
	 */
	public User getUserById(long id);
	
	/**
	 * Get All Users
	 * @return {@link User}s list
	 */
	public List<User> getAll();
	
	/**
	 * Update existing User
	 * @param user the {@link User} object
	 */
	public void update(User user);
	
	/**
	 * Delete existing User
	 * @param user the {@link User} object
	 */
	public void delete(User user);
	
	/**
	 * Add logo to user
	 * @param is {@link InputStream} object
	 * @param filename File name
	 * @param user {@link User} object
	 */
	public void addLogo(InputStream is, String filename, User user);
	
	/**
	 * Get logo for user
	 * @param user {@link User} object
	 * @return Filename/InputStream objects
	 */
	public Map.Entry<String, InputStream> getLogo(User user);
}
