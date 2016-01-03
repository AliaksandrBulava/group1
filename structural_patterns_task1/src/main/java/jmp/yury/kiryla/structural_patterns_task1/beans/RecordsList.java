/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.beans;

import java.util.Set;

/**
 * List records
 * 
 * @author Yury
 *
 */
public class RecordsList {
    /**
     * ID
     */
    private long id;
    
    /**
     * List's name
     */
    private String name;

    /**
     * Records list
     */
    private Set<String> records;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the records
     */
    public Set<String> getRecords() {
        return records;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(Set<String> records) {
        this.records = records;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return name;
    }
    
    
}
