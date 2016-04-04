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
		}
	}
}
