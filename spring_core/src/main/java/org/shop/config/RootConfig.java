/**
 * 
 */
package org.shop.config;

import org.shop.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Root Configuration
 * 
 * @author Yury
 *
 */
@Configuration
@Import({RepositoriesConfig.class, ServicesConfig.class, InitializersConfig.class})
public class RootConfig {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	/**
	 * Create Alias for User Service
	 */
	@Bean(name="u_serv")
	public UserService alias() {
		return userService;
	}
}
