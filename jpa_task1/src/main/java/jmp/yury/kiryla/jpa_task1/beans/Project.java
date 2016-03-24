/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.List;

/**
 * Project
 * 
 * @author Yury_Kiryla
 *
 */
public class Project {
	
	/**
	 * ID
	 */
	private long id;

	/**
	 * Project Name
	 */
	private String name;
	
	/**
	 * Project Description
	 */
	private String description;
	
	/**
	 * {@link Employee}s assigned to the project
	 */
	private List<Employee> employees;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
