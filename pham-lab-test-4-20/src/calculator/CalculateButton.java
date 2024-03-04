package calculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CalculateButton extends HBox {
	
	private Button calculate;
	private Label lblDirections;

	public CalculateButton() {
		
		calculate = new Button("Calculate");
		lblDirections = new Label("Press button to perform calculation");
		
		HBox buttonAndText = new HBox(5);
		buttonAndText.setPadding(new Insets(0,10,15,10));
		buttonAndText.getChildren().add(calculate);
		buttonAndText.getChildren().add(lblDirections);
		
		this.getChildren().add(buttonAndText);
		
	}

	// Getters and setters
	public Button getCalculate() {
		return calculate;
	}

	public void setCalculate(Button calculate) {
		this.calculate = calculate;
	}

	public Label getLblDirections() {
		return lblDirections;
	}

	public void setLblDirections(Label lblDirections) {
		this.lblDirections = lblDirections;
	}

}
