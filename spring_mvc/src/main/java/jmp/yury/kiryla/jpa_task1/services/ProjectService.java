/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.services;

import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.Project;

/**
 * {@link Project} service
 * 
 * @author Yury_Kiryla
 *
 */
public interface ProjectService {
	/**
	 * Create new Project
	 * @param name Project's name
	 * @param description Project's description (can be <code>null</code>)
	 * @return {@link Project}
	 */
	public Project create(String name, String description);
	
	/**
	 * Search Project 
	 * @param id ID
	 * @return {@link Project}
	 */
	public Project find(long id);
	
	/**
	 * Delete Project
	 * @param id ID
	 * @return {@link Project} which was deleted, <code>null</code> if Project does not exist
	 */
	public Project delete(long id);
	
	/**
	 * Update project
	 * @param project {@link Project}
	 */
	public void update(Project project);
	
	/**
	 * Assign {@link Employee} for {@link Project} by id’s
	 * @param projectId {@link Project}'s id
	 * @param employeeId {@link Employee}'s id
	 */
	public void assignEmployee(long projectId, long employeeId);
}
