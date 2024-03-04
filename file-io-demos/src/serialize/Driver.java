package serialize;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		switch (getMenuOption(sc)) {
			case 'a': {
				Instructions.display();
				break;
			}
			case 'b': {
				SerializePlayer1.serializePlayer();
				break;
			}
			case 'c': {
				SerializePlayer2.serializePlayer();
				break;
			}
			case 'd': {
				DeserializeDemo.deserializePlayers();
				break;
			}
			default: {
				System.out.println("Invalid option.");
			}
		}

	}
	private static char getMenuOption(Scanner sc) {
		System.out.println("\nMenu choices:");
		System.out.println("A.  Display instructions");
		System.out.println("B.  Serialize Player 1");
		System.out.println("C.  Serialize Player 2");
		System.out.println("D.  Deserialize both players");
		System.out.print("Enter option: ");
		return sc.nextLine().toLowerCase().charAt(0);
	}
}