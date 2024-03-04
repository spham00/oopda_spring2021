package movies;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The MovieDriver class is a Driver class that takes user input for a number of movies'
 * details and displays them.
 * 
 * @author 	Sarah Pham
 * @version	February 4th, 2021
 */
public class MovieDriver {

	/**
	 * Collection of user-input movies.
	 */
	private static Map <Integer, Movie> movies = new HashMap<Integer, Movie>();
	
	/**
	 * The number of movies to be created.
	 */
	private static int COUNT = 3;

	
	public static void main(String[] args) {
		
		populateMovies();
		displayMovies();
	}

	/**
	 * This method uses a Scanner and gets user input for three movies (title, length, release date
	 * which it will then use to make a new Movie and add it into the HashMap movies.
	 */
	private static void populateMovies() {
		
		System.out.println("Creating movies");
		Scanner lineInput = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);
		
		String title = "";
		int movieLength = 0;
		LocalDate releaseDate = null;

		for (int i = 1; i <= COUNT; i++) {
			
			System.out.print("\nEnter title of movie " + i + ": ");
			title = lineInput.nextLine();

			System.out.print("Enter length of movie " + i + ": ");
			movieLength = intInput.nextInt();

			System.out.print("Enter release date of movie " + i + " (YYYY-MM-DD format): ");
			releaseDate = LocalDate.parse(lineInput.nextLine());
			
			movies.put(i, new Movie(title, movieLength, releaseDate));
			
			title = "";
			movieLength = 0;
			releaseDate = null;
		}
		
		lineInput.close();
		intInput.close();
	}	

	/**
	 * This method loops through all the movies using the forEach method 
	 * and displays each movie using its toString() method.
	 */
	private static void displayMovies() {
		
		System.out.println("\nHere is the list of movies:");
		movies.forEach((k, v) -> {
			System.out.println("\t" + v);
		});
	}
}
