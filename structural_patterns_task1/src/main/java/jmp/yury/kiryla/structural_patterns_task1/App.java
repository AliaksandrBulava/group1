/**
 * 
 */
package jmp.yury.kiryla.structural_patterns_task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Main class
 * 
 * @author Yury
 *
 */
public class App extends Application {
    
    /**
     * Title of view
     */
    private static final String VIEW_TITLE = "Records list";
    
    /**
     * Window's width
     */
    private static final int WINDOW_WIDTH = 500;
    
    /**
     * Window's height
     */
    private static final int WINDOW_HEIGHT = 300;

    /**
     * @param args
     */
    public static void main(String[] args) {
	launch(args);

    }
    
    /**
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle(VIEW_TITLE);
	
	FlowPane pane = new FlowPane();
	
	Scene scene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);
	primaryStage.setScene(scene);
	
	primaryStage.show();

    }

}
