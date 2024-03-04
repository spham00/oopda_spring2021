package advanced;

public class Song {

	private String title;
	private String artist;
	private String relevantLyric = "no lyric identified";
	private int releaseYear;
	private Movie featuredMovie;

	// Constructors
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public Song(String title, String artist, int releaseYear, Movie movie) {
		this.title = title;
		this.artist = artist;
		this.featuredMovie = movie;
		this.releaseYear = releaseYear;
	}
	
	// Getters to facilitate TableView population

	public String getFeaturedMovieTitle() {
		return this.featuredMovie.getTitle();
	}
	
	// Getters and setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String toString() {
		return this.title + " by " + this.artist;
	}
	
	public String getRelevantLyric() {
		return relevantLyric;
	}

	public void setRelevantLyric(String relevantLyric) {
		this.relevantLyric = relevantLyric;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Movie getFeaturedMovie() {
		return featuredMovie;
	}

	public void setFeaturedMovie(Movie featuredMovie) {
		this.featuredMovie = featuredMovie;
	}
	
	
}