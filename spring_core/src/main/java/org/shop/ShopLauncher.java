package org.shop;

import org.shop.config.RootConfig;
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
			Object bean = ctx.getBean("userRepository");
			System.out.println(bean);
			bean = ctx.getBean("itemRepository");
			System.out.println(bean);
			bean = ctx.getBean("orderRepository");
			System.out.println(bean);
			bean = ctx.getBean("productRepository");
			System.out.println(bean);
			bean = ctx.getBean("proposalRepository");
			System.out.println(bean);
			bean = ctx.getBean("sellerRepository");
			System.out.println(bean);
			
			bean = ctx.getBean("orderService");
			System.out.println(bean);
			bean = ctx.getBean("itemService");
			System.out.println(bean);
			bean = ctx.getBean("sellerService");
			System.out.println(bean);
			bean = ctx.getBean("productService");
			System.out.println(bean);
			bean = ctx.getBean("userService");
			System.out.println(bean);
			bean = ctx.getBean("proposalService");
			System.out.println(bean);
		}
	}
}
