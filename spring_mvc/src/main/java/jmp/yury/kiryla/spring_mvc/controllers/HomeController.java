/**
 * 
 */
package jmp.yury.kiryla.spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller
 * 
 * @author Yury_Kiryla
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	/**
	 * Return Home view
	 * @return home view
	 */
	@RequestMapping
	public String home() {
		return "home";
	}
}
