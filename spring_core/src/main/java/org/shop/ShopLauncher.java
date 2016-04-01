package org.shop;

import org.shop.data.Item;
import org.shop.repository.ItemRepository;
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
        	
        	ItemRepository itemRepository = ctx.getBean("itemRepository", ItemRepository.class);
        	System.out.println(itemRepository.createItem(new Item()));
        }
    }
}
