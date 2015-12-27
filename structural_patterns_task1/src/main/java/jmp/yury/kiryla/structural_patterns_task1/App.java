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
import jmp.yury.kiryla.structural_patterns_task1.beans.Record;
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
    private ListView<Record> listView;

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
//	populatePane(gridPane);

	// list view
	ListView<Record> listView = new ListView<>(recordsController.getRecords());
	listView.setMinWidth(450);
	gridPane.add(listView, 1, 1);

	// Buttons
	Button newButton = new Button("New");
	Button updateButton = new Button("Update");
	Button deleteButton = new Button("Delete");
	HBox buttonsBox = new HBox(10);
	buttonsBox.getChildren().addAll(newButton, updateButton, deleteButton);
	gridPane.add(buttonsBox, 1, 2);

	// add new Record
	newButton.setOnAction(ae -> {
	    Stage newRecordStage = new Stage();
	    newRecordStage.setTitle("Add new Record");

	    FlowPane newRecordFlowPane = new FlowPane(10, 10);
	    newRecordFlowPane.setAlignment(Pos.CENTER);

	    Scene newRecordScene = new Scene(newRecordFlowPane, 350, 150);
	    newRecordStage.setScene(newRecordScene);

	    TextField newRecordTextField = new TextField();
	    newRecordTextField.setPromptText("Enter new record");
	    newRecordTextField.setPrefColumnCount(28);
	    newRecordTextField.setOnAction(event -> {
		recordsController.createRecord(newRecordTextField.getText());
		listView.setItems(recordsController.getRecords());
		newRecordStage.hide();
	    });

	    Button newRecordSaveButton = new Button("Save");
	    newRecordSaveButton.setOnAction(event -> {
		recordsController.createRecord(newRecordTextField.getText());
		listView.setItems(recordsController.getRecords());
		newRecordStage.hide();
	    });

	    Button newRecordCancelButton = new Button("Cancel");
	    newRecordCancelButton.setOnAction(event -> newRecordStage.hide());

	    newRecordFlowPane.getChildren().addAll(newRecordTextField, newRecordSaveButton, newRecordCancelButton);

	    newRecordStage.show();
	});

	updateButton.setOnAction(ae -> {
	    Stage updateRecordStage = new Stage();
	    updateRecordStage.setTitle("Update Record");

	    FlowPane updateRecordFlowPane = new FlowPane(10, 10);
	    updateRecordFlowPane.setAlignment(Pos.CENTER);

	    Scene updateRecordScene = new Scene(updateRecordFlowPane, 350, 150);
	    updateRecordStage.setScene(updateRecordScene);

	    Record record = listView.selectionModelProperty().get().getSelectedItem();

	    TextField updateRecordTextField = new TextField();
	    updateRecordTextField.setText(record.getValue());
	    updateRecordTextField.setPrefColumnCount(28);
	    updateRecordTextField.setOnAction(event -> {
		record.setValue(updateRecordTextField.getText());
		recordsController.updateRecord(record);
		listView.setItems(recordsController.getRecords());
		listView.refresh();
		updateRecordStage.hide();
	    });

	    Button updateRecordSaveButton = new Button("Save");
	    updateRecordSaveButton.setOnAction(event -> {
		record.setValue(updateRecordTextField.getText());
		recordsController.updateRecord(record);
		listView.setItems(recordsController.getRecords());
		listView.refresh();
		updateRecordStage.hide();
	    });

	    Button updateRecordCancelButton = new Button("Cancel");
	    updateRecordCancelButton.setOnAction(event -> updateRecordStage.hide());

	    updateRecordFlowPane.getChildren().addAll(updateRecordTextField, updateRecordSaveButton,
		    updateRecordCancelButton);

	    updateRecordStage.show();
	});

	deleteButton.setOnAction(ae -> {
	    Record record = listView.selectionModelProperty().get().getSelectedItem();
	    if (record != null) {
		recordsController.deleteRecord(record);
		listView.setItems(recordsController.getRecords());
	    }
	});

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
    
}
