/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.List;

/**
 * Employee
 * 
 * @author Yury_Kiryla
 *
 */
public class Employee {
	/**
	 * ID
	 */
	private long id;
	
	/**
	 * employee {@link Address}
	 */
	private Address address;
	
	/**
	 * Employee Personal Info
	 * {@link EmployeePersonalInfo}
	 */
	private EmployeePersonalInfo personalInfo;
	
	/**
	 * The Employee's {@link Project}s
	 */
	private List<Project> projects;
	
	/**
	 * {@link Employee}'s {@link Unit}
	 */
	private Unit unit;

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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the personalInfo
	 */
	public EmployeePersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	/**
	 * @param personalInfo the personalInfo to set
	 */
	public void setPersonalInfo(EmployeePersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
