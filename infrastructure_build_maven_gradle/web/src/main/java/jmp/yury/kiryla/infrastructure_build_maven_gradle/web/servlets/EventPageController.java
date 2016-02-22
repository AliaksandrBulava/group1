package jmp.yury.kiryla.infrastructure_build_maven_gradle.web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.AuditoriumService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.EventService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.web.Constants;

/**
 * Servlet implementation class EventPageController
 */
@WebServlet("/admin/event")
public class EventPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * {@link AuditoriumService}
	 */
	private AuditoriumService auditoriumService;
	
	/**
	 * {@link EventService}
	 */
	private EventService eventService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventPageController() {
        super();
    }

    
    
	/**
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		auditoriumService = (AuditoriumService) config.getServletContext().getAttribute(Constants.AUDITORIUM_SERVICE);
		eventService = (EventService) config.getServletContext().getAttribute(Constants.EVENT_SERVICE);
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("auditoriums", auditoriumService.getAll());
		
		response.sendRedirect(request.getContextPath() + "/jsp/event.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("eventName");
		String auditoriumString = request.getParameter("eventAuiditorium");
		String dateString = request.getParameter("eventDate");
		String startTimeString = request.getParameter("eventStartTime");
		String endTimeString = request.getParameter("eventEndTime");
		
		response.sendRedirect(request.getContextPath() + "/jsp/event.jsp");
	}

}
