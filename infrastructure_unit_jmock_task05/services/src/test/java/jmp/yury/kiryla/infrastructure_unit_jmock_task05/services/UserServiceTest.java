/**
 * 
 */
package jmp.yury.kiryla.infrastructure_unit_jmock_task05.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.UserDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans.UserServiceBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Matchers.any;

/**
 * Test for {@link UserService}
 * 
 * @author Yury
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
    /**
     * {@link UserDAO}
     */
    @Mock
    private UserDAO userDAO;
    
    /**
     * {@link UserService}
     */
    @InjectMocks
    private UserService userService = new UserServiceBean(userDAO);
    
    /**
     * Test {@link UserService#register(String)} method
     * @throws Exception if any exception occurred
     */
    @Test
    public void testRegistration() throws Exception {
	String name = "Test";
	
	doNothing().when(userDAO).saveUser(any(User.class));
	
	User user = userService.register(name);
	
	assertEquals(name, user.getName());
    }
    
    /**
     * Test {@link UserService#delete(User)} method
     * @throws Exception if any exception occurred
     */
    @Test
    public void testDelete() throws Exception {
	User user = mock(User.class);
	
	doNothing().when(userDAO).removeUser(any(User.class));
	
	userService.delete(user);
	
	verify(userDAO).removeUser(user);
    }
    
    /**
     * Test {@link UserService#searchUser(String)} method
     * @throws Exception if any exception occurred
     */
    @Test
    public void testSearchUser() throws Exception {
	String name = "test";
	
	User user = mock(User.class);
	user.setName(name);
	
	when(userDAO.getUser(name)).thenReturn(user);
	
	assertSame(user, userService.searchUser(name));
    }
}
