package jmp.yury.kiryla.infrastructure_build_maven_gradle.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.AuditoriumDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.EventDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.TicketDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.UserDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.jdbc.AuditoriumJdbcDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.jdbc.EventJdbcDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.jdbc.TicketJdbcDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.dao.jdbc.UserJdbcDAO;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.AuditoriumService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.BookingService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.EventService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.UserService;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.beans.AuditoriumServiceBean;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.beans.BookingServiceBean;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.beans.EventServiceBean;
import jmp.yury.kiryla.infrastructure_build_maven_gradle.services.beans.UserServiceBean;

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
	    jdbcDataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:create.sql'");
	    jdbcDataSource.setUser("sa");
	    jdbcDataSource.setPassword("sa");
	    dataSource = jdbcDataSource;
	}
	
	UserDAO userDAO = UserJdbcDAO.getInstance(dataSource);
	AuditoriumDAO auditoriumDAO = AuditoriumJdbcDAO.getInstance(dataSource);
	EventDAO eventDAO = EventJdbcDAO.getInstance(dataSource);
	TicketDAO ticketDAO = TicketJdbcDAO.getInstance(dataSource);
	
	UserService userService = new UserServiceBean(userDAO);
	AuditoriumService auditoriumService = new AuditoriumServiceBean(auditoriumDAO);
	EventService eventService = new EventServiceBean(eventDAO);
	BookingService bookingService = new BookingServiceBean(ticketDAO);
	
	sce.getServletContext().setAttribute("userService", userService);
	sce.getServletContext().setAttribute("auditoriumService", auditoriumService);
	sce.getServletContext().setAttribute("eventService", eventService);
	sce.getServletContext().setAttribute("bookingService", bookingService);
    }

}
