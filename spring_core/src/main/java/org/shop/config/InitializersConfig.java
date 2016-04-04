/**
 * 
 */
package org.shop.config;

import java.util.HashMap;
import java.util.Map;

import org.shop.common.Sellers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Initializers Configuration
 * 
 * @author Yury
 *
 */
@Configuration
@ComponentScan("org.shop")
public class InitializersConfig {
	
	/**
	 * Sellers Map
	 * @return
	 */
	@Bean(name="sellers")
	public Map<Long, String> sellersMap() {
		Map<Long, String> map = new HashMap<>();
		map.put(1l, Sellers.AMAZON);
		map.put(2l, Sellers.SAMSUNG);
		map.put(3l, "Apple");
		return map;
	}

}
