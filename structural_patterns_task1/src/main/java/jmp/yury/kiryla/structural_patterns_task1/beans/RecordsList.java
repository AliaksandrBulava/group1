/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.beans;

import java.util.List;

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
    private String Name;

    /**
     * Records list
     */
    private List<String> records;

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
        return Name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return the records
     */
    public List<String> getRecords() {
        return records;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(List<String> records) {
        this.records = records;
    }
}
