package jmp.yury.kiryla.infrastructure_unit_jmock_task05.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.AuditoriumDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.EventDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.TicketDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.UserDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc.AbstractJdbcDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc.AuditoriumJdbcDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc.EventJdbcDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc.TicketJdbcDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.dao.jdbc.UserJdbcDAO;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.AuditoriumService;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.BookingService;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.EventService;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.UserService;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans.AuditoriumServiceBean;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans.BookingServiceBean;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans.EventServiceBean;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.services.beans.UserServiceBean;
import jmp.yury.kiryla.infrastructure_unit_jmock_task05.web.Constants;

/**
 * Application Lifecycle Listener implementation class
 * ServletContextListenerImpl
 *
 */
@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    /**
     * {@link DataSource}
     */
    private DataSource dataSource = null;

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
	
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
	if (dataSource == null) {
	    JdbcDataSource jdbcDataSource = new JdbcDataSource();
	    jdbcDataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
	    jdbcDataSource.setUser("sa");
	    jdbcDataSource.setPassword("sa");
	    dataSource = jdbcDataSource;
	    AbstractJdbcDAO.dbInit(dataSource);
	}
	
	UserDAO userDAO = UserJdbcDAO.getInstance(dataSource);
	AuditoriumDAO auditoriumDAO = AuditoriumJdbcDAO.getInstance(dataSource);
	EventDAO eventDAO = EventJdbcDAO.getInstance(dataSource);
	TicketDAO ticketDAO = TicketJdbcDAO.getInstance(dataSource);
	
	UserService userService = new UserServiceBean(userDAO);
	AuditoriumService auditoriumService = new AuditoriumServiceBean(auditoriumDAO);
	EventService eventService = new EventServiceBean(eventDAO);
	BookingService bookingService = new BookingServiceBean(ticketDAO);
	
	sce.getServletContext().setAttribute(Constants.USER_SERVICE, userService);
	sce.getServletContext().setAttribute(Constants.AUDITORIUM_SERVICE, auditoriumService);
	sce.getServletContext().setAttribute(Constants.EVENT_SERVICE, eventService);
	sce.getServletContext().setAttribute(Constants.BOOKING_SERVICE, bookingService);
    }

}
