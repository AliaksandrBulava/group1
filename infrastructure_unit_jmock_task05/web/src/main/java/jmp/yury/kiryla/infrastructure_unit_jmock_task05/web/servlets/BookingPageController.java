package jmp.yury.kiryla.infrastructure_unit_jmock_task05.web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.Event;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.beans.User;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.BookingService;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.EventService;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.web.Constants;

/**
 * Servlet implementation class BookingPageController
 */
@WebServlet("/booking")
public class BookingPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * {@link BookingService}
	 */
	private BookingService bookingService;
	
	/**
	 * {@link EventService}
	 */
	private EventService eventService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingPageController() {
        super();
    }

	/**
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		bookingService = (BookingService) config.getServletContext().getAttribute(Constants.BOOKING_SERVICE);
		eventService = (EventService) config.getServletContext().getAttribute(Constants.EVENT_SERVICE);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		
		request.setAttribute("tickets", bookingService.get(user));
		request.setAttribute("events", eventService.getAll());
		
		getServletContext().getRequestDispatcher("/jsp/booking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventId = request.getParameter("bookEvent");
		
		if (NumberUtils.isNumber(eventId)) {
			User user = (User) request.getSession().getAttribute("user");
			Event event = eventService.get(Long.parseLong(eventId));
			bookingService.bookTicket(user, event);
		}		
		
		doGet(request, response);
	}

}
