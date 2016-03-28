/**
 * 
 */
package jmp.yury.kiryla.jpa_task1;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jmp.yury.kiryla.jpa_task1.beans.Address;
import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.EmployeePersonalInfo;
import jmp.yury.kiryla.jpa_task1.beans.EmployeeStatus;
import jmp.yury.kiryla.jpa_task1.beans.Project;
import jmp.yury.kiryla.jpa_task1.services.EmployeeService;
import jmp.yury.kiryla.jpa_task1.services.ProjectService;
import jmp.yury.kiryla.jpa_task1.services.beans.EmployeeServiceBean;
import jmp.yury.kiryla.jpa_task1.services.beans.ProjectServiceBean;

/**
 * Main class for application
 * 
 * @author Yury_Kiryla
 *
 */
public class App {

	/**
	 * {@link EmployeeService}
	 */
	private EmployeeService employeeService;
	
	/**
	 * {@link ProjectService}
	 */
	private ProjectService projectService;

	/**
	 * 
	 */
	public App(EntityManager em) {
		super();
		employeeService = new EmployeeServiceBean(em);
		projectService = new ProjectServiceBean(em);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("jpa_task1");
			em = emf.createEntityManager();

			new App(em).test();

		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}

	/**
	 * Test Application
	 */
	private void test() {

		// Test User Service

		System.out.println("Test Employee create");
		Address address = new Address();
		address.setCountry("Belarus");
		address.setCity("Gomel");
		address.setStreet("Sovetskaya");
		address.setHome("10a");

		EmployeePersonalInfo personalInfo = new EmployeePersonalInfo();
		personalInfo.setFirstName("Yury");
		personalInfo.setLastName("Kiryla");
		personalInfo.setBirthday(new Date(100000));

		Employee employee = employeeService.create(personalInfo, address);

		System.out.println("Employee created:");
		System.out.println(employee);
		System.out.println();

		long employeeId = employee.getId();
		employee = null;

		System.out.println("Test find employee:");
		employee = employeeService.find(employeeId);
		System.out.println("Employee was found:");
		System.out.println(employee);
		System.out.println();

		System.out.println("Test update employee");
		employee.setStatus(EmployeeStatus.TEMPORARY);
		employee.getAddress().setCity("Minsk");
		employee.getPersonalInfo().setBirthday(new GregorianCalendar(1950, 5, 10).getTime());
		employeeService.update(employee);
		employee = null;
		employee = employeeService.find(employeeId);
		System.out.println("Updated employee:");
		System.out.println(employee);
		System.out.println();

		//Test Project Service
		System.out.println("Create Project");
		Project project = projectService.create("Test Project", null);
		System.out.println("Created Project:");
		System.out.println(project);
		System.out.println();
		
		System.out.println("Find Project");
		project = projectService.find(project.getId());
		System.out.println("Found Project:");
		System.out.println(project);
		System.out.println();
		
		System.out.println("Update Project");
		project.setDescription("Test Project Description");
		projectService.update(project);
		System.out.println("Updated Project:");
		project = projectService.find(project.getId());
		System.out.println(project);
		System.out.println();
		
		System.out.println("Add employee to project");
		projectService.assignEmployee(project.getId(), employee.getId());
		System.out.println("Updated Project:");
		project = projectService.find(project.getId());
		System.out.println(project);
		System.out.println("Updated employee:");
		employee = employeeService.find(employee.getId());
		System.out.println(employee);
		System.out.println();
		
		//Test Unit Service
	}
}
