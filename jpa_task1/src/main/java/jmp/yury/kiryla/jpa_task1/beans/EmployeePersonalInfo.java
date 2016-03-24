/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employee Personal Info
 * 
 * @author Yury_Kiryla
 *
 */
@Entity
public class EmployeePersonalInfo {

	/**
	 * ID
	 */
	@Id
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
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	/**
	 * {@link Employee}
	 */
	@OneToOne()
	private Employee employee;

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
