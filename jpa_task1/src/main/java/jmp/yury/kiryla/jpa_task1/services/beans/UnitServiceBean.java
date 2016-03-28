package jmp.yury.kiryla.jpa_task1.services.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.EmployeeStatus;
import jmp.yury.kiryla.jpa_task1.beans.Unit;
import jmp.yury.kiryla.jpa_task1.services.UnitService;

/**
 * {@link UnitService} implementation
 * 
 * @author Yury_Kiryla
 *
 */
public class UnitServiceBean implements UnitService {
	/**
	 * {@link EntityManager}
	 */
	private EntityManager em;

	/**
	 * @param em
	 */
	public UnitServiceBean(EntityManager em) {
		super();
		this.em = em;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.UnitService#create(java.lang.String)
	 */
	@Override
	public Unit create(String name) {
		if (StringUtils.isNotBlank(name)) {
			Unit unit = new Unit();
			unit.setName(name);
			em.persist(unit);
			return unit;
		}
		return null;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.UnitService#find(long)
	 */
	@Override
	public Unit find(long id) {
		return em.find(Unit.class, id);
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.UnitService#delete(long)
	 */
	@Override
	public Unit delete(long id) {
		Unit unit = find(id);
		if (unit != null) {
			em.remove(unit);
		}
		return unit;
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.UnitService#update(jmp.yury.kiryla.jpa_task1.beans.Unit)
	 */
	@Override
	public void update(Unit unit) {
		if (unit != null) {
			em.merge(unit);
		}
	}

	/**
	 * @see jmp.yury.kiryla.jpa_task1.services.UnitService#addEmployee(long,
	 *      long, jmp.yury.kiryla.jpa_task1.beans.EmployeeStatus)
	 */
	@Override
	public void addEmployee(long unitId, long employeeId, EmployeeStatus employeeStatus) {
		Unit unit = em.find(Unit.class, unitId);
		Employee employee = em.find(Employee.class, employeeId);

		if (unit != null && employee != null) {
			if (employeeStatus != null) {
				employee.setStatus(employeeStatus);
			}
			List<Employee> employees =  unit.getEmployees();
			if (employees == null) {
				employees = new ArrayList<>();
				unit.setEmployees(employees);
			}
			employees.add(employee);
			employee.setUnit(unit);
		}
	}

}
