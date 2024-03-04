package v1;

/**
 * The GameOfThronesClip represents one type of media collection
 * whose files are of .gif type, each having a character featured.
 * 
 * @author 	Sarah Pham
 * @version	February 19th, 2021
 */
public class GameOfThronesClip implements Gif
{

	private String filename;	// The file name.
	private String character;	// The featured character in the file.
	
	/**
	 * Creates a GameOfThronesClip with the user-entered character.
	 * 
	 * @param filename		The file name.
	 * @param character		The featured character in the file.
	 */
	public GameOfThronesClip(String filename, String character)
	{
		this.filename = filename;
		this.character = character;
	}
	
	/**
	 * Returns the file's name.
	 * 
	 * @return	The file name.
	 */
	public String getFilename()
	{
		return filename;
	}
}
