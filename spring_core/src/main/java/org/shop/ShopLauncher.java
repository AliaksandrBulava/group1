package org.shop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml")) {
        	System.out.println(ctx.getDisplayName());
        }
    }
}
