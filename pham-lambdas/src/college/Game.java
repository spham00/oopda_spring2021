package college;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * The Game class represents a board game simulating a college process from orientation to graduation.
 * 
 * @author 	Sarah Pham
 * @version	February 26th, 2021
 */
public class Game {
	
	public static final int NUMBER_OF_CLUBS = 0;		// The number of clubs the player is in.
	public static final int NUMBER_OF_FRIENDS = 1;		// The number of friends the player has.
	public static final int MONEY = 225;				// The amount of money the player has.
	public static final int HAPPINESS = 20;				// The number of happiness points the player has.
	public static final double GPA = 3.0;				// The GPA the player has.
	public static final int LAST_SQUARE = 26;			// The location of the last square.
	
	/**
	 * The location and the corresponding text of each square on the board game.
	 */
	public static HashMap<Integer, String> squareText = new HashMap<Integer, String>();
	static {
		squareText.put(1, "Fall asleep in class.");
		squareText.put(2, "Roommate comforts you.");
		squareText.put(3, "Roommate needs a loan.");
		squareText.put(4, "Skip class to travel to New York.");
		squareText.put(5, "Pull an all nighter.");
		squareText.put(6, "Move ahead two spaces.");
		squareText.put(7, "Join a club.");
		squareText.put(8, "Help classmate study.");
		squareText.put(9, "Kick ass on midterms.");
		squareText.put(10, "Throw major party.");
		squareText.put(11, "Get caught buying paper from web.");
		squareText.put(12, "Roommate pays you back - with interest!");
		squareText.put(13, "Lose a friend.");
		squareText.put(14, "Join a club.");
		squareText.put(15, "Turn research entrepeneurial.");
		squareText.put(16, "Fail DSA");
		squareText.put(17, "Dean discovers your illegal party.");
		squareText.put(18, "Win eSports tournament.");
		squareText.put(19, "Join Honors Club.");
		squareText.put(20, "Gain 2 friends.");
		squareText.put(21, "Robbed!");
		squareText.put(22, "Study hard for Calculus III.");
		squareText.put(23, "Senioritis!");
		squareText.put(24, "Borry money from friend; forget to repay.");
		squareText.put(25, "Get graduation gift from Aunt June.");
		squareText.put(26, "GRADUATED!");
	}
	
	/**
	 * The location and the corresponding effect of each square on the board game.
	 */
	public static HashMap<Integer, Consumer<Player>> squareEffects = new HashMap<Integer, Consumer<Player>>();
	static {
		squareEffects.put(1, play -> play.setGpa(play.getGpa() * 0.90));
		squareEffects.put(2, play -> play.setHappiness(play.getHappiness() + 5));
		squareEffects.put(3, play -> play.setMoney(play.getMoney() - 200));
		squareEffects.put(4, play -> {
			play.setHappiness(play.getHappiness() + 10);
			play.setGpa(play.getGpa() - 0.2);
		});
		squareEffects.put(5, play -> {
			play.setHappiness(play.getHappiness() - 3);
			play.setGpa(play.getGpa() + 0.1);
		});
		squareEffects.put(6, play -> {
			play.move(2);
			effect_eight(play);
		});
		squareEffects.put(7, play -> play.setNumberOfClubs(play.getNumberOfClubs() + 1));
		squareEffects.put(8, play -> effect_eight(play));
		squareEffects.put(9, play -> play.setGpa(play.getGpa() * 1.2));
		squareEffects.put(10, play -> {
			play.setNumberOfFriends(play.getNumberOfFriends() + 2);
			play.setMoney(play.getMoney() - 100);
		});
		squareEffects.put(11, play -> {
			play.setMoney(play.getMoney() - 100);
			play.setGpa(play.getGpa() - 0.5);
		});
		squareEffects.put(12, play -> play.setMoney(play.getMoney() + 220));
		squareEffects.put(13, Game::effect_thirteen);
		squareEffects.put(14, play -> play.setNumberOfClubs(play.getNumberOfClubs() + 1));
		squareEffects.put(15, play -> {
			play.setGpa(play.getGpa() + 0.8);
			play.setMoney(play.getMoney() + 2000);
		});
		squareEffects.put(16, play -> {
			play.move(-3);
			play.setGpa(play.getGpa() - 0.5);
			effect_thirteen(play);
		});
		squareEffects.put(17, play -> play.setHappiness(play.getHappiness() - 12));
		squareEffects.put(18, play -> {
			play.setHappiness(play.getHappiness() + 10);
			play.setMoney(play.getMoney() + 1000);
		});
		squareEffects.put(19, play -> play.setGpa(play.getGpa() + 1.0));
		squareEffects.put(20, play -> play.setNumberOfFriends(play.getNumberOfFriends() + 2));
		squareEffects.put(21, play -> play.setMoney(play.getMoney() - 300));
		squareEffects.put(22, play -> {
			play.setHappiness(play.getHappiness() - 7);
			play.setGpa(play.getGpa() + 0.3);
		});
		squareEffects.put(23, play -> {
			play.setGpa(play.getGpa() * 0.8);
			play.setMoney(play.getMoney() - 400);
		});
		squareEffects.put(24, play -> {
			play.setMoney(play.getMoney() + 150);
			play.setNumberOfFriends(play.getNumberOfFriends() - 1);
		});
		squareEffects.put(25, play -> {
			play.setMoney(play.getMoney() + 750);
			play.setHappiness(play.getHappiness() + 15);
		});
	}

	/**
	 * Simulates the roll of a 6-sided die.
	 * 
	 * @return	A random value of the 6-sided die.
	 */
	public static int roll() {
	   return (int)(Math.random()*6+1);
	}

	/**
	 * Contains the effect for square eight.
	 * 
	 * @param play	The player affected by the effect.
	 */
	private static void effect_eight(Player play) {
		play.setNumberOfFriends(play.getNumberOfFriends() + 1);
	}
	
	/**
	 * Contains the effect for square thirteen.
	 * 
	 * @param play	The player affected by the effect.
	 */
	private static void effect_thirteen(Player play) {
		play.setNumberOfFriends(play.getNumberOfFriends() - 1);
	}
}
