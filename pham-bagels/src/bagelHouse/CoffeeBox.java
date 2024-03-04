package bagelHouse;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * The CoffeeBox class represents a box containing a title and buttons
 * pertaining to each coffee drink. Each coffee drink has a price.
 * 
 * @author Sarah Pham
 */
public class CoffeeBox extends VBox {
	
	// The prices for each coffee drink. The "NONE" option isn't included.
	// The regular and decaf coffee prices are separate fields since their individual prices
	// may change in the future.
	public final double REGULAR = 1.25;
	public final double DECAF = 1.25;
	public final double CAPPUCCINO = 2.00;
	
	// The radio buttons for each option.
	private RadioButton rdoNone;
	private RadioButton rdoRegular;
	private RadioButton rdoDecaf;
	private RadioButton rdoCappuccino;
	
	// Creates a ToggleGroup so that only one button can be selected at a time.
	private ToggleGroup tg;

	/**
	 * Creates the box filled with coffee drink radio buttons.
	 */
	public CoffeeBox() {
		
		// Creates the group for the radio buttons.
		tg = new ToggleGroup();
		
		// Creates the radio buttons for the coffee drinks.
		rdoNone = new RadioButton("None");
		rdoRegular = new RadioButton("Regular coffee");
		rdoDecaf = new RadioButton("Decaf coffee");
		rdoCappuccino = new RadioButton("Cappuccino");
		
		// Adds the radio buttons to the toggle group.
		rdoNone.setToggleGroup(tg);
		rdoRegular.setToggleGroup(tg);
		rdoDecaf.setToggleGroup(tg);
		rdoCappuccino.setToggleGroup(tg);
		
		// Sets a certain button selected in the beginning according to demo on class page.
		rdoDecaf.setSelected(true);
		
		// Creates the vbox to display all the buttons in.
		VBox vbox = new VBox(10);  // 10 pixel spacing
		vbox.setStyle("-fx-background-color: BlanchedAlmond;");
		this.setStyle("-fx-background-color: BlanchedAlmond;");
		vbox.getChildren().add(rdoNone);
		vbox.getChildren().add(rdoRegular);
		vbox.getChildren().add(rdoDecaf);
		vbox.getChildren().add(rdoCappuccino);
		
		// Make a Titled Pane to hold the title and Coffee VBox
		TitledPane titlePane = new TitledPane("Coffee", vbox);
		titlePane.setCollapsible(false);
		this.getChildren().add(titlePane);
		
	}
	
	/**
	 * Returns the cost of the coffee selected.
	 * @return	The cost of the coffee selected.
	 */
	public double getCoffeeCost() {
		
		// This variable will be used to store the 
		double coffeeCost = 0.0;
		
		// Sets the coffee cost as whatever button was picked.
		// No need to check for none because it just means 0.0, which is
		// the default value of coffeeCost.
		if (rdoRegular.isSelected()) {
			coffeeCost = REGULAR;
		}
		else if (rdoDecaf.isSelected()) {
			coffeeCost = DECAF;
		}
		else if (rdoCappuccino.isSelected()) {
			coffeeCost = CAPPUCCINO;
		}
		
		// Returns the cost of the coffee selected.
		return coffeeCost;
		
	}

}
