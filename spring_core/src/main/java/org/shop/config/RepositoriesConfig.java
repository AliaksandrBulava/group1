/**
 * 
 */
package org.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Repositories Configuration
 * 
 * @author Yury
 *
 */
@Configuration
@ComponentScan("org.shop.repository")
public class RepositoriesConfig {
	
	/**
	 * Initialize {@link PropertySourcesPlaceholderConfigurer}
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
