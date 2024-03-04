package movies;

import java.time.LocalDate;

/**
 * The Movie class represents one movie with a title, movie length (in minutes),
 * and release date.
 * 
 * @author 	Sarah Pham
 * @version	February 4th, 2021
 */
public class Movie {

	private String title;			// The title of the movie.
	private int movieLength;		// The length (in minutes) of the movie.
	private LocalDate releaseDate;	// The release date of the movie.

	/**
	 * Creates a movie with the user-entered title, movie length, and release date.
	 * 
	 * @param title			The title of the movie.
	 * @param movieLength	The length (in minutes) of the movie.
	 * @param releaseDate	The release date of the movie.
	 */
	public Movie (String title, int movieLength, LocalDate releaseDate) {
		
		this.title = title;
		this.movieLength = movieLength;
		this.releaseDate = releaseDate;
	}
	
	/**
	 * Returns a formatted String of the movie's title, length, and release date.
	 * 
	 * @return	A formatted String containing the movie's title, length, and release date.
	 */
	@Override
	public String toString() {
		
		return title + " (" + releaseDate + ")" + " " + movieLength + " minutes.";
	}

}