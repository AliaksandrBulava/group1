/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Unit
 * 
 * @author Yury_Kiryla
 *
 */
@Entity
@Table(name="t_unit", schema="s_jpa")
public class Unit {
	
	/**
	 * ID
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * Name
	 */
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	/**
	 * {@link Employee}s
	 */
	@OneToMany
	@JoinColumn(name="unit_id")
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
