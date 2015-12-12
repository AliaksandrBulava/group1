/**
 * 
 */
package jmp.yury.kiryla.creational_patterns_task1.beans;

import java.io.Serializable;

/**
 * Person Bean
 * 
 * @author Yury
 *
 */
public class Person implements Serializable {
    /**
     * Eclipse generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    private long id;

    /**
     * Name
     */
    private String name;

    /**
     * @return the id
     */
    public long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Person [id=" + id + ", name=" + name + "]";
    }

}
