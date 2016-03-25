/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.services;

import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.Unit;

/**
 * Unit Service
 * 
 * @author Yury_Kiryla
 *
 */
public interface UnitService {
	/**
	 * Create new Unit
	 * @param name Unit's name
	 * @return {@link Unit}
	 */
	public Unit create(String name);
	
	/**
	 * Search Unit by id
	 * @param id ID
	 * @return {@link Unit}
	 */
	public Unit find(long id);
	
	/**
	 * Delete unit by id
	 * @param id ID
	 * @return {@link Unit} which was deleted, <code>null</code> if unit does not exist
	 */
	public Unit delete(long id);
	
	/**
	 * Update existing unit
	 * @param unit {@link Unit} object
	 */
	public void update(Unit unit);
	
	/**
	 * Add {@link Employee} to {@link Unit} by id’s
	 * @param unitId Unit's ID
	 * @param employeeId Employee's ID
	 */
	public void addEmployee(long unitId, long employeeId);
}
