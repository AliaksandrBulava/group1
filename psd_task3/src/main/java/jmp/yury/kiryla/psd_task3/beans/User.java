/**
 * 
 */
package jmp.yury.kiryla.psd_task3.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User Bean
 * 
 * @author Yury
 *
 */
public class User {
    /**
     * id
     */
    private long id;

    /**
     * First name
     */
    private String firstName;

    /**
     * Second Name
     */
    private String secondName;

    /**
     * Middle name
     */
    private String middleName;

    /**
     * Title
     */
    private String title;

    /**
     * Gender
     */
    private String gender;

    /**
     * Email address
     */
    private String email;

    /**
     * Birthday date
     */
    private Date birthday;

    /**
     * for store users
     */
    private static Set<User> users = new HashSet<User>();

    /**
     * Users counter
     */
    private static long counter = 0;

    /**
     * @return the firstName
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * @return the secondName
     */
    public String getSecondName() {
	return secondName;
    }

    /**
     * @param secondName
     *            the secondName to set
     */
    public void setSecondName(String secondName) {
	this.secondName = secondName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
	return middleName;
    }

    /**
     * @param middleName
     *            the middleName to set
     */
    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return the gender
     */
    public String getGender() {
	return gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(String gender) {
	this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
	return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof User)) {
	    return false;
	}
	User other = (User) obj;
	if (id != other.id) {
	    return false;
	}
	return true;
    }

    /**
     * Add new User
     * 
     * @param user
     *            the {@link User} object
     */
    public static void create(User user) {
	user.id = ++counter;
	users.add(user);
    }

    /**
     * Remove requested user
     * 
     * @param user
     *            the {@link User} object
     */
    public static void remove(User user) {
	users.remove(user);
    }
}
