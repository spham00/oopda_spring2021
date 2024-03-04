package calculator;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Calculator extends HBox {
	
	private TextField standard;
	private TextField sample;
	private TextField redness;
	
	private Label lblStandard;
	private Label lblSample;
	private Label lblRedness;

	public Calculator() {
		
		standard = new TextField();
		sample = new TextField();
		redness = new TextField();
		
		lblStandard = new Label("R value of standard");
		lblSample = new Label("R value of sample");
		lblRedness = new Label("degree of redness");
		
		// Creating the top text fields
		HBox topTextFields = new HBox(5);
		topTextFields.setPadding(new Insets(15,10,15,10));
		topTextFields.getChildren().addAll(lblStandard, standard, lblSample, sample, lblRedness, redness);
		
		this.getChildren().add(topTextFields);
	}

	// Getters and setters
	public TextField getStandard() {
		return standard;
	}

	public void setStandard(TextField standard) {
		this.standard = standard;
	}

	public TextField getSample() {
		return sample;
	}

	public void setSample(TextField sample) {
		this.sample = sample;
	}

	public TextField getRedness() {
		return redness;
	}

	public void setRedness(TextField redness) {
		this.redness = redness;
	}

	public Label getLblStandard() {
		return lblStandard;
	}

	public void setLblStandard(Label lblStandard) {
		this.lblStandard = lblStandard;
	}

	public Label getLblSample() {
		return lblSample;
	}

	public void setLblSample(Label lblSample) {
		this.lblSample = lblSample;
	}

	public Label getLblRedness() {
		return lblRedness;
	}

	public void setLblRedness(Label lblRedness) {
		this.lblRedness = lblRedness;
	}

}
