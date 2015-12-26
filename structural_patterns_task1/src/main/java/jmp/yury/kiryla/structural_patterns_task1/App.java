/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
    
    /** The width of the horizontal gaps between columns */
    private static final int H_GAP = 15;
    
    /** The height of the vertical gaps between rows */
    private static final int V_GAP = 10;
    
    /** Padding value */
    private static final int PADDING = 25;
    
    /**
     * {@link RecordsController}
     */
    private RecordsController recordsController;

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
    }

    /**
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle(VIEW_TITLE);
	
	//create pane
	GridPane gridPane = createPane();
	
	//Scene
	Scene scene = new Scene(gridPane, WINDOW_WIDTH, WINDOW_HEIGHT);
	primaryStage.setScene(scene);
	
	//list view
	ListView<Record> listView = new ListView<>(recordsController.getRecords());
	gridPane.add(listView, 1, 1);
	
	//Buttons
	Button newButton = new Button("New");
	Button deleteButton = new Button("Delete");
	HBox buttonsBox = new HBox(10);
	buttonsBox.getChildren().addAll(newButton, deleteButton);
	gridPane.add(buttonsBox, 1, 2);
	
	//add new Record
	newButton.setOnAction(ae -> {
	    Stage newRecordStage = new Stage();
	    newRecordStage.setTitle("Add new Record");
	    
	    FlowPane newRecordFlowPane = new FlowPane(10, 10);
	    newRecordFlowPane.setAlignment(Pos.CENTER);
	    
	    Scene newRecordScene = new Scene(newRecordFlowPane, 350, 150);
	    newRecordStage.setScene(newRecordScene);
	    
	    newRecordStage.show();
	});
	
	primaryStage.show();
    }
    
    /**
     * Create pane 
     * @return {@link GridPane} object
     */
    private GridPane createPane(){
	GridPane gridPane = new GridPane();
	gridPane.setAlignment(Pos.CENTER);
	gridPane.setHgap(H_GAP);
	gridPane.setVgap(V_GAP);
	gridPane.setPadding(new Insets(PADDING));
	return gridPane;
    }
}
