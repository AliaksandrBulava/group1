/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.service.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * REST service config
 * 
 * @author Yury
 *
 */
@ApplicationPath("/users")
public class ServiceConfig extends Application {

    /**
     * @see javax.ws.rs.core.Application#getClasses()
     */
    @Override
    public Set<Class<?>> getClasses() {
	Set<Class<?>> set = new HashSet<>();
	set.add(UserService.class);
	return set;
    }

}
