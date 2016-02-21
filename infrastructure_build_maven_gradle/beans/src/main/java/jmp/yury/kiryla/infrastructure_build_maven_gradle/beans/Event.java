/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.beans;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Event bean
 * 
 * @author Yury
 *
 */
public class Event {
    
    /**
     * ID
     */
    private long id;

    /**
     * Name
     */
    private String name;

    /**
     * {@link Auditorium}
     */
    private Auditorium auditorium;
    
    /**
     * Date
     */
    private LocalDate date;
    
    /**
     * time
     */
    private LocalTime time;
    
    /**
     * duration
     */
    private Duration duration;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the auditorium
     */
    public Auditorium getAuditorium() {
        return auditorium;
    }

    /**
     * @param auditorium the auditorium to set
     */
    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * @return the duration
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Event [name=" + name + ", auditorium=" + auditorium + ", date=" + date + ", time=" + time
		+ ", duration=" + duration + "]";
    }
    
    
}
