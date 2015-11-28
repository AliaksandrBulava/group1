/**
 * 
 */
package jmp.yury.kiryla.psd_task3.services;

import java.util.Date;

import jmp.yury.kiryla.psd_task3.beans.Event;
import jmp.yury.kiryla.psd_task3.beans.User;

/**
 * User service
 * 
 * @author Yury
 *
 */
public interface UserService {
    /**
     * Register new user
     * @param firstName First name
     * @param secondName second name
     * @param middleName middle name
     * @param title title
     * @param gender gender
     * @param email email
     * @param birthday birthday
     */
    public void register(String firstName, String secondName, String middleName, String title, String gender, 
	    String email, Date birthday);
    
    /**
     * Assign Event to user
     * @param user the {@link User}
     * @param event the {@link Event}
     */
    public void assignEvent(User user, Event event);
}
