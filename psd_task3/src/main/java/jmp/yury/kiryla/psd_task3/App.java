/**
 * 
 */
package jmp.yury.kiryla.psd_task3;

import java.util.Date;

import jmp.yury.kiryla.psd_task3.beans.Event;
import jmp.yury.kiryla.psd_task3.beans.User;
import jmp.yury.kiryla.psd_task3.services.EventService;
import jmp.yury.kiryla.psd_task3.services.UserService;
import jmp.yury.kiryla.psd_task3.services.beans.ServiceBean;

/**
 * Main class
 * 
 * @author Yury
 *
 */
public class App {

    /**
     * short test
     * @param args
     */
    public static void main(String[] args) {
	ServiceBean serviceBean = new ServiceBean();
	
	UserService userService = serviceBean;
	User user = userService.register("Yury", "Kiryla", null, null, null, "test@test.com", null);
	
	EventService eventService = serviceBean;
	Event event = new Event();
	event.setName("Party");
	event.setDate(new Date());
	eventService.register(event);
	
	serviceBean.assignEvent(user, event);

    }

}
