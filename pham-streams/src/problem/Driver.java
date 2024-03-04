package problem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class Driver represents an animal shelter that lists different search criteria
 * of the animals there.
 * 
 * @author	Sarah Pham
 */
public class Driver {

	/**
	 * Sets up the shelter and a welcome message.
	 * Also allows for the user to make a choice on what kinds of pets to see.
	 */
	public static void main(String[] args) {
		Shelter shelter = new Shelter();
		shelter.initialize();
		ArrayList<Pet> pets = shelter.getPets();
		
		System.out.println("Welcome to Sarah's Animal Shelter!");
		
		char choice;
		Scanner sc = new Scanner(System.in);
		do {
			choice = getOption(sc);
			takeAction(choice, pets);
		}
		while (choice != 'X');
	}
	
	/**
	 * Lists the search criteria options available to the user.
	 * 
	 * @param sc	The scanner that takes the choice of the user.
	 * @return		The user's choice.
	 */
	private static char getOption(Scanner sc) {
		System.out.println("\nPlease enter a search criteria or exit menu option!");
		System.out.println("\t1.  The kitten");
		System.out.println("\t2.  Not a puppy person");
		System.out.println("\t3.  The guard dog");
		System.out.println("\t4.  Old friend");
		System.out.println("\tX.  Exit the animal shelter");
		return sc.next().toUpperCase().charAt(0);
	}
	
	/**
	 * Filters and prints the animals according to the user's choice.
	 * 
	 * @param choice	The search criteria chosen by the user.
	 * @param pets		The list of pets that will be filtered through accordingly.
	 */
	private static void takeAction(char choice, ArrayList<Pet> pets) {
		switch(choice) {
		case('1'):
			System.out.println("\nThis option returns female kittens less than 1 years old, not declawed, and not litterbox trained.");
			pets.stream().filter(p -> p instanceof Cat)
						.filter(p -> p.getSex() == 'f')
						.filter(p -> p.getAge() < 1)
						.filter(p -> !((Cat)p).isDeclawed())
						.filter(p -> !((Cat)p).isLitterBoxTrained())
						.forEach(System.out::println);
			break;
		case('2'):
			System.out.println("\nThis option returns non-pitbull dogs at least 4 years old, house-trained, and not aggressive.");
			pets.stream().filter(p -> p instanceof Dog)
						.filter(p -> p.getAge() >= 4)
						.filter(p -> ((Dog)p).isFixed())
						.filter(p -> !((Dog)p).getBreed().equalsIgnoreCase("pitbull"))
						.filter(p -> ((Dog)p).isHouseTrained())
						.filter(p -> !((Dog)p).isAggressive())
						.forEach(System.out::println);
			break;
		case('3'):
			System.out.println("\nThis option returns male dogs at most 6 years old, over 50 pounds, house trained, and aggressive.");
			pets.stream().filter(p -> p instanceof Dog)
						.filter(p -> p.getSex() == 'm')
						.filter(p -> p.getAge() <= 6)
						.filter(p -> ((Dog)p).getWeight() > 50)
						.filter(p -> ((Dog)p).isHouseTrained())
						.filter(p -> ((Dog)p).isAggressive())
						.forEach(System.out::println);
			break;
		case('4'):
			System.out.println("\nThis option returns any pet at least 8 years old.");
			pets.stream().filter(p -> p.getAge() >= 8)
						.forEach(System.out::println);
			break;
		case('X'):
			System.out.println("\nThank you for visiting Sarah's Animal Shelter!");
			System.out.println("Goodbye!");
			break;
		default:
			System.out.println("\nPlease try again.");
		}
	}

}
