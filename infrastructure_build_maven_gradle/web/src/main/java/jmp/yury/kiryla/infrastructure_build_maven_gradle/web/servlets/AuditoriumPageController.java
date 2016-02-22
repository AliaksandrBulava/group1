package jmp.yury.kiryla.infrastructure_build_maven_gradle.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.AuditoriumService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.web.Constants;

/**
 * Servlet implementation class AuditoriumPageController
 */
@WebServlet("/admin/auditorium")
public class AuditoriumPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuditoriumPageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/auditorium.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("auditoriumName");
		
		if (name != null && !name.isEmpty()) {
			AuditoriumService auditoriumService = (AuditoriumService) getServletContext().getAttribute(Constants.AUDITORIUM_SERVICE);
			auditoriumService.register(name);
		}
		
		doGet(request, response);
	}

}
