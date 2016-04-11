/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.services.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmp.yury.kiryla.jpa_task1.beans.Address;
import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.EmployeePersonalInfo;
import jmp.yury.kiryla.jpa_task1.beans.EmployeeStatus;
import jmp.yury.kiryla.jpa_task1.services.EmployeeService;

/**
 * {@link EmployeeService} implementation
 * 
 * @author Yury_Kiryla
 *
 */
@Service
public class EmployeeServiceBean implements EmployeeService {
	/**
	 * {@link EntityManager}
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.EmployeeService#create(jmp.yury.kiryla.jpa_task1.beans.EmployeePersonalInfo,
	 *      jmp.yury.kiryla.jpa_task1.beans.Address)
	 */
	@Override
	@Transactional
	public Employee create(EmployeePersonalInfo personalInfo, Address address) {
		if (personalInfo != null && address != null) {
			Employee employee = new Employee();
			employee.setAddress(address);
			employee.setPersonalInfo(personalInfo);
			employee.setStatus(EmployeeStatus.NEW);

			em.persist(employee);

			return employee;
		}
		return null;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.EmployeeService#find(long)
	 */
	@Override
	public Employee find(long id) {
		return em.find(Employee.class, id);
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.EmployeeService#delete(long)
	 */
	@Override
	@Transactional
	public Employee delete(long id) {
		Employee employee = find(id);
		if (employee != null) {
			em.remove(employee);
		}
		return employee;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.EmployeeService#update(jmp.yury.kiryla.jpa_task1.beans.Employee)
	 */
	@Override
	@Transactional
	public void update(Employee employee) {
		if (employee != null) {
			em.merge(employee);
		}
	}
}
