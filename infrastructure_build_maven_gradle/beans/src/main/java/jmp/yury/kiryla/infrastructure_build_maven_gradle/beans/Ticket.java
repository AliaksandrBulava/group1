/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.beans;

/**
 * Ticket bean
 * 
 * @author Yury
 *
 */
public class Ticket {

    /**
     * ID
     */
    private long id;
    
    /**
     * {@link User}
     */
    private User user;
    
    /**
     * {@link Auditorium}
     */
    private Event event;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Ticket [id=" + id + ", user=" + user + ", event=" + event + "]";
    }
}
