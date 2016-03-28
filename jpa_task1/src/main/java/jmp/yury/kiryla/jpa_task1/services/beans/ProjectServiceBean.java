/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.services.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.Project;
import jmp.yury.kiryla.jpa_task1.services.ProjectService;

/**
 * {@link ProjectService} implementation
 * 
 * @author Yury_Kiryla
 *
 */
public class ProjectServiceBean implements ProjectService {

	/**
	 * {@link EntityManager}
	 */
	private EntityManager em;

	/**
	 * @param em
	 */
	public ProjectServiceBean(EntityManager em) {
		super();
		this.em = em;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.ProjectService#create(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Project create(String name, String description) {
		if (name != null) {
			Project project = new Project();
			project.setName(name);
			project.setDescription(description);
			em.persist(project);
			return project;
		}
		return null;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.ProjectService#find(long)
	 */
	@Override
	public Project find(long id) {
		Project project = em.find(Project.class, id);

		return project;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.ProjectService#delete(long)
	 */
	@Override
	public Project delete(long id) {
		Project project = em.find(Project.class, id);

		if (project != null) {
			em.remove(project);
		}
		return project;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.ProjectService#update(jmp.yury.kiryla.jpa_task1.beans.Project)
	 */
	@Override
	public void update(Project project) {
		em.merge(project);
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.ProjectService#assignEmployee(long,
	 *      long)
	 */
	@Override
	public void assignEmployee(long projectId, long employeeId) {
		Project project = em.find(Project.class, projectId);
		Employee employee = em.find(Employee.class, employeeId);
		if (project != null && employee != null) {
			List<Project> projects = employee.getProjects();
			if (projects == null) {
				projects = new ArrayList<>();
				employee.setProjects(projects);
			}
			projects.add(project);

			List<Employee> employees = project.getEmployees();
			if (employees == null) {
				employees = new ArrayList<>();
				project.setEmployees(employees);
			}
			employees.add(employee);
		}
	}

}
