package org.shop;


import org.shop.api.ItemService;
import org.shop.api.OrderService;
import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.UserService;
import org.shop.config.RootConfig;
import org.shop.data.Product;
import org.shop.data.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class)) {
			
			//Get bean by name
			ItemService itemService = (ItemService) ctx.getBean("itemService");
			
			// Get Bean by Type
			OrderService orderService = ctx.getBean(OrderService.class);
			
			// Get bean by type and name
			ProductService productService = ctx.getBean("productService", ProductService.class);

			// Get bean by alias
			UserService userService = (UserService) ctx.getBean("u_serv");
			
			//Check if it works
			
			Product product = new Product();
			product.setName("N450");
			product.setDescription("Laptop");
			productService.createProduct(product);
			System.out.println("Product created: " + product);
			
			User user = new User();
			user.setUsername("John");
			userService.registerUser(user);
			System.out.println("User registered: " + user);
			
			ProposalService proposalService = ctx.getBean(ProposalService.class);
			orderService.createOrder(user, proposalService.getProposalsByProductId(1l).get(0));
			System.out.println("Created order: " + orderService.getOrdersByUser(user).get(0));
		}
	}
}
