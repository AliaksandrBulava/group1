/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

/**
 * Project
 * 
 * @author Yury_Kiryla
 *
 */
@Entity
@Table(name = "t_project", schema = "s_jpa")
public class Project {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue
	private long id;

	/**
	 * Project Name
	 */
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	/**
	 * Project Description
	 */
	@Column(name = "description", length = 2000)
	private String description;

	/**
	 * {@link Employee}s assigned to the project
	 */
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param description
	 *            the description to set
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
	 * @param employees
	 *            the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("project:");

		sb.append("\n\tid:\t\t" + id);
		sb.append("\n\tname:\t\t" + name);
		if (StringUtils.isNotBlank(description)) {
			sb.append("\n\tdescription:\t" + description);
		}
		if (employees != null && !employees.isEmpty()) {
			sb.append("\n\temployees:");
			for (Employee employee : employees) {
				sb.append("\n\t\t" + employee.getPersonalInfo().getFirstName() + " "
						+ employee.getPersonalInfo().getLastName());
			}
		}

		return sb.toString();
	}

}
