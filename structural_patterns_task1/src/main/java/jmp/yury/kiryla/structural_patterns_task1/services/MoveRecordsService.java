/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.services;

import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;

/**
 * For moving records from one {@link RecordsList} to another
 * 
 * @author Yury
 *
 */
public interface MoveRecordsService {
    /**
     * Move records
     * @param source source {@link RecordsList}
     * @param target target {@link RecordsList}
     */
    public void move(RecordsList source, RecordsList target);

}
