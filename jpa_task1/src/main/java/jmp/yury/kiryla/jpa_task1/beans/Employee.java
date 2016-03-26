/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

/**
 * Employee
 * 
 * @author Yury_Kiryla
 *
 */
@Entity
@Table(name="t_employee", schema="s_jpa")
public class Employee {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * employee {@link Address}
	 */
	@Embedded
	private Address address;
	
	/**
	 * Employee Personal Info
	 * {@link EmployeePersonalInfo}
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="persinfo_id", nullable=false)
	private EmployeePersonalInfo personalInfo;
	
	/**
	 * {@link EmployeeStatus}
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private EmployeeStatus status;
	
	/**
	 * The Employee's {@link Project}s
	 */
	@ManyToMany
	@JoinTable(name="emploee_project", schema="s_jpa", joinColumns=@JoinColumn(name="emploee_id"), inverseJoinColumns = @JoinColumn(name="project_id"))
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

	/**
	 * @return the status
	 */
	public EmployeeStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("employee:");
	    if (personalInfo != null) {
		sb.append(personalInfo.getFirstName() + " " + personalInfo.getLastName());
		sb.append("Birthday: " + personalInfo.getBirthday());
	    }
	    
	    if (address != null) {
		sb.append("Address: ");
		sb.append(address.getCountry() + ", ");
		if (StringUtils.isNotBlank(address.getState())) {
		    sb.append(address.getState() + ", ");
		}
		sb.append(address.getCity());
		if (StringUtils.isNoneBlank(address.getStreet(), address.getHome())) {
		    sb.append(", " + address.getStreet() + ", " + address.getHome());
		}
		sb.append("Status: " + status);
		if (projects != null && !projects.isEmpty()) {
		    sb.append("Projects:");
		    for (Project project : projects) {
			sb.append(project.getName());
		    }
		}
		if (unit != null) {
		    sb.append("Unit: " + unit.getName());
		}
	    }
	    
	    return sb.toString();
	}
	
	
}
