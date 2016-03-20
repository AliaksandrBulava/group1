/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.service.rest;

import java.io.InputStream;
import java.util.Map;

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
import javax.ws.rs.core.Response;

import com.sun.jersey.api.MessageException;
import com.sun.jersey.api.NotFoundException;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import jmp.yury.kiryla.web_services_task1.beans.User;
import jmp.yury.kiryla.web_services_task1.service.dao.UserDAO;
import jmp.yury.kiryla.web_services_task1.service.dao.UserDAOBean;

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
    private UserDAO userDAO = new UserDAOBean();

    /**
     * Get user by id
     * @param id ID value
     * @return {@link User} object
     */
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

    /**
     * Create new User. Support only XML format
     * @param user the {@link User} object
     * @return {@link User} object
     */
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

    /**
     * Update existed User. Support only JSON format
     * @param user the {@link User} object
     * @return User
     */
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

    /**
     * Delete user
     * @param id User ID
     * @return deleted {@link User} object
     */
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

    /**
     * Upload logo file
     * @param fileIS File {@link InputStream}
     * @param disposition File {@link FormDataContentDisposition}
     * @param id User ID
     * @return String result
     */
    @POST
    @Path("/logo")
    @Consumes({ MediaType.MULTIPART_FORM_DATA })
    public String uploadLogo(@FormDataParam("file") InputStream fileIS,
	    @FormDataParam("file") FormDataContentDisposition disposition, @FormDataParam("id") long id) {
	User user = userDAO.getUserById(id);
	if (user != null) {
	    userDAO.addLogo(fileIS, disposition.getFileName(), user);
	    return "File " + disposition.getFileName() + " uploaded";
	}
	throw new NotFoundException("There are not user with id=" + id);
    }

    /**
     * Download logo for specific user
     * @param id User ID
     * @return {@link Response} object, which contains logo file
     */
    @GET
    @Path("/logo")
    public Response downloadLogo(@QueryParam(value = "id") long id) {
	User user = userDAO.getUserById(id);
	if (user != null) {
	    Map.Entry<String, InputStream> logo = userDAO.getLogo(user);
	    if (logo != null) {
		return Response.ok(logo.getValue(), MediaType.APPLICATION_OCTET_STREAM)
			.header("content-disposition", "attachment; filename = " + logo.getKey()).build();
	    } else {
		throw new NotFoundException(
			"There are not logo for user " + user.getFirstName() + " " + user.getLastName());
	    }
	} else {
	    throw new NotFoundException("There are not user with id=" + id);
	}
    }
}
