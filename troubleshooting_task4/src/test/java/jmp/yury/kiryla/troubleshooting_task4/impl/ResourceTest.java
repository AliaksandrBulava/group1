/**
 * 
 */
package jmp.yury.kiryla.troubleshooting_task4.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link Resource}
 * 
 * @author Yury
 *
 */
public class ResourceTest {
    
    /**
     * {@link Resource}
     */
    private Resource resource;

    /**
     * Test initialization
     */
    @Before
    public void init() {
	resource = Resource.getInstance();
    }
    
    /**
     * Test {@link Resource#getValue()} method
     */
    @Test
    public void testGetResource(){
	assertEquals("Value", resource.getValue());
    }
}
