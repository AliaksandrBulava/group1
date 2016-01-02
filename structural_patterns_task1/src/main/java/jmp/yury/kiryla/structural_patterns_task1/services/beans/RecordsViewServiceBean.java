/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.services.beans;

import java.util.function.Consumer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;
import jmp.yury.kiryla.structural_patterns_task1.services.RecordsViewService;

/**
 * {@link RecordsViewService} implementation
 * 
 * @author Yury
 *
 */
public class RecordsViewServiceBean implements RecordsViewService {
    /**
     * {@link RecordsDao}
     */
    private RecordsDao recordsDao;
    
    /** Title for Button "Add" */
    private static final String ADD_BUTTON_TITLE = "Add";
    
    /** Title for Add List window */
    private static final String ADD_LIST_WINDOW_TITLE = "Add new List";
    
    /** Space between each tile */
    private static final int TILE_INTERVAL = 10;
    
    /** New window width */
    private static final int NEW_WINDOW_WIDTH = 350;
    
    /** New window height */
    private static final int NEW_WINDOW_HEIGHT = 150;
    
    /** Text for Add List prompt */
    private static final String ADD_LIST_PROMPT_TEXT = "Enter List Name";
    
    /** Text Field width */
    private static final int TEXT_FIELD_WIDTH = 28;
    
    /** Title for Button "Save" */
    private static final String SAVE_BUTTON_TITLE = "Save";
    
    /** Title for Button "Cancel" */
    private static final String CANCEL_BUTTON_TITLE = "Cancel";

    /**
     * Constructor
     * @param recordsDao {@link RecordsDao}
     */
    public RecordsViewServiceBean(RecordsDao recordsDao) {
	super();
	this.recordsDao = recordsDao;
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.services.RecordsViewService#createListsComboBox()
     */
    @Override
    public ComboBox<RecordsList> createListsComboBox() {
	ObservableList<RecordsList> observableList = FXCollections.observableList(recordsDao.read());
	return new ComboBox<>(observableList);
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.services.RecordsViewService#createListsControls(javafx.scene.control.ComboBox)
     */
    @Override
    public Button[] createListsControls(ComboBox<RecordsList> listsComboBox) {
	Button addButton = new Button(ADD_BUTTON_TITLE);
	
	addButton.setOnAction(ae -> createTextInputWindow(ADD_LIST_WINDOW_TITLE, null, 
		text -> {
		    if (!text.isEmpty()) {
			RecordsList recordsList = new RecordsList();
			recordsList.setName(text);
			recordsDao.create(recordsList);
			listsComboBox.setItems(FXCollections.observableList(recordsDao.read()));
	    	    }
		}
	));
	
	return new Button[]{addButton};
    }

    /* (non-Javadoc)
     * @see jmp.yury.kiryla.structural_patterns_task1.services.RecordsViewService#createRecordsListView(jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList)
     */
    @Override
    public ListView<String> createRecordsListView(RecordsList recordsList) {
	// TODO Auto-generated method stub
	return null;
    }

    /* (non-Javadoc)
     * @see jmp.yury.kiryla.structural_patterns_task1.services.RecordsViewService#createRecordsControls(javafx.scene.control.ListView, jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList)
     */
    @Override
    public Button[] createRecordsControls(ListView<String> recordsListView, RecordsList recordsList) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /**
     * Create Window for input text
     * @param title the Window's title
     * @param initialValue initial text (if needs)
     * @param saveAction {@link Consumer} for processing save action on Text Field Value
     */
    private void createTextInputWindow(String title, String initialValue,  Consumer<String> saveAction) {
	Stage stage = new Stage();
	    stage.setTitle(title);

	    FlowPane flowPane = new FlowPane(TILE_INTERVAL, TILE_INTERVAL);
	    flowPane.setAlignment(Pos.CENTER);

	    Scene scene = new Scene(flowPane, NEW_WINDOW_WIDTH, NEW_WINDOW_HEIGHT);
	    stage.setScene(scene);
	    
	    TextField textField = new TextField();
	    if (initialValue != null) {
		textField.setText(initialValue);
	    }
	    textField.setPrefColumnCount(TEXT_FIELD_WIDTH);
	    
	    EventHandler<ActionEvent> save = ae -> {
		saveAction.accept(textField.getText());
		stage.hide();
	    };
	    
	    textField.setOnAction(save);

	    Button saveButton = new Button(SAVE_BUTTON_TITLE);
	    saveButton.setOnAction(save);

	    Button cancelButton = new Button(CANCEL_BUTTON_TITLE);
	    cancelButton.setOnAction(ae -> stage.hide());

	    flowPane.getChildren().addAll(textField, saveButton, cancelButton);

	    stage.show();
    }
}
