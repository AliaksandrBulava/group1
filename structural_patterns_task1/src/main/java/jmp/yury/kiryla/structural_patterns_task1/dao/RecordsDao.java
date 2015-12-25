/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.dao;

import jmp.yury.kiryla.structural_patterns_task1.beans.Record;

/**
 * Records DAO interface
 * 
 * @author Yury
 *
 */
public interface RecordsDao {
    /**
     * Store new record
     * @param record the {@link Record} object
     */
    public void create(Record record);

    /**
     * Read record object
     * @param id ID value
     * @return the {@link Record} object, <code>null</code> if Record with requested ID was not created
     */
    public Record read(long id);
    
    /**
     * Read all stored {@link Record}s
     * @return Records array
     */
    public Record[] read();
    
    /**
     * Update existed record
     * @param record the {@link Record} object
     */
    public void update(Record record);
    
    /**
     * Delete Record
     * @param record the {@link Record} object
     */
    public void delete(Record record);
}
