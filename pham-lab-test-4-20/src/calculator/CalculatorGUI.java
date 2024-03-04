package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// NOTE: User must press Enter for the value to be checked
public class CalculatorGUI extends Application {
	
	Calculator calculator = new Calculator();
	CalculateButton button = new CalculateButton();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
	}

	@Override
	public void start (Stage mainStage) {
		BorderPane mainPane = new BorderPane();
		setupControls(mainPane);
		Scene scene = new Scene(mainPane);
		setStage(mainStage, scene);
	}
	
	@Override
	public void stop() {
	}
	
	private void setupControls(BorderPane mainPane) {
		mainPane.setTop(calculator); 
		button.setPadding(new Insets(0,200,0,200));	// Placeholder to put it in the middle
		mainPane.setBottom(button);
		
		calculator.getStandard().setOnKeyPressed(e -> {
			try {
				testing(e, calculator.getStandard().getText(), calculator.getStandard());
				defaultDirections();
			} catch (ColorOutOfRangeException e1) {
				button.getLblDirections().setText("One or both of the values are not integers");
			};
		});
		
		calculator.getSample().setOnKeyPressed(e -> {
			try {
				testing(e, calculator.getSample().getText(), calculator.getSample());
				defaultDirections();
			} catch (ColorOutOfRangeException e1) {
				button.getLblDirections().setText("One or both of the values are not integers");
			}
		});
		
		button.getCalculate().setOnAction(e -> calculate());
 	}
	
	private void setStage(Stage stage, Scene scene) {
		stage.setTitle("Redness Calculator");
		stage.setScene(scene);
		stage.show();
	}
	
	private void calculate() {
		int standard;
		int sample;
		int degree;
		
		standard = Integer.parseInt(calculator.getStandard().getText());
		sample = Integer.parseInt(calculator.getSample().getText());
		
		degree = (sample / standard) * 100;
		
		calculator.getRedness().setText(degree + "%");
	}
	
	private void testing(KeyEvent e, String s, TextField t) throws ColorOutOfRangeException {
		if (e.getCode().equals(KeyCode.ENTER)) {
			int i;
			try {
				i = Integer.parseInt(s);
				if (i < 0 || i > 255) {
					throw new ColorOutOfRangeException("ERROR: Color out of range");
				}
			}
			finally {
				t.setText(s);
			}
		}
	}
	
	private void defaultDirections() {
		button.getLblDirections().setText("Press button to perform calculation.");
	}
}
