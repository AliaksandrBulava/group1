/**
 * 
 */
package org.shop.config;

import org.shop.api.ItemService;
import org.shop.api.OrderService;
import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.api.impl.ItemServiceImpl;
import org.shop.api.impl.OrderServiceImpl;
import org.shop.api.impl.ProductServiceImpl;
import org.shop.api.impl.ProposalServiceImpl;
import org.shop.api.impl.SellerServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.shop.repository.ItemRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Services Configuration
 * 
 * @author Yury_Kiryla
 *
 */
@Configuration
public class ServiceConfiguration {
	/**
	 * {@link ItemRepository}
	 */
	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * {@link ProductRepository}
	 */
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * {@link ProductRepository}
	 */
	@Autowired
	private ProposalRepository proposalRepository;
	
	/**
	 * {@link ItemService}
	 * @return {@link ItemService} bean
	 */
	@Bean
	public ItemService itemService() {
		return new ItemServiceImpl(itemRepository);
	}
	
	/**
	 * {@link OrderService}
	 * @return {@link OrderService} object
	 */
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl();
	}
	
	/**
	 * {@link ProductService}
	 * @return {@link ProductService} implementation
	 */
	@Bean
	public ProductService productService() {
		return new ProductServiceImpl(productRepository);
	}
	
	/**
	 * {@link ProposalService}
	 * @return {@link ProductService} omplementation
	 */
	@Bean
	public ProposalService proposalService() {
		return new ProposalServiceImpl(proposalRepository);
	}
	
	/**
	 * {@link SellerService}
	 * @return {@link SellerService} bean
	 */
	@Bean
	public SellerService sellerService() {
		return new SellerServiceImpl();
	}
	
	/**
	 * {@link UserService}
	 * @return {@link UserService} bean
	 */
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
}
