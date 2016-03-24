/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.Date;

/**
 * Employee Personal Info
 * 
 * @author Yury_Kiryla
 *
 */
public class EmployeePersonalInfo {

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
	 * Birthday
	 */
	private Date birthday;

	/**
	 * @return the id
	 */
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
}
