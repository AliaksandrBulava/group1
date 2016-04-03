/**
 * 
 */
package org.shop.config;

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

}
