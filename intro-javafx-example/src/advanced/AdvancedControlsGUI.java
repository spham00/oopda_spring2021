package advanced;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import registrar.BannerGUI_Complete.SectionRow;

/**
 *  Demonstration of various controls
 */

public class AdvancedControlsGUI extends Application{
	
	public static void main(String[] args) {
		/* static method inherited from Application class that creates
		 * an instance of the Application class and starts the JavaFX lifecycle. */
		launch(args);
	}
	
	@Override
	public void init() {
		System.out.printf("init() called on thread %s%n", Thread.currentThread());
	}

	@Override public void start(Stage mainStage) throws InterruptedException {
		System.out.printf("start() called on thread %s%n", Thread.currentThread());
		BorderPane mainPane = new BorderPane();     // make layout to hold controls
		setupControls(mainPane);                    // initialize and place controls
		Scene scene = new Scene(mainPane);	        // Setup the main scene
		setStage(mainStage, scene);                 // Finalize and show the stage
	}
	
	@Override
	public void stop() {
		System.out.printf("stop() called on thread %s%n", Thread.currentThread());
	}
	
	private void setupControls(BorderPane mainPane) {
		TreeView<String> treeView1 = new TreeView<String>();
		buildTree(treeView1);
		
		TreeView<String> treeView2 = new TreeView<String>();
		treeView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		buildTree(treeView2);
		
		mainPane.setLeft(treeView1);
		mainPane.setRight(treeView2);
		
		TableView<Song> songView = new TableView<Song>();    
		ArrayList<Song> songs = new ArrayList<Song>();
		loadSongs(songs);
		
		// Setup the table columns
		TableColumn<Song, String> colTitle = 
				new TableColumn<Song, String>("Song Title");
		colTitle.setMinWidth(140);
		colTitle.setCellValueFactory(
				new PropertyValueFactory<Song, String>("Title")); 
				
		TableColumn<Song, String> colArtist = 
				new TableColumn<Song, String>("Artist");
		colArtist.setMinWidth(100);
		colArtist.setCellValueFactory(
				new PropertyValueFactory<Song, String>("Artist")); 

		TableColumn<Song, Integer> colReleaseYear =
				new TableColumn<Song, Integer>("Released");
		colReleaseYear.setMinWidth(60);
		colReleaseYear.setCellValueFactory(
				new PropertyValueFactory<Song, Integer>("ReleaseYear")); 
		
		TableColumn<Song, String> colMovie = 
				new TableColumn<Song, String>("Featured Movie");
		colMovie.setMinWidth(120);
		colMovie.setCellValueFactory(
				new PropertyValueFactory<Song, String>("FeaturedMovieTitle")); 
		
		songView.getColumns().addAll(colTitle, colArtist, colReleaseYear, colMovie);
		songs.forEach(song -> songView.getItems().add(song));
	
		mainPane.setBottom(songView);
	
		Slider tempSlider = new Slider();
		tempSlider.setOrientation(Orientation.HORIZONTAL);
		tempSlider.setShowTickMarks(true);
		tempSlider.setShowTickLabels(true);
		tempSlider.setMajorTickUnit(10);
		tempSlider.setMinorTickCount(1);
		tempSlider.setMax(120);
		tempSlider.setMin(-40);
		tempSlider.setValue(70);
		
		Label lblInstructions = new Label("What is the current temperature?");
		Label lblTemp = new Label("70");
		DecimalFormat formatter = new DecimalFormat("#.#");
		tempSlider.valueProperty().addListener( (observable, oldvalue, newvalue) -> 
										lblTemp.setText(formatter.format(newvalue).toString()));
		HBox top = new HBox(20);
		top.getChildren().addAll(lblInstructions, tempSlider, lblTemp);
		mainPane.setTop(top);
		
	}
	
	private void buildTree(TreeView<String> treeView) {

		List<String> starks = Arrays.asList("Eddard", "Benjen", "Lyanna",
				"Catelyn", "Robb", "Sansa", "Arya", "Bran", "Rickon", 
				"Jon Snow");
		List<String> targaryens = Arrays.asList("Aegon", "Aemon", "Aerys",
				"Rhaeger", "Viserys", "Daenerys");		
		List<String> lannisters = Arrays.asList("Tywin", "Cersei", "Jamie",
				"Tyrion", "Joffrey", "Myrcella", "Tommen", "Kevan", "Lancel");
		List<String> baratheons = Arrays.asList("Robert", "Stannis", "Selyse",
				"Renly", "Shireen", "Gendry");	
		List<String> tyrells= Arrays.asList("Mace", "Loras", "Margaery", "Olenna");
		
		TreeItem<String> rootItem = new TreeItem<String>("Pick Your Favorite");
		rootItem.setExpanded(true);

		TreeItem<String> starkItem = new TreeItem<String>("Whom Do You Like?");
		starks.forEach(name -> 
			starkItem.getChildren().add(new TreeItem<String>(name)));
		rootItem.getChildren().add(starkItem);

		TreeItem<String> lannisterItem = new TreeItem<String>("Lannister");
		rootItem.getChildren().add(lannisterItem);
		lannisters.forEach(name -> 
			lannisterItem.getChildren().add(new TreeItem<String>(name)));
		
		TreeItem<String> targaryenItem = new TreeItem<String>("Targaryens");
		rootItem.getChildren().add(targaryenItem);
		targaryens.forEach(name -> 
			targaryenItem.getChildren().add(new TreeItem<String>(name)));	
		
		TreeItem<String> baratheonItem = new TreeItem<String>("Baratheons");
		rootItem.getChildren().add(baratheonItem);
		baratheons.forEach(name -> 
			baratheonItem.getChildren().add(new TreeItem<String>(name)));
		
		TreeItem<String> tyrellItem = new TreeItem<String>("Tyrells");
		rootItem.getChildren().add(tyrellItem);
		tyrells.forEach(name -> 
			tyrellItem.getChildren().add(new TreeItem<String>(name)));
		
		treeView.setRoot(rootItem); // set the root of the treeview	
	}
	
	private void loadSongs(ArrayList<Song> songs) {
		Song song1 = new Song("Don't Stop Me Now", "Queen", 1978, new Movie("Bohemian Rhapsody"));
		String relevantLyric = "I'm burnin' through the sky, yeah" + System.lineSeparator() + 
				"Two hundred degrees" + System.lineSeparator() +
				"That's why they call me Mister Fahrenheit" + System.lineSeparator() +
				"I'm traveling at the speed of light" + System.lineSeparator() +
				"I wanna make a supersonic man out of you";	
		song1.setRelevantLyric(relevantLyric);

		Song song2 = new Song("Comfortably Numb", "Pink Floyd", 1979, new Movie("The Departed"));
		relevantLyric = "There is no pain you are receding" + System.lineSeparator() +
				"A distant ship's smoke on the horizon" + System.lineSeparator() +
				"You are the only coming through in waves" + System.lineSeparator() +
				"Your lips move but I can't hear what you're saying";
		song2.setRelevantLyric(relevantLyric);
		
		Song song3 = new Song("It's No Good", "Depeche Mode", 1997, new Movie("Aquaman"));
		relevantLyric = "It is written in the stars above" + System.lineSeparator() +
				"The gods decree" + System.lineSeparator() +
				"You'll be right here by my side" + System.lineSeparator() +
				"Right next to me";
		song2.setRelevantLyric(relevantLyric);
	
		Movie marvel = new Movie("Captain Marvel");
		
		Song song4 = new Song("Man on the Moon", "R.E.M", 1992, marvel);
		relevantLyric = "Moses went walking with the staff of wood (yeah, yeah, yeah, yeah)" + System.lineSeparator() +
				"Newton got beaned by the apple good (yeah, yeah, yeah, yeah)" + System.lineSeparator() +
				"Egypt was troubled by the horrible asp (yeah, yeah, yeah, yeah)" + System.lineSeparator() + 
				"Mister Charles Darwin had the gall to ask (yeah, yeah, yeah, yeah)";
		song4.setRelevantLyric(relevantLyric);
		
		Song song5 = new Song("Come As You Are", "Nirvana", 1991, marvel);
		relevantLyric = "Come doused in mud, soaked in bleach" + System.lineSeparator() + 
				"As I want you to be" + System.lineSeparator() + 
				"As a trend, as a friend" + System.lineSeparator() + 
				"As an old memoria";
		song5.setRelevantLyric(relevantLyric);
		
		songs.addAll(Arrays.asList(song5, song4, song3, song2, song1));
	}
	
	private void setStage(Stage stage, Scene scene) {
		stage.setTitle("Advanced Controls");
		stage.setScene(scene);
		stage.show();		
	}
}