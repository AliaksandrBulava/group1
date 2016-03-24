/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.List;

/**
 * Unit
 * 
 * @author Yury_Kiryla
 *
 */
public class Unit {
	
	/**
	 * ID
	 */
	private long id;
	
	/**
	 * Name
	 */
	private String name;
	
	/**
	 * {@link Employee}s
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
