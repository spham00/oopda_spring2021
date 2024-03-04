package college;

import java.text.DecimalFormat;

/**
 * The Player class represents a player who partakes in a board game with different properties.
 * 
 * @author 	Sarah Pham
 * @version	February 26th, 2021
 */
public class Player {

	String name;				// The name of the player.
	int numberOfClubs;			// The number of clubs the player is in.
	int numberOfFriends;		// The number of friends the player has.
	int money;					// The amount of money the player has.
	int happiness;				// The number of happiness points the player has.
	double gpa;					// The GPA the player has.
	int location;				// The location of the board square the player is on.
	
	private static DecimalFormat df = new DecimalFormat("0.00");	// The format of the player's GPA.
	
	/**
	 * Creates a player with the user-entered name and assigns their default values.
	 * 
	 * @param name	The name of the player.
	 */
	public Player(String name) {
		this.name = name;
		this.numberOfClubs = Game.NUMBER_OF_CLUBS;
		this.numberOfFriends = Game.NUMBER_OF_FRIENDS;
		this.money = Game.MONEY;
		this.happiness = Game.HAPPINESS;
		this.gpa = Game.GPA;
		this.location = 0;
	}
	
	/**
	 * Moves the location of the player a user-entered number of squares in the board game.
	 * 
	 * @param squares	The number of squares the player must move.
	 */
	public void move(int squares) {
		this.location += squares;
		if (this.location >= Game.LAST_SQUARE) this.location = Game.LAST_SQUARE;
		// Use System.err output stream to get red text!  No error here.
		System.err.println("\n" + Game.squareText.get(this.location));
		if (this.location == Game.LAST_SQUARE) getStats();
	}
	
	/**
	 * Moves the location of the player to a user-entered square number in the board game.
	 * 
	 * @param square	The location the player must move to.
	 */
	public void moveTo(int square) {
		this.location = square;
		if (this.location >= Game.LAST_SQUARE) this.location = Game.LAST_SQUARE;
		// Use System.err output stream to get red text!  No error here.
		System.err.println("\n" + Game.squareText.get(this.location));
		if (this.location == Game.LAST_SQUARE) getStats();
	}

	/**
	 * Calculates the difference of all the original property's values and the values after the board game has ended.
	 */
	private void getStats() {
		Double delta;
		System.out.println("\nFINAL RESULTS");
		delta = (double) (this.numberOfFriends - Game.NUMBER_OF_FRIENDS);
		outputStat("Number of Friends", delta); 
		delta = (double) (this.money - Game.MONEY );
		outputStat("Money", delta); 
		delta = (double) (this.happiness - Game.HAPPINESS );
		outputStat("Happiness", delta); 
		delta = (double) (this.gpa - Game.GPA);
		outputStat("GPA", delta); 
	}
	
	/**
	 * Tests and prints out whether the property has improved or worsened from the beginning of the game to the ending.
	 * 
	 * @param property	The property that has either improved or worsened.
	 * @param delta		The difference of the original property's value and the value after the game has ended.
	 */
	private void outputStat(String property, double delta) {
		if (delta > 0) {
			System.out.println("\t" + property + " improved!");
		}
		else if (delta < 0) {
			System.err.println("\t" + property + " worsened!");
		}
	}

	/**
	 * Returns the player's name.
	 * 
	 * @return	The player's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the player's name to the user-entered value.
	 * 
	 * @param name	The player's new name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the number of clubs the player is in.
	 * 
	 * @return	The number of clubs the player is in.
	 */
	public int getNumberOfClubs() {
		return numberOfClubs;
	}

	/**
	 * Sets the number of clubs the player is in to the entered value.
	 * 
	 * @param numberOfClubs	The new number of clubs the player is in.
	 */
	public void setNumberOfClubs(int numberOfClubs) {
		this.numberOfClubs = numberOfClubs;
	}

	/**
	 * Returns the number of friends the player has.
	 * 
	 * @return	The number of friends the player has.
	 */
	public int getNumberOfFriends() {
		return numberOfFriends;
	}

	/**
	 * Sets the number of friends the player has to the entered value.
	 * 
	 * @param numberOfFriends	The new number of friends the player has.
	 */
	public void setNumberOfFriends(int numberOfFriends) {
		this.numberOfFriends = numberOfFriends;
		if (this.numberOfFriends < 0) this.numberOfFriends = 0;
	}

	/**
	 * Returns the amount of money the player has.
	 * 
	 * @return	The amount of money the player has.
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Sets the amount of money the player has to the entered value.
	 * 
	 * @param money	The new amount of money the player has.
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Returns the number of happiness points the player has.
	 * 
	 * @return	The number of happiness points the player has.
	 */
	public int getHappiness() {
		return happiness;
	}

	/**
	 * Sets the number of happiness points the player has to the entered value.
	 * 
	 * @param happiness	The new number of happiness points the player has.
	 */
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	/**
	 * Returns the GPA the player has.
	 * 
	 * @return	The GPA the player has.
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * Sets the GPA the player has to the entered value; if they are above or below certain values,
	 * their values are changed.
	 * 
	 * @param gpa	The new GPA the player has.
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
		if (this.gpa < 0.0) this.gpa = 0.0;
		if (this.gpa > 4.0) this.gpa = 4.0;
	}

	/**
	 * Returns the location (board square) that the player is on.
	 * 
	 * @return	The location (board square) that the player is on.
	 */
	public int getLocation() {
		return location;
	}

	/**
	 * Sets the location (board square) of the player to an entered location.
	 * 
	 * @param location	The new location (board square) the player is moved to.
	 */
	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	/**
	 * Returns the information of the player.
	 * 
	 * @return	The information of the player.
	 */
	public String toString() {
		return name + ": [" + "numberOfClubs=" + numberOfClubs + ", numberOfFriends=" + numberOfFriends
				+ ", money=$" + money + ", happiness=" + happiness + ", gpa=" + df.format(gpa) + ", location=" + location + "]";
	}
	
	
}
