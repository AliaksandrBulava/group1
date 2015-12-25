/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.beans;

/**
 * Record bean
 * 
 * @author Yury
 *
 */
public class Record {
    /**
     * ID
     */
    private long id;
    
    /**
     * Record Value
     */
    private String value;

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
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return value;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof Record)) {
	    return false;
	}
	Record other = (Record) obj;
	if (id != other.id) {
	    return false;
	}
	return true;
    }

    /**
     * @see java.lang.Object#clone()
     */
    @Override
    public Record clone() {
	Record record = new Record();
	record.id = id;
	record.value = value;
	return record;
    }
    
}
