/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.dao.beans;

import java.util.HashMap;
import java.util.Map;

import jmp.yury.kiryla.structural_patterns_task1.beans.Record;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;

/**
 * {@link Map} implementation {@link RecordsDao}
 * 
 * @author Yury
 *
 */
public class MapRecordsDao implements RecordsDao {
    /**
     * records map
     */
    private Map<Long, Record> records = new HashMap<>();
    
    /**
     * ID counter
     */
    private long idCounter = 1;

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#create(jmp.yury.kiryla.structural_patterns_task1.beans.Record)
     */
    @Override
    public void create(Record record) {
	if (record.getId() != 0){
	    throw new IllegalArgumentException("Record already created");
	}
	record.setId(idCounter++);
	records.put(record.getId(), record.clone());
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#read(long)
     */
    @Override
    public Record read(long id) {
	if (records.containsKey(id)){
	    return records.get(id).clone();
	}
	return null;
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#read()
     */
    @Override
    public Record[] read() {
	return records.entrySet().stream().map(t -> t.getValue().clone()).toArray(Record[]::new);
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#update(jmp.yury.kiryla.structural_patterns_task1.beans.Record)
     */
    @Override
    public void update(Record record) {
	if(records.containsKey(record.getId())){
	    records.put(record.getId(), record);
	} else {
	    throw new IllegalArgumentException("Record is not existed");
	}	
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#delete(jmp.yury.kiryla.structural_patterns_task1.beans.Record)
     */
    @Override
    public void delete(Record record) {
	if(records.remove(record.getId()) == null){
	    throw new IllegalArgumentException("Record is not existed");
	}
    }

    
}
