/**
 * 
 */
package jmp.yury.kiryla.spring_mvc.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jmp.yury.kiryla.jpa_task1.beans.Address;
import jmp.yury.kiryla.jpa_task1.beans.Employee;
import jmp.yury.kiryla.jpa_task1.beans.EmployeePersonalInfo;
import jmp.yury.kiryla.jpa_task1.services.EmployeeService;

/**
 * Employee Controller
 * 
 * @author Yury_Kiryla
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	/**
	 * {@link EmployeeService}
	 */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Employee page
	 * 
	 * @return employee view
	 */
	@RequestMapping("/")
	public String epmloyeePage() {
		return "employee";
	}

	/**
	 * Create employee
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 * @param country
	 * @param state
	 * @param city
	 * @param street
	 * @param home
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String create(String firstName, String lastName, @DateTimeFormat(iso = ISO.DATE) Date birthday,
			String country, String state, String city, String street, String home) {

		EmployeePersonalInfo personalInfo = new EmployeePersonalInfo();
		personalInfo.setFirstName(firstName);
		personalInfo.setLastName(lastName);
		personalInfo.setBirthday(birthday);

		Address address = new Address();
		address.setCountry(country);
		address.setState(state);
		address.setCity(city);
		address.setStreet(street);
		address.setHome(home);

		employeeService.create(personalInfo, address);

		return "employee";
	}

	/**
	 * Find employee
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "id")
	public String find(Long id, HttpSession session) {
		Employee employee = employeeService.find(id);
		if (employee != null) {
			session.setAttribute("employee", employee);
		}
		return "employee";
	}
	
	/**
	 * Update employee
	 * @param firstName
	 * @param lastName
	 * @param country
	 * @param state
	 * @param city
	 * @param street
	 * @param home
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public String update(String firstName, String lastName, String country, String state, String city, 
			String street, String home, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		
		EmployeePersonalInfo personalInfo = new EmployeePersonalInfo();
		personalInfo.setFirstName(firstName);
		personalInfo.setLastName(lastName);

		Address address = new Address();
		address.setCountry(country);
		address.setState(state);
		address.setCity(city);
		address.setStreet(street);
		address.setHome(home);
		
		employee.setAddress(address);
		employee.setPersonalInfo(personalInfo);
		
		employeeService.update(employee);
		session.setAttribute("employee", employee);
		
		return "employee";
	}
	
	/**
	 * delete employee
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete (HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		employeeService.delete(employee.getId());
		session.invalidate();
		return "employee";
	}
	
	/**
	 * Find employee wit alternate header
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = "id", headers={"Alternates=other"})
	public String altFind(Long id, Model model) {
		Employee employee = employeeService.find(id);
		if (employee != null) {
			model.addAttribute(employee);
		}
		return "altEmployee";
	}
	
	/**
	 * Find employee 
	 * 
	 * XML Response
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers="Accept=application/xml")
	@ResponseBody
	public Employee xmlFind(Long id) {
		Employee employee = employeeService.find(id);
		
		return employee;
	}
	
	/**
	 * Find employee
	 * 
	 * JSON Response
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public Employee jsonFind(Long id) {
		Employee employee = employeeService.find(id);
		
		return employee;
	}
}
