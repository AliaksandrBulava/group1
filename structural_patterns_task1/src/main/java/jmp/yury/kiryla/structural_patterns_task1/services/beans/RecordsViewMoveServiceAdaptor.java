/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1.services.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;
import jmp.yury.kiryla.structural_patterns_task1.services.MoveRecordsService;

/**
 * Adapter implementation
 * 
 * @author Yury
 *
 */
public class RecordsViewMoveServiceAdaptor extends RecordsViewServiceBean {
    
    /**
     * {@link MoveRecordsService}
     */
    private MoveRecordsService moveRecordsService;
    
    /**
     * {@link RecordsDao}
     */
    private RecordsDao recordsDao;
    
    /** Title for Button "Move" */
    private static final String MOVE_BUTTON_TITLE = "Move all";
    
    /** Title for Move Records window */
    private static final String MOVE_RECORDS_WINDOW_TITLE = "Move Records";
    
    /** Move Prompt */
    private static final String MOVE_RECORDS_PROMPT = "Select target List:";
    
    /** Title for Button "Cancel" */
    private static final String CANCEL_BUTTON_TITLE = "Cancel";
    
    /** Space between buttons value */
    private static final int BUTTONS_SPACING = 10;
    
    /** Padding value */
    private static final int PADDING = 25;
    
    /** The height of the vertical gaps between rows */
    private static final int V_GAP = 10;


    /**
     * Constructor
     * 
     * @param recordsDao {@link RecordsDao}
     * @param moveRecordsService {@link MoveRecordsService}
     */
    public RecordsViewMoveServiceAdaptor(RecordsDao recordsDao, MoveRecordsService moveRecordsService) {
	super(recordsDao);
	this.moveRecordsService = moveRecordsService;
	this.recordsDao = recordsDao;
    }

    /**
     * @see jmp.yury.kiryla.structural_patterns_task1.services.beans.RecordsViewServiceBean#createRecordsControls(javafx.scene.control.ListView, jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList)
     */
    @Override
    public Button[] createRecordsControls(ListView<String> recordsListView, RecordsList recordsList) {
	List<Button> buttons = new ArrayList<>(Arrays.asList(super.createRecordsControls(recordsListView, recordsList)));
	
	Button button = new Button(MOVE_BUTTON_TITLE);
	buttons.add(button);
	
	button.setOnAction(ae -> {
	    RecordsList[] targetLists = 
		    recordsDao.read().stream().filter(t -> t.getId() != recordsList.getId()).toArray(RecordsList[]::new);
	    
	    if (targetLists.length > 0){
		Stage stage = new Stage();
		stage.setTitle(MOVE_RECORDS_WINDOW_TITLE);
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setPadding(new Insets(PADDING));
		gridPane.setVgap(V_GAP);
		
		Scene scene = new Scene(gridPane);
		stage.setScene(scene);
		
		ComboBox<RecordsList> comboBox = new ComboBox<>(FXCollections.observableArrayList(targetLists));
		comboBox.setPromptText(MOVE_RECORDS_PROMPT);
		gridPane.add(comboBox, 1, 1);
		
		Button moveButton = new Button(MOVE_BUTTON_TITLE);
		moveButton.setOnAction(event -> {
		    RecordsList targetList = comboBox.getValue();
		    if (targetList != null) {
			moveRecordsService.move(recordsList, targetList);
			recordsListView.setItems(null);
			stage.hide();
		    }
		});
		
		Button cancelButton = new Button(CANCEL_BUTTON_TITLE);
		cancelButton.setOnAction(event -> stage.hide());
		
		HBox buttonsBox = new HBox(BUTTONS_SPACING);
		buttonsBox.getChildren().addAll(moveButton, cancelButton);
		gridPane.add(buttonsBox, 1, 2);
		
		stage.show();
	    }
	    
	});
	
	return buttons.stream().toArray(Button[]::new);
    }
    
    
    
}
