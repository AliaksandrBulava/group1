/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.web;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.AuditoriumService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.BookingService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.EventService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.UserService;

/**
 * Web application constants
 * 
 * @author Yury_Kiryla
 *
 */
public interface Constants {
	/**
	 * For get {@link UserService} from context
	 */
	public static final String USER_SERVICE = "userService";
	
	/**
	 * For get {@link EventService} from context
	 */
	public static final String EVENT_SERVICE = "eventService";
	
	/**
	 * For get {@link AuditoriumService} from context
	 */
	public static final String AUDITORIUM_SERVICE = "auditoriumService";
	
	/**
	 * For get {@link BookingService} from context
	 */
	public static final String BOOKING_SERVICE = "bookingService";
}
