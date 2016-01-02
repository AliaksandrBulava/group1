/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jmp.yury.kiryla.structural_patterns_task1.beans.String;
import jmp.yury.kiryla.structural_patterns_task1.controller.RecordsController;

/**
 * Main class
 * 
 * @author Yury
 *
 */
public class App extends Application {

    /** Title of view */
    private static final String VIEW_TITLE = "Records list";

    /** Window's width */
    private static final int WINDOW_WIDTH = 500;

    /** Window's height */
    private static final int WINDOW_HEIGHT = 300;
    
    /** List View width */
    private static final int LIST_WIDTH = 450;

    /** The width of the horizontal gaps between columns */
    private static final int H_GAP = 15;

    /** The height of the vertical gaps between rows */
    private static final int V_GAP = 10;

    /** Padding value */
    private static final int PADDING = 25;
    
    /** Title for Button "New" */
    private static final String NEW_BUTTON_TITLE = "New";
    
    /** Title for Button "Update" */
    private static final String UPDATE_BUTTON_TITLE = "Update";
    
    /** Title for Button "Delete" */
    private static final String DELETE_BUTTON_TITLE = "Delete";
    
    /** Title for Button "Save" */
    private static final String SAVE_BUTTON_TITLE = "Save";
    
    /** Title for Button "Cancel" */
    private static final String CANCEL_BUTTON_TITLE = "Cancel";

    /**
     * {@link RecordsController}
     */
    private RecordsController recordsController;
    
    /**
     * {@link ListView}
     */
    private ListView<String> listView;

    /**
     * @param args
     */
    public static void main(String[] args) {
	launch(args);

    }

    /**
     * @see javafx.application.Application#init()
     */
    @Override
    public void init() throws Exception {
	super.init();
	recordsController = new RecordsController();
	listView = new ListView<>(recordsController.getRecords());
	listView.setMinWidth(LIST_WIDTH);
    }

    /**
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle(VIEW_TITLE);

	// create pane
	GridPane gridPane = createPane();

	// Scene
	Scene scene = new Scene(gridPane, WINDOW_WIDTH, WINDOW_HEIGHT);
	primaryStage.setScene(scene);
	
	//Populate Pane
	populatePane(gridPane);

	primaryStage.show();
    }

    /**
     * Create pane
     * 
     * @return {@link GridPane} object
     */
    private GridPane createPane() {
	GridPane gridPane = new GridPane();
	gridPane.setAlignment(Pos.CENTER);
	gridPane.setHgap(H_GAP);
	gridPane.setVgap(V_GAP);
	gridPane.setPadding(new Insets(PADDING));
	return gridPane;
    }
    
    /**
     * Populate pane
     * @param gridPane the {@link GridPane} object
     */
    private void populatePane(GridPane gridPane){
	gridPane.add(listView, 1, 1);
	
	Button newButton = createButtonNew();
	Button updateButton = createButtonUpdate();
	Button deleteButton = createButtonDelete();
	
	HBox buttonsBox = new HBox(10);
	buttonsBox.getChildren().addAll(newButton, updateButton, deleteButton);
	gridPane.add(buttonsBox, 1, 2);
    }
    
    /**
     * Create Button 'New'
     * @return the {@link Button} object
     */
    private Button createButtonNew(){
	Button button = new Button(NEW_BUTTON_TITLE);
	button.setOnAction(event -> {
	    Stage stage = new Stage();
	    stage.setTitle("Add new Record");

	    FlowPane flowPane = new FlowPane(10, 10);
	    flowPane.setAlignment(Pos.CENTER);

	    Scene scene = new Scene(flowPane, 350, 150);
	    stage.setScene(scene);
	    
	    TextField textField = new TextField();
	    textField.setPromptText("Enter new record");
	    textField.setPrefColumnCount(28);
	    
	    EventHandler<ActionEvent> saveRecord = (ae) -> {
		recordsController.createRecord(textField.getText());
		listView.setItems(recordsController.getRecords());
		stage.hide();
	    };
	    
	    textField.setOnAction(saveRecord);

	    Button saveButton = new Button(SAVE_BUTTON_TITLE);
	    saveButton.setOnAction(saveRecord);

	    Button cancelButton = new Button(CANCEL_BUTTON_TITLE);
	    cancelButton.setOnAction(ae -> stage.hide());

	    flowPane.getChildren().addAll(textField, saveButton, cancelButton);

	    stage.show();
	});
	return button;
    }
    
    /**
     * Create Button 'Update'
     * @return the {@link Button}
     */
    private Button createButtonUpdate() {
	Button button = new Button(UPDATE_BUTTON_TITLE);
	button.setOnAction(ae -> {
	    Stage stage = new Stage();
	    stage.setTitle("Update Record");

	    FlowPane flowPane = new FlowPane(10, 10);
	    flowPane.setAlignment(Pos.CENTER);

	    Scene scene = new Scene(flowPane, 350, 150);
	    stage.setScene(scene);

	    String record = listView.selectionModelProperty().get().getSelectedItem();
	    TextField textField = new TextField();
	    textField.setText(record.getValue());
	    textField.setPrefColumnCount(28);
	    
	    EventHandler<ActionEvent> updateRecord = event -> {
		record.setValue(textField.getText());
		recordsController.updateRecord(record);
		listView.setItems(recordsController.getRecords());
		listView.refresh();
		stage.hide();
	    };

	    
	    textField.setOnAction(updateRecord);

	    Button updateButton = new Button(UPDATE_BUTTON_TITLE);
	    updateButton.setOnAction(updateRecord);

	    Button cancelButton = new Button(CANCEL_BUTTON_TITLE);
	    cancelButton.setOnAction(event -> stage.hide());

	    flowPane.getChildren().addAll(textField, updateButton,
		    cancelButton);

	    stage.show();
	});
	
	return button;
    }
    
    /**
     * Create Button 'Delete'
     * @return the {@link Button}
     */
    private Button createButtonDelete() {
	Button button = new Button(DELETE_BUTTON_TITLE);
	button.setOnAction(ae -> {
	    String record = listView.selectionModelProperty().get().getSelectedItem();
	    if (record != null) {
		recordsController.deleteRecord(record);
		listView.setItems(recordsController.getRecords());
	    }
	});
	return button;
    }
}
