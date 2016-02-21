/**
 * 
 */
package jmp.yury.kiryla.infrastructure_build_maven_gradle.beans;

/**
 * Auditoriun Bean
 * 
 * @author Yury
 *
 */
public class Auditorium {

    /**
     * ID
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
	return name;
    }
}
