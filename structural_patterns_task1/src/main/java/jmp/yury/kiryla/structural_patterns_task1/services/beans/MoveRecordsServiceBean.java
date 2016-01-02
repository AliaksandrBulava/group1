/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.services.beans;

import java.util.List;

import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;
import jmp.yury.kiryla.structural_patterns_task1.services.MoveRecordsService;

/**
 * {@link MoveRecordsService} implementation
 * 
 * @author Yury
 *
 */
public class MoveRecordsServiceBean implements MoveRecordsService {
    /**
     * {@link RecordsDao}
     */
    private RecordsDao recordsDao;

    /**
     * Constructor
     * @param recordsDao the {@link RecordsDao} object
     */
    public MoveRecordsServiceBean(RecordsDao recordsDao) {
	super();
	this.recordsDao = recordsDao;
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.services.MoveRecordsService#move(jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList, jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList)
     */
    @Override
    public void move(RecordsList source, RecordsList target) {
	List<String> records = source.getRecords();
	
	if (records != null && !records.isEmpty()) {
	    List<String> targetRecords = target.getRecords();
	    if (targetRecords == null){
		target.setRecords(records);
	    } else {
		targetRecords.addAll(records);
	    }
	    source.setRecords(null);
	    
	    recordsDao.update(source);
	    recordsDao.update(target);
	}	
    }    
}
