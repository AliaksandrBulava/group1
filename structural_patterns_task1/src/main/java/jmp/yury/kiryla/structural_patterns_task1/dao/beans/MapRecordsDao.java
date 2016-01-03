/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.dao.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;

/**
 * Map implementation {@link RecordsDao}
 *
 * does not synchronized
 * @author Yury
 *
 *
 */
public class MapRecordsDao implements RecordsDao {
    /**
     * For RecordsLists storing
     */
    private Map<Long, RecordsList> recordsMap = new HashMap<>();

    /**
     * For set id
     */
    private long idCounter = 1;
    
    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#create(jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList)
     */
    @Override
    public void create(RecordsList recordsList) {
	if (recordsList.getId() != 0){
	    throw new IllegalArgumentException("Records List is not new");
	}
	
	String name = recordsList.getName();
	
	if (name == null || name.isEmpty()){
	    throw new IllegalArgumentException("Name is required field for Records List");
	}
	
	if (recordsMap.values().stream().anyMatch(item -> item.getName().equals(name))){
	    throw new IllegalArgumentException("Records List with the same name exists");
	}
	
	recordsList.setId(idCounter);
	recordsMap.put(idCounter++, recordsList);
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#read(long)
     */
    @Override
    public RecordsList read(long id) {
	return recordsMap.get(id);
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#read()
     */
    @Override
    public List<RecordsList> read() {
	return recordsMap.isEmpty() ? null : new ArrayList<>(recordsMap.values());
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#update(jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList)
     */
    @Override
    public void update(RecordsList recordsList) {
	if (recordsList.getId() == 0) {
	    throw new IllegalArgumentException("RecordsList was not created");
	}
	recordsMap.get(recordsList.getId()).setRecords(recordsList.getRecords());
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#delete(jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList)
     */
    @Override
    public void delete(RecordsList recordsList) {
	recordsMap.remove(recordsList.getId());
    }
}
