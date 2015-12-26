/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.controller;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jmp.yury.kiryla.structural_patterns_task1.beans.Record;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;
import jmp.yury.kiryla.structural_patterns_task1.dao.beans.SetRecordsDao;

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
    private RecordsDao recordsDao = new SetRecordsDao();
    
    /**
     * Return records list
     * @return the {@link ObservableList} object
     */
    public ObservableList<Record> getRecords(){
	return FXCollections.observableArrayList(recordsDao.read());
    }
}
