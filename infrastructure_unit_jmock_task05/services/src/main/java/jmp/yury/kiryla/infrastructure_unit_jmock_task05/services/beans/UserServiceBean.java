/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.UserDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.UserService;

/**
 * {@link UserService} implementation
 * 
 * @author Yury
 *
 */
public class UserServiceBean implements UserService {
    /**
     * {@link UserDAO}
     */
    private UserDAO userDAO;

    /** 
     * @param userDAO {@link UserDAO}
     */
    public UserServiceBean(UserDAO userDAO) {
	super();
	this.userDAO = userDAO;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.UserService#register(java.lang.String)
     */
    @Override
    public User register(String name) {
	if (name != null && !name.isEmpty() && userDAO.getUser(name) == null) {
	    User user = new User();
	    user.setName(name);
	    userDAO.saveUser(user);
	    return user;
	}
	return null;
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.UserService#delete(jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User)
     */
    @Override
    public void delete(User user) {
	if (user != null) {
	    userDAO.removeUser(user);
	}
    }

    /**
     * @see jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.UserService#searchUser(java.lang.String)
     */
    @Override
    public User searchUser(String name) {
	if (name != null && !name.isEmpty()) {
	    return userDAO.getUser(name);
	}
	return null;
    }    
}
