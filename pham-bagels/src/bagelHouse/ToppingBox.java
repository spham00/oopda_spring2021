package bagelHouse;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

/**
 * The ToppingBox class represents a box containing a title and checkboxes
 * pertaining to each topping. Each topping has a price.
 * 
 * @author Sarah Pham
 */
public class ToppingBox extends VBox {
	
	// The prices of each topping.
	// The prices of peach jelly and blueberry jam are kept as separate fields in case their
	// individual prices change.
	public final double CREAM_CHEESE = 0.50;
	public final double BUTTER = 0.25;
	public final double PEACH_JELLY = 0.75;
	public final double BLUEBERRY_JAM = 0.75;
	
	// The associated buttons.
	private CheckBox cbCream;
	private CheckBox cbButter;
	private CheckBox cbPeach;
	private CheckBox cbBlueberry;

	/**
	 * Creates the box filled with toppings checkboxes.
	 */
	public ToppingBox() {
		
		// Create the checkboxes.
		cbCream = new CheckBox("Cream cheese");
		cbButter = new CheckBox("Butter");
		cbPeach = new CheckBox("Peach jelly");
		cbBlueberry = new CheckBox("Blueberry jam");
		
		// Set certain buttons selected in the beginning according to demo on class page.
		cbButter.setSelected(true);
		cbBlueberry.setSelected(true);
		
		// Make a VBox for the toppings and adding the respective checkboxes.
		VBox vbox = new VBox(10);	// 10 pixel spacing
		vbox.setStyle("-fx-background-color: OldLace");
		this.setStyle("-fx-background-color: OldLace");
		vbox.getChildren().add(cbCream);
		vbox.getChildren().add(cbButter);
		vbox.getChildren().add(cbPeach);
		vbox.getChildren().add(cbBlueberry);
		
		// Make a Titled Pane to hold the title and Toppings VBox
		TitledPane titlePane = new TitledPane("Toppings", vbox);
		titlePane.setCollapsible(false);
		this.getChildren().add(titlePane);
		
	}
	
	/**
	 * Returns the cost of all the toppings selected.
	 * @return	The cost of all the toppings selected.
	 */
	public double getToppingsCost() {
		
		// This variable will be used to store the 
		double toppingCost = 0.0;
		
		// If toppings are selected, add their prices to the topping cost.
		if (cbCream.isSelected()) {
			toppingCost += CREAM_CHEESE;
		}
		if (cbButter.isSelected()) {
			toppingCost += BUTTER;
		}
		if (cbPeach.isSelected()) {
			toppingCost += PEACH_JELLY;
		}
		if (cbBlueberry.isSelected()) {
			toppingCost += BLUEBERRY_JAM;
		}
		
		// Return the total toppings cost.
		return toppingCost;
		
	}
	
}
