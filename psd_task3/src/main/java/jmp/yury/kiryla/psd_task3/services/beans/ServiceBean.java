/**
 * 
 */
package jmp.yury.kiryla.psd_task3.services.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jmp.yury.kiryla.psd_task3.beans.Event;
import jmp.yury.kiryla.psd_task3.beans.User;
import jmp.yury.kiryla.psd_task3.services.EventService;
import jmp.yury.kiryla.psd_task3.services.UserService;

/**
 * Service Bean
 * 
 * @author Yury
 *
 */
public class ServiceBean implements UserService, EventService {
    /**
     * Events
     */
    private static Set<Event> events = new HashSet<Event>();
    
    /**
     * counter
     */
    private static long counter = 1;
    
    /**
     * Events assigned to users
     */
    private static Map<User, Set<Event>> assignedEvents = new HashMap<User, Set<Event>>();

    /**
     * @see jmp.yury.kiryla.psd_task3.services.EventService#register(jmp.yury.kiryla.psd_task3.beans.Event)
     */
    @Override
    public void register(Event event) {
	event.setId(counter++);
	events.add(event);
    }

    /**
     * @see jmp.yury.kiryla.psd_task3.services.UserService#register(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date)
     */
    @Override
    public User register(String firstName, String secondName, String middleName, String title, String gender,
	    String email, Date birthday) {
	User user = new User();
	user.setFirstName(firstName);
	user.setSecondName(secondName);
	user.setMiddleName(middleName);
	user.setTitle(title);
	user.setGender(gender);
	user.setEmail(email);
	user.setBirthday(birthday);
	User.create(user);
	return user;
    }

    /**
     * @see jmp.yury.kiryla.psd_task3.services.UserService#assignEvent(jmp.yury.kiryla.psd_task3.beans.User, jmp.yury.kiryla.psd_task3.beans.Event)
     */
    @Override
    public void assignEvent(User user, Event event) {
	Set<Event> events = assignedEvents.get(user);
	
	if (event == null){
	    events = new HashSet<Event>();
	    assignedEvents.put(user, events);
	}
	
	events.add(event);
	
	System.out.println(user.getGender() + " " + user.getFirstName() + " " + user.getSecondName() + " registered for " + event.getName());
    }

}
