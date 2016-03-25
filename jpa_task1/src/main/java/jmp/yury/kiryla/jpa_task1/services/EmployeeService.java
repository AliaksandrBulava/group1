/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.services;

import jmp.yury.kiryla.jpa_task1.beans.Address;
import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.EmployeePersonalInfo;

/**
 * Employee Service
 * 
 * @author Yury_Kiryla
 *
 */
public interface EmployeeService {
	/**
	 * Create new Employee
	 * @param personalInfo {@link EmployeePersonalInfo} object
	 * @param address employee {@link Address} object
	 * @return {@link Employee}
	 */
	public Employee create(EmployeePersonalInfo personalInfo, Address address);
	
	/**
	 * Search Employee by id
	 * @param id ID
	 * @return {@link Employee}
	 */
	public Employee find(long id);
	
	/**
	 * Delete employee
	 * @param id ID
	 * @return {@link Employee} which was deleted, <code>null</code> if employee does not exist
	 */
	public Employee delete(long id);
	
	/**
	 * Update existing employee
	 * @param employee {@link Employee}
	 */
	public void update(Employee employee);
}
