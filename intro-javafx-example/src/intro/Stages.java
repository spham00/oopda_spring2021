package intro;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * All JavaFX programs extend a core class named Application, which provides the 
 * basic functionality of the program. When you extend the Application class, 
 * you must override a start method; JavaFX calls this method when the application starts.
 * 
 * Like any Java program, a JavaFX program must have a main method. In a JavaFX program, 
 * the main method simply calls the launch method of the Application class, which in turn 
 * launches the application and calls the start method.
 * 
 * @author Jack Myers 
 *
 */
public class Stages extends Application {
	
	final double HEIGHT = 500;  // splash scene height
	final double WIDTH = 500;   // splash scene width
	
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
			
	/**
	 * The start method is an abstract method, which means that there is no default 
	 * implementation provided as a part of the Application class. Therefore, you 
	 * must provide your own version of the start method. 
	 * 
	 * The start method is responsible for building and displaying the user interface.
	 * @param splash 
	 * 
	 * @param primaryStage  the main (or primary) stage for this application, onto 
 							which the scene can be set.
	 * @throws InterruptedException 
	 */
	@Override public void start(Stage mainStage) throws InterruptedException {
		BorderPane mainPane = new BorderPane();         // make layout to hold controls
		BorderPane splashPane = new BorderPane();       // make layout for splash screen  
		setupControls(mainStage, mainPane);             // initialize and place controls
		Scene scene = new Scene(mainPane);              // Add the layout pane to a scene
		makeSplashScreen(mainStage, splashPane);        // add controls to splash 
		Scene splash = new Scene(splashPane, WIDTH, HEIGHT);	// Setup a Splash Screen
		setStage(mainStage, scene, splash);             // Finalize and show the stage
	}

	private void makeSplashScreen(Stage mainStage, BorderPane splashPane) {
		Label lblSplash = new Label("Fun with JavaFX");
		lblSplash.setTextFill(Color.BLUEVIOLET);
		lblSplash.setFont(Font.font("Arial", 36));
		splashPane.setStyle("-fx-background-color: Bisque;");
		splashPane.setCenter(lblSplash);
	}

	/**
	 * Method to establish properties of controls
	 * 
	 * @param pane	The layout pane into which the controls will be placed
	 */
	private void setupControls(Stage mainStage, BorderPane pane) {

		// Create the controls
		
		// Style  buttons
		Label lblStyles = new Label("Styles");
		lblStyles.setTextFill(Color.IVORY);
		lblStyles.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		Button btnDecorated = new Button();
		btnDecorated.setText("Decorated");
		btnDecorated.setOnAction(e -> 
						launchStage(mainStage, StageStyle.DECORATED)); 
		Button btnUndecorated = new Button();
		btnUndecorated.setText("Undecorated");
		btnUndecorated.setOnAction(e -> 
						launchStage(mainStage, StageStyle.UNDECORATED));
		Button btnTransparent = new Button();
		btnTransparent.setText("Transparent");
		btnTransparent.setOnAction(e -> 
						launchStage(mainStage, StageStyle.TRANSPARENT));
		Button btnUtility = new Button();
		btnUtility.setText("Utility");
		btnUtility.setOnAction(e -> 
						launchStage(mainStage, StageStyle.UTILITY)); 
		
		// Place style buttons in a VBox pane
		VBox leftPane = new VBox(20); // 20 pixel spacing
		leftPane.setStyle("-fx-background-color: rgb(255, 25, 55);");
		leftPane.setAlignment(Pos.CENTER);
		leftPane.setPadding(new Insets(5,5,25,5)); // top, left, bottom, right
		leftPane.getChildren().add(lblStyles);
		leftPane.getChildren().add(btnDecorated);
		leftPane.getChildren().add(btnUndecorated);
		leftPane.getChildren().add(btnTransparent);
		leftPane.getChildren().add(btnUtility);

		// Modality  buttons
		Label lblModality = new Label("Modality");
		lblModality.setTextFill(Color.IVORY);
		lblModality.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		Button btnAppModal = new Button();
		btnAppModal.setText("Application Modal");
		btnAppModal.setOnAction(e -> launchStage(mainStage, Modality.APPLICATION_MODAL)); 
		Button btnWindowModal = new Button();
		btnWindowModal.setText("Window Modal");
		btnWindowModal.setOnAction(e -> launchStage(mainStage, Modality.WINDOW_MODAL));
		Button btnNotModal = new Button();
		btnNotModal.setText("Not Modal");
		btnNotModal.setOnAction(e -> launchStage(mainStage, Modality.NONE));
		
		// Place modality buttons in a HBox pane
		HBox bottomPane = new HBox(20); // 20 pixel spacing
		bottomPane.setStyle("-fx-background-color: rgb(25, 25, 130);");
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setPadding(new Insets(5,5,5,5)); // top, left, bottom, right
		bottomPane.getChildren().add(lblModality);
		bottomPane.getChildren().add(btnAppModal);
		bottomPane.getChildren().add(btnWindowModal);
		bottomPane.getChildren().add(btnNotModal);
		
		// Message buttons
		Button btnHello = new Button();
		btnHello.setText("Hello");
		btnHello.setMaxWidth(Double.MAX_VALUE);
		btnHello.setOnAction(e -> MessageBox.show("Hello World", "Message"));
		Button btnGoodbye = new Button();
		btnGoodbye.setText("Goodbye");
		btnGoodbye.setMaxWidth(Double.MAX_VALUE);
		btnGoodbye.setOnAction(e -> MessageBox.show("Goodbye Universe", "Message"));		
		Button btnSure = new Button();
		btnSure.setText("Sure?");
		btnSure.setMaxWidth(Double.MAX_VALUE);
		btnSure.setOnAction(e -> {
			Boolean answer = ConfirmationBox.show("Are you sure you want to do this?", 
					               "Confirmation", "Absolutely", "Certainly Not");
			MessageBox.show(answer.toString(), "Message"); 
			});
		Button btnClose = new Button();
		btnClose.setText("Close");
		btnClose.setStyle("-fx-background-color: DarkRed; -fx-text-fill: White;");
		btnClose.setMaxWidth(Double.MAX_VALUE);
		btnClose.setOnAction(e -> close(mainStage));
		
		// Place message buttons in a VBox
		VBox rightPane = new VBox(20); // 20 pixel spacing
		rightPane.setStyle("-fx-background-color: rgb(255, 25, 55);");
		rightPane.setAlignment(Pos.CENTER);
		rightPane.setPadding(new Insets(5,5,25,5)); // top, left, bottom, right		
		rightPane.getChildren().addAll(btnHello, btnGoodbye, btnSure, btnClose);
	
		// Put label in a FlowPane
		FlowPane topPane = new FlowPane();
		topPane.setPadding(new Insets(5,0,10,0));
		Label lbl = new Label("Types of Stages"); 
		lbl.setTextFill(Color.SADDLEBROWN);  // Red text via Color constant
		lbl.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
		topPane.getChildren().add(lbl);
		topPane.setAlignment(Pos.CENTER);
		
		// Place the controls in the areas of the Border Layout
		FlowPane centerPane = new FlowPane();
		centerPane.setStyle("-fx-background-color: BurlyWood;");
		pane.setTop(topPane);
		pane.setLeft(leftPane);
		pane.setCenter(centerPane);
		pane.setRight(rightPane);
		pane.setBottom(bottomPane);
	}


	private void launchStage(Stage mainStage, StageStyle style) {
		BorderPane pane = new BorderPane();
		pane.setCenter(new Label("This stage is of style " + style));
		Scene scene = new Scene(pane,400,100);
		Stage stage = new Stage(style);
		// Your pane might be Transparent, but the scene and pane will not be
		if (style == StageStyle.TRANSPARENT) {
			pane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.85);");
			scene.setFill(Color.TRANSPARENT);
		}
		stage.setScene(scene);
		stage.setTitle(style.toString());
		stage.initOwner(mainStage); // So this stage closes when Parent does
		stage.show();
	}
	
	private void launchStage(Stage mainStage, Modality modality) {
		BorderPane pane = new BorderPane();
		pane.setCenter(new Label("This stage is of modality " + modality));
		Scene scene = new Scene(pane,400,100);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(modality.toString());
		stage.initModality(modality);
		stage.initOwner(mainStage); // So this stage closes when Parent does
		stage.show();
	}

	private void setStage(Stage stage, Scene scene, Scene splash) 
			throws InterruptedException {
		// Use a splash scene by setting scenes and using a PauseTransition
		stage.setTitle("Using Stages");
		stage.setScene(splash);
		stage.show();
		PauseTransition pause = new PauseTransition(Duration.seconds(2));
		pause.setOnFinished(e -> stage.setScene(scene));
		pause.play();
	}
	
	private void close(Stage stage) {
		boolean reallyQuit = false;
		reallyQuit = ConfirmationBox.show("Are you sure you want to quit?",
				"Confirmation", "Yes", "No");
		if (reallyQuit)
		{
			// Perform cleanup tasks here
			// such as saving files or freeing resources
			stage.close(); 
		}
	}
}