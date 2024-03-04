package intro;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * All JavaFX programs extend a core class named Application, which provides the 
 * basic functionality of the program. When you extend the Application class, 
 * you must override a start method; JavaFX calls this method when the application starts.
 * 
 * Like any Java program, a JavaFX program must have a main method. In a JavaFX program, 
 * the main method simply calls the launch method of the Application class, which in turn 
 * launches the application and calls the start method.
 * 
 * @author Doug Lowe  - JavaFX for Dummies
 * @author Jack Myers - modifications
 *
 */
public class Events extends Application {
	
	/**
	 * Like any Java program, a JavaFX program must have a main method. In a JavaFX program, 
	 * the main method simply calls the launch method of the Application class, which in turn 
	 * launches the application and calls the start method.
	 * 
	 * @param args	No command line arguments needed for this program.
 	 */
	public static void main(String[] args) {
		/* static method inherited from Application class that creates
		 * an instance of the Application class and starts the JavaFX lifecycle. */
		launch(args);
	}
	
	/* Instance variables of the JavaFX application. Controls are often declared as 
	 * class variables so that you can access them from any method defined within the class.
	 */

	// Controls
	Button btn;
	Label lbl;
	
	// Other application variables
	int clickCounter = 0;
	
	/**
	 * The start method is an abstract method, which means that there is no default 
	 * implementation provided as a part of the Application class. Therefore, you 
	 * must provide your own version of the start method. 
	 * 
	 * The start method is responsible for building and displaying the user interface.
	 * 
	 * @param primaryStage  the main (or primary) stage for this application, onto 
 							which the scene can be set.
	 */
	@Override public void start(Stage mainStage) {
		BorderPane pane = new BorderPane();  
		setupControls(pane);                 
		Scene scene = new Scene(pane, 300, 250); 
		setStage(mainStage, scene);		
	}

	/**
	 * The action that will happen upon clicking the button
	 * @param	 the event which was triggered 
	 */
	public void click(Event e) {
		String message = "The source of the event is " + e.getSource();
		message += "\nThe target of the event is " + e.getTarget();
		message += "\nThe type of the event is " +  e.getEventType();
		message += "\nThe event is " + e;
		System.out.println(message);		
	}
	
	/**
	 * Method to establish properties of controls
	 * 
	 * @param pane	The layout pane into which the controls will be placed
	 */
	private void setupControls(BorderPane pane) {

		// Create the controls
		
		btn = new Button();
		btn.setText("Click me please!");
		btn.setFont(Font.font("Verdana", 18));
		btn.setOnAction(e -> click(e));  // Pass the event object 

		// Place the controls in the areas of the Border Layout
		pane.setCenter(btn);
	}
	
	private void setStage(Stage stage, Scene scene) {
		stage.setScene(scene);
		stage.setTitle("Using Events");
		stage.show();
	}
}