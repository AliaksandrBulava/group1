/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jmp.yury.kiryla.structural_patterns_task1.beans.RecordsList;
import jmp.yury.kiryla.structural_patterns_task1.dao.RecordsDao;
import jmp.yury.kiryla.structural_patterns_task1.dao.beans.MapRecordsDao;
import jmp.yury.kiryla.structural_patterns_task1.services.RecordsViewService;
import jmp.yury.kiryla.structural_patterns_task1.services.beans.MoveRecordsServiceBean;
import jmp.yury.kiryla.structural_patterns_task1.services.beans.RecordsViewMoveServiceAdaptor;
import jmp.yury.kiryla.structural_patterns_task1.services.beans.RecordsViewServiceBean;

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
    
    /** Space between buttons value */
    private static final int BUTTONS_SPACING = 10;
    
    /**
     * {@link RecordsViewService}
     */
    private RecordsViewService recordsViewService;

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
	
	RecordsDao recordsDao = new MapRecordsDao();
	// Basic functionality
//	recordsViewService = new RecordsViewServiceBean(recordsDao);
	
	// Adapter based functionality
	recordsViewService = new RecordsViewMoveServiceAdaptor(recordsDao, new MoveRecordsServiceBean(recordsDao));
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
	gridPane.setAlignment(Pos.TOP_CENTER);
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
	//Add Controls for lists
	HBox listOperations = new HBox(BUTTONS_SPACING);
	ComboBox<RecordsList> listsComboBox = recordsViewService.createListsComboBox();
	listOperations.getChildren().add(listsComboBox);
	listOperations.getChildren().addAll(recordsViewService.createListsControls(listsComboBox));
	gridPane.add(listOperations, 1, 1);
	
	//Action for ComboBox change
	listsComboBox.setOnAction(ae -> {
	    RecordsList recordsList = listsComboBox.getValue();
	    ListView<String> recordsListView = recordsViewService.createRecordsListView(recordsList);
	    gridPane.add(recordsListView, 1, 2);
	    HBox buttons = new HBox(BUTTONS_SPACING);
	    buttons.getChildren().addAll(recordsViewService.createRecordsControls(recordsListView, recordsList));
	    gridPane.add(buttons, 1, 3);
	});
    }
}
