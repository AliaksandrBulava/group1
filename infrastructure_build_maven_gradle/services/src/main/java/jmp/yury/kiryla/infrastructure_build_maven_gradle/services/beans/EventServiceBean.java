/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.services.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Auditorium;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.EventDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.EventService;

/**
 * {@link EventService} implementation
 * 
 * @author Yury
 *
 */
public class EventServiceBean implements EventService {
	/**
	 * {@link EventDAO}
	 */
	private EventDAO eventDAO;

	/**
	 * @param eventDAO
	 */
	public EventServiceBean(EventDAO eventDAO) {
		super();
		this.eventDAO = eventDAO;
	}

	/**
	 * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.services.EventService#register(java.lang.String,
	 *      jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Auditorium,
	 *      java.time.LocalDate, java.time.LocalTime, java.time.LocalTime)
	 */
	@Override
	public Event register(String name, Auditorium auditorium, LocalDate date, LocalTime startTime, LocalTime endTime) {
		if (name != null && !name.isEmpty() && auditorium != null && date != null && startTime != null
				&& endTime != null && isAuditoriumFree(auditorium, date, startTime, endTime)) {
			Event event = new Event();

			event.setName(name);
			event.setAuditorium(auditorium);
			event.setDate(date);
			event.setStartTime(startTime);
			event.setEndTime(endTime);

			eventDAO.saveEvent(event);

			return event;

		}
		return null;
	}

	/**
	 * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.services.EventService#
	 *      delete(jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.Event)
	 */
	@Override
	public void delete(Event event) {
		if (event != null) {
			eventDAO.removeEvent(event);
		}
	}

	/**
	 * Check if auditorium is free on requested date-time
	 * 
	 * @param auditorium
	 *            {@link Auditorium}
	 * @param date
	 *            Date
	 * @param startTime
	 *            Start Time
	 * @param endTime
	 *            End Time
	 * @return <code>true</code> if auditorium available
	 */
	private boolean isAuditoriumFree(Auditorium auditorium, LocalDate date, LocalTime startTime, LocalTime endTime) {
		List<Event> events = eventDAO.getEvents();
		if (events != null) {
			return !events.stream().anyMatch(event -> {
				if (event.getDate().isEqual(date)
						&& (startTime.isAfter(event.getStartTime()) && startTime.isBefore(event.getEndTime())
								|| (endTime.isAfter(event.getStartTime()) && endTime.isBefore(event.getEndTime())))) {
					return true;
				}
				return false;
			});
		} else {
			return false;
		}
	}

	/**
	 * @see jmp.yury.kiryla.infrastructure_build_maven_gradle.services.EventService#getAll()
	 */
	@Override
	public List<Event> getAll() {
		return eventDAO.getEvents();
	}
	
	
}
