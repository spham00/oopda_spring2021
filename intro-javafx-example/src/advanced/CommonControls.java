package advanced;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *  Demonstration of various controls
 */

public class CommonControls extends Application{

	public static void main(String[] args) {
		/* static method inherited from Application class that creates
		 * an instance of the Application class and starts the JavaFX lifecycle. */
		launch(args);
	}

	@Override public void start(Stage mainStage) throws InterruptedException {
		List<Song> songs = makeSongs();
		BorderPane mainPane = new BorderPane();     // make layout to hold controls
		setupControls(mainPane, songs);  // initialize and place controls
		Scene scene = new Scene(mainPane);	        // Setup a Splash Screen
		setStage(mainStage, scene);                 // Finalize and show the stage
	}

	private List<Song> makeSongs() {

		// This method makes the songs for the GUI to demonstrate GUIs with objects.
		// But is this REALLY the correct place to make a list of songs?

		Song song1 = new Song("Don't Stop Me Now", "Queen");
		String relevantLyric = "I'm burnin' through the sky, yeah" + System.lineSeparator() + 
				"Two hundred degrees" + System.lineSeparator() +
				"That's why they call me Mister Fahrenheit" + System.lineSeparator() +
				"I'm traveling at the speed of light" + System.lineSeparator() +
				"I wanna make a supersonic man out of you";
		song1.setRelevantLyric(relevantLyric);
		Song song2 = new Song("Song 2", "Blur");
		song2.setRelevantLyric("Woo hoo!" + System.lineSeparator() +
				"Woo hoo!" + System.lineSeparator() +
				"Woo hoo!" + System.lineSeparator() +
				"Woo hoo!");
		Song song3 = new Song("This is America", "Childish Gambino");
		song3.setRelevantLyric("We just wanna party" + System.lineSeparator() +
				"Party just for you" + System.lineSeparator() +
				"We just want the money" + System.lineSeparator() +
				"Money just for you (Yeah)");
		Song song4 = new Song("Pigs (Three Different Ones)", "Pink Floyd");
		song4.setRelevantLyric("Hey you, Whitehouse," + System.lineSeparator() +
				"Ha ha charade you are." + System.lineSeparator() +
				"You house proud town mouse," + System.lineSeparator() +
				"Ha ha charade you are");
		List<Song> songs = Arrays.asList(song1, song2, song3, song4);
		return songs;
	}

	private void setupControls(BorderPane mainPane, List<Song> songs) {
		// Create labels
		Label label1 = new Label("I am label1.");
		Label label2 = new Label("I am label2.");
		Label lblTextfield = new Label("Type something, then hit TAB or ENTER.");

		// Create buttons
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");

		// Create radio buttons
		RadioButton rButton1 = new RadioButton("1 potato");
		RadioButton rButton2 = new RadioButton("2 potato");
		RadioButton rButton3 = new RadioButton("3 potato");

		ToggleGroup radioButtonGroup = new ToggleGroup();

		rButton1.setToggleGroup(radioButtonGroup);
		rButton2.setToggleGroup(radioButtonGroup);
		rButton3.setToggleGroup(radioButtonGroup);

		// Create checkboxes
		CheckBox checkbox1 = new CheckBox("Send me spam");

		// Create TextField
		TextField textfield1 = new TextField("I am textfield 1.");
		TextField textfield2 = new TextField();

		// Create TextAreas
		TextArea textarea1 = new TextArea("I am text area 1");
		TextArea textarea2 = new TextArea("I am text area 2");

		String longcomment = " and I will add a scroll bar if the text you place in me gets to be too long.";

		textarea1.setPrefRowCount(6);
		textarea1.setPrefHeight(20);
		textarea1.setWrapText(true);
		textarea2.setPrefRowCount(6);
		textarea2.setPrefHeight(100);
		textarea2.setWrapText(true);
		textarea2.setText(textarea2.getText() + longcomment);

		// Create choice boxes
		ChoiceBox<String> choice1 = new ChoiceBox<String>();
		choice1.getItems().addAll("EDM", "Rock", "Country", "Hip-Hop/Rap");
		choice1.setValue("Rock");
		ChoiceBox<Song> choice2 = new ChoiceBox<Song>();
		songs.forEach(song -> choice2.getItems().add(song));

		// Create combo boxes
		ComboBox<String> combo1 = new ComboBox<String>();
		combo1.getItems().addAll("Haunting at Hill House", "60 Minutes", "Game of Thrones", "Black Mirror");
		combo1.setPromptText("Favorite TV Show?");
		ComboBox<Song> combo2 = new ComboBox<Song>();
		combo2.setPromptText("Pick a song");
		songs.forEach(song -> combo2.getItems().add(song));

		// Create list control
		ListView<String> list1 = new ListView<String>();
		list1.setOrientation(Orientation.HORIZONTAL);
		list1.getItems().addAll("Visa", "MasterCard", "Discover", "AMEX" );
		list1.setMaxHeight(30);
		ListView<String> list2 = new ListView<String>();
		list2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list2.setMaxHeight(120);
		list2.getItems().addAll("Haunting at Hill House", "60 Minutes", "Game of Thrones", "Black Mirror");

		HBox topControls = new HBox(20);
		topControls.setPadding(new Insets(0,0,20,0));
		topControls.getChildren().addAll(label1, button1, label2, button2,
				rButton1, rButton2, rButton3, 
				textfield1, checkbox1);

		HBox textAreas = new HBox(10);
		textAreas.getChildren().addAll(textarea1, textarea2);
		textAreas.setPadding(new Insets(20,0,0,0));

		HBox choices = new HBox(15);
		choices.getChildren().addAll(choice1, choice2, lblTextfield, textfield2);

		HBox combos = new HBox(15);
		combos.getChildren().addAll(combo1, combo2); 

		HBox lists = new HBox(15);
		lists.getChildren().addAll(list1, list2); 

		// And now a VBox inside an HBox

		VBox otherControls = new VBox(20);
		otherControls.getChildren().addAll(choices, combos, lists);

		mainPane.setPadding(new Insets(20,20,20,20));
		mainPane.setTop(topControls);
		mainPane.setBottom(textAreas);
		mainPane.setCenter(otherControls);	

		// Now setup listeners
		rButton1.selectedProperty().addListener(e -> showPotatoes(e, textarea1));
		rButton2.selectedProperty().addListener(e -> showPotatoes(e, textarea1));
		rButton3.selectedProperty().addListener(e -> showPotatoes(e, textarea1)); 

		checkbox1.selectedProperty().addListener(
				(v, oldValue, newValue) -> textfield1.setText(
						newValue ? "Spam on the way" : "No spam for you!"));

		choice1.getSelectionModel().selectedItemProperty().addListener( 
				(v, oldValue, newValue) -> textarea1.setText(newValue)); 
		choice2.getSelectionModel().selectedItemProperty().addListener( 
				(v, oldValue, newValue) -> textarea2.setText(newValue.getRelevantLyric())); 

		combo1.setOnAction(e -> textarea1.setText(combo1.getValue()));
		combo2.setOnAction(e -> textarea2.setText(combo2.getValue().getRelevantLyric()));

		textfield2.setOnKeyPressed(e -> checkForCompletion(e, textfield2, textarea1));

	}

	private void showPotatoes(Observable e, TextArea textarea) {
		textarea.setText("Mr. Potato Head");
		if (e.toString().contains("2 potato")) {
			textarea.setText(textarea.getText() + System.lineSeparator() +"Mrs. Potato Head");
		}
		if (e.toString().contains("3 potato")) {
			textarea.setText(textarea.getText() + System.lineSeparator() + "Mrs. Potato Head" +
					System.lineSeparator() + "Spud, Jr.");
		}
	}
	
	private void checkForCompletion(KeyEvent e, TextField textField, TextArea textArea) {
		if (e.getCode().equals(KeyCode.ENTER) ||
				e.getCode().equals(KeyCode.TAB)) {
			textArea.setText("You just entered '" + textField.getText() + "' in the TextField.");
		}
	}

	private void setStage(Stage stage, Scene scene) {
		stage.setTitle("Common Controls");
		stage.setScene(scene);
		stage.show();		
	}


}