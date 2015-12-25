/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.dao.beans;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jmp.yury.kiryla.structural_patterns_task1.beans.Record;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;

/**
 * {@link Set} implementation {@link RecordsDao}
 * 
 * @author Yury
 *
 */
public class SetRecordsDao implements RecordsDao {
    /**
     * records set
     */
    private Set<Record> records = new HashSet<>();
    
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
	records.add(record.clone());
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#read(long)
     */
    @Override
    public Record read(long id) {
	Optional<Record> optional = records.stream().filter(n -> n.getId() == id).findFirst();
	return optional.isPresent() ? optional.get().clone() : null;
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#read()
     */
    @Override
    public Record[] read() {
	return records.stream().map(t -> t.clone()).toArray(Record[]::new);
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#update(jmp.yury.kiryla.structural_patterns_task1.beans.Record)
     */
    @Override
    public void update(Record record) {
	if(records.contains(record)){
	    records.add(record);
	} else {
	    throw new IllegalArgumentException("Record is not existed");
	}	
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao#delete(jmp.yury.kiryla.structural_patterns_task1.beans.Record)
     */
    @Override
    public void delete(Record record) {
	if(!records.remove(record)){
	    throw new IllegalArgumentException("Record is not existed");
	}
    }

    
}
