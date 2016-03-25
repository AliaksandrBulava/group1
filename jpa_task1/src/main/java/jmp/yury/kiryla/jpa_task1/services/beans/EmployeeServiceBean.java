/**
 * 
 */
package jmp.yury.kiryla.jpa_task1.services.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
public class EmployeeServiceBean implements EmployeeService {
	/**
	 * {@link EntityManager}
	 */
	private EntityManager em;

	/**
	 * @param em
	 */
	public EmployeeServiceBean(EntityManager em) {
		super();
		this.em = em;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.EmployeeService#create(jmp.yury.kiryla.jpa_task1.beans.EmployeePersonalInfo, jmp.yury.kiryla.jpa_task1.beans.Address)
	 */
	@Override
	public Employee create(EmployeePersonalInfo personalInfo, Address address) {
		if (personalInfo != null && address != null)
		{
			Employee employee = new Employee();
			employee.setAddress(address);
			employee.setPersonalInfo(personalInfo);
			employee.setStatus(EmployeeStatus.NEW);
			
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.persist(employee);
			tx.commit();
			
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
	public Employee delete(long id) {
		Employee employee = find(id);
		if (employee != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(employee);
			tx.commit();
		}
		return employee;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.EmployeeService#update(jmp.yury.kiryla.jpa_task1.beans.Employee)
	 */
	@Override
	public void update(Employee employee) {
		if (employee != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.refresh(employee);
			tx.commit();
		}
	}
}
