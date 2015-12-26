/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jmp.yury.kiryla.structural_patterns_task1.beans.Record;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;
import jmp.yury.kiryla.structural_patterns_task1.dao.beans.MapRecordsDao;

/**
 * Records Controller
 * 
 * @author Yury
 *
 */
public class RecordsController {
    /**
     * {@link RecordsDao}
     */
    private RecordsDao recordsDao = new MapRecordsDao();

    /**
     * Return records list
     * 
     * @return the {@link ObservableList} object
     */
    public ObservableList<Record> getRecords() {
	return FXCollections.observableArrayList(recordsDao.read());
    }

    /**
     * Create new record and store in DAO
     * 
     * @param text
     *            Record value
     */
    public void createRecord(String text) {
	if (text != null && !text.isEmpty()) {
	    Record record = new Record();
	    record.setValue(text);
	    recordsDao.create(record);
	}
    }
    
    /**
     * Update existed Record
     * @param record the {@link Record} value
     */
    public void updateRecord(Record record){
	if (record != null && record.getValue() != null && !record.getValue().isEmpty() && record.getId() != 0){
	    recordsDao.update(record);
	}
    }
    
    /**
     * Delete stored Record
     * @param record the {@link Record} object
     */
    public void deleteRecord(Record record){
	if (record != null && record.getId() != 0){
	    recordsDao.delete(record);
	}
    }
}
