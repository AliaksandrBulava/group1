package jmp.yury.kiryla.infrastructure_build_maven_gradle.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.beans.User;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.UserService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.web.Constants;

/**
 * Servlet implementation class UserPageController
 */
@WebServlet("/user")
public class UserPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		
		if (StringUtils.isNotBlank(name)) {
			UserService userService = (UserService) getServletContext().getAttribute(Constants.USER_SERVICE);
			
			User user = userService.searchUser(name);
			if (user == null) {
				user = userService.register(name);
			}
			
			request.getSession().setAttribute("user", user);
		}
		
		doGet(request, response);
	}

}
