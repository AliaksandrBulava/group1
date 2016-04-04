package org.shop;

import org.shop.api.UserService;
import org.shop.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The User Initializer util class.
 */
@Component("userInitializer")
public class UserInitializer {

    /** The user service. */
    private UserService userService;

    /**
     * Instantiates a new user initializer.
     *
     * @param userService the user service
     */
    @Autowired
    public UserInitializer(@Qualifier("userService") UserService userService) {
        super();
        this.userService = userService;
    }
    
    /**
     * Inits the users.
     */
    public void initUsers() {
        User user = null;
        
        user = new User();
        user.setUsername("Ivan Ivanov");
        userService.registerUser(user);
        
        user = new User();
        user.setUsername("Petr Petrov");
        userService.registerUser(user);
    }
}
