/**
 * 
 */
package jmp.yury.kiryla.spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Yury_Kiryla
 *
 */
@Controller
public class ErrorController {

	@ExceptionHandler(IllegalArgumentException.class)
	public String handleException(Exception ex ,Model model){
		model.addAttribute("error", ex.getMessage());
		return "error";
	}
}
