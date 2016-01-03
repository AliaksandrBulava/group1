/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.dao;

import java.util.List;

import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;

/**
 * Records DAO interface
 * 
 * @author Yury
 *
 */
public interface RecordsDao {
    /**
     * Store new records list
     * @param record list of records
     */
    public void create(RecordsList recordsList);

    /**
     * Read records list object
     * @param id ID value
     * @return the {@link RecordsList} object <br> <code>null</code> if RecordsList with requested ID was not created
     */
    public RecordsList read(long id);
    
    /**
     * Read all stored {@link RecordsList}s
     * @return RecordsLists List
     */
    public List<RecordsList> read();
    
    /**
     * Update existed RecordsList
     * Update Records List name is not supported
     * @param record the {@link String} object
     */
    public void update(RecordsList recordsList);
    
    /**
     * Delete RecordsList
     * @param record the {@link RecordsList} object
     */
    public void delete(RecordsList recordsList);
}
