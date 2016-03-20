/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.service.rest;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.MessageException;
import com.sun.jersey.api.NotFoundException;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import jmp.yury.kiryla.web_services_task1.beans.User;
import jmp.yury.kiryla.web_services_task1.service.dao.UserDAO;
import jmp.yury.kiryla.web_services_task1.service.dao.UserDAOImpl;

/**
 * REST User Service
 * 
 * @author Yury
 *
 */
@Path("/")
public class UserService {
    /**
     * {@link UserDAO}
     */
    private UserDAO userDAO = new UserDAOImpl();

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public User getUser(@PathParam("id") long id) {
	User user = userDAO.getUserById(id);
	if (user == null) {
	    throw new NotFoundException("There are not user with id=" + id);
	}
	return user;
    }

    @POST
    @Path("/new")
    @Consumes({ MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_XML })
    public User createUser(User user) {
	try {
	    userDAO.create(user);
	} catch (RuntimeException e) {
	    throw new MessageException(e.getMessage());
	}
	return user;
    }

    @PUT
    @Path("/update")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public User updateUser(User user) {
	try {
	    userDAO.update(user);
	} catch (RuntimeException e) {
	    throw new MessageException(e.getMessage());
	}
	return user;
    }

    @DELETE
    @Path("/delete")
    @Produces({ MediaType.TEXT_PLAIN })
    public String deleteUser(@QueryParam(value = "id") long id) {
	User user = userDAO.getUserById(id);
	if (user != null) {
	    userDAO.delete(user);
	    return "success";
	}
	throw new NotFoundException("There are not user with id=" + id);
    }
    
    @POST
    @Path("/logo")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public String uploadLogo(@FormDataParam("file") InputStream fileIS, @FormDataParam("file") FormDataContentDisposition disposition, @QueryParam(value = "id") long id){
	User user = userDAO.getUserById(id);
	if (user != null) {
	    userDAO.addLogo(fileIS, user);
	    return "File " + disposition.getFileName() + " uploaded";
	}
	throw new NotFoundException("There are not user with id=" + id);
    }
}
