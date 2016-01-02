/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.services;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;

/**
 * Records View Service
 * 
 * Create nodes for View layer
 * 
 * @author Yury
 *
 */
public interface RecordsViewService {
    
    /**
     * Create ComboBox element for {@link RecordsList}s
     * @return {@link ComboBox}
     */
    public ComboBox<RecordsList> createListsComboBox();
    
    /**
     * Create control buttons for ListsComboBox
     * @param listsComboBox the {@link ComboBox} object
     * @return {@link Button}s array
     */
    public Button[] createListsControls(ComboBox<RecordsList> listsComboBox);
    
    /**
     * Create records listview
     * @param recordsList the {@link RecordsList} object
     * @return {@link ListView} object<br> if recordsList is null returns empty list
     */
    public ListView<String> createRecordsListView(RecordsList recordsList);

    /**
     * Create control buttons for list of records
     * @param recordsListView {@link ListView}
     * @param recordsList {@link RecordsList}
     * @return {@link Button}s array
     */
    public Button[] createRecordsControls(ListView<String> recordsListView, RecordsList recordsList);
}
