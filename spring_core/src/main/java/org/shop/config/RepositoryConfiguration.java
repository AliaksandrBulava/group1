/**
 * 
 */
package org.shop.config;

import org.shop.repository.ItemRepository;
import org.shop.repository.OrderRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.shop.repository.SellerRepository;
import org.shop.repository.UserRepository;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.ItemMapRepository;
import org.shop.repository.map.OrderMapRepository;
import org.shop.repository.map.ProductMapRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.shop.repository.map.SellerMapRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Repositories Configuration
 * 
 * @author Yury_Kiryla
 *
 */
@Configuration
public class RepositoryConfiguration {
	/**
	 * {@link ItemRepository}
	 * @return {@link ItemRepository} object
	 */
	@Bean
	public ItemRepository itemRepository() {
		return new ItemMapRepository();
	}

	/**
	 * {@link OrderRepository}
	 * @return {@link OrderRepository} object
	 */
	@Bean
	public OrderRepository orderRepository() {
		return new OrderMapRepository(1);
	}
	
	/**
	 * {@link ProductRepository}
	 * @return {@link ProductRepository} object
	 */
	@Bean
	public ProductRepository productRepository() {
		return new ProductMapRepository();
	}
	
	/**
	 * {@link ProposalRepository}
	 * @return {@link ProposalRepository} object
	 */
	@Bean
	public ProposalRepository proposalRepository() {
		return new ProposalMapRepository();
	}
	
	/**
	 * {@link SellerRepository}
	 * @return {@link SellerRepository} object
	 */
	@Bean
	public SellerRepository sellerRepository() {
		return new SellerMapRepository();
	}
	
	/**
	 * {@link UserRepository}
	 * @return {@link UserRepository} object
	 */
	@Bean
	public UserRepository userRepository() {
		return new UserRepositoryFactory().createUserRepository();
	}
}
