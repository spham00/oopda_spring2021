package college;

import java.util.Scanner;

/**
 * The CollegeDriver class is used to test and play the board game.
 * 
 * @author 	Sarah Pham
 * @version	February 26th, 2021
 */
public class CollegeDriver {

	private static Player player = new Player("Chris");		// The player of the game.
	private static Scanner sc = new Scanner(System.in);		// Scans the input to decide whether to test or play.

	public static void main(String[] args)  {
		
		System.out.println("Type T to test, or any other character to play.");
		String answer = sc.nextLine();
		try {
			if (answer.toUpperCase().equals("T")) test();
			else play();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Moves the player through each square of the board game, and a dummy through the movement squares.
	 * 
	 * @throws InterruptedException
	 */
	private static void test() throws InterruptedException {
		while (player.getLocation() < Game.LAST_SQUARE) {
			player.move(1);
			if (player.getLocation() == 16 || player.getLocation() == 6) {
				// These squares move a player, but don't actually move the test player
				// Instead show the effect on a dummy player
				Player dummy = new Player("dummy");
				dummy.setLocation(player.getLocation());		// So the change in location can be seen.
				System.out.println(dummy);	
				Game.squareEffects.get(dummy.getLocation()).accept(dummy);	// Changing the location.
				System.out.println(dummy);
			}
			else {
				if (player.getLocation() < Game.LAST_SQUARE) {
					Game.squareEffects.get(player.getLocation()).accept(player);
					System.out.println(player);
				}
			}
			Thread.sleep(100);
	}
}		
	
	/**
	 * Plays the game until the last square is reached in the board game.
	 * 
	 * @throws InterruptedException
	 */
	private static void play() throws InterruptedException {
		while (player.getLocation() < Game.LAST_SQUARE) {
			player.move(Game.roll());
			if (player.getLocation() < Game.LAST_SQUARE) {
				Game.squareEffects.get(player.getLocation()).accept(player);
				System.out.println(player);
			}
			Thread.sleep(100);
		}
	}
}
