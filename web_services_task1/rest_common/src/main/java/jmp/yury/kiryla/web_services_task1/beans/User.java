/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User Bean
 * 
 * @author Yury_Kiryla
 *
 */
@XmlRootElement(name="user")
public class User {

    /**
     * ID
     */
    private long id;

    /**
     * First Name
     */
    private String firstName;

    /**
     * Last Name
     */
    private String lastName;

    /**
     * Login
     */
    private String login;

    /**
     * Email address
     */
    private String email;

    /**
     * @return the id
     */
    @XmlAttribute(required=false)
    public long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * @return the firstName
     */
    @XmlElement(required=true)
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
     * @return the lastName
     */
    @XmlElement(required=true)
    public String getLastName() {
	return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /**
     * @return the login
     */
    @XmlElement(required=true)
    public String getLogin() {
	return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {
	this.login = login;
    }

    /**
     * @return the email
     */
    @XmlElement(required=true)
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

}
