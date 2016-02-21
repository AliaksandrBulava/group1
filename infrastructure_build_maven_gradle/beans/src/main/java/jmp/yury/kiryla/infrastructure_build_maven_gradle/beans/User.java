/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.beans;

/**
 * User bean
 * 
 * @author Yury
 *
 */
public class User {
    
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
    public synchronized long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public synchronized void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public synchronized String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public synchronized void setName(String name) {
        this.name = name;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return name;
    }    
}
