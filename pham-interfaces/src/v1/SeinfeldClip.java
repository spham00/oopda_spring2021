package v1;

/**
 * The SeinfeldClip class represents one type of media collection
 * whose files are of .wav type, each having a speaker and year release.
 * 
 * @author 	Sarah Pham
 * @version	February 19th, 2021
 */
public class SeinfeldClip implements Wav
{

	private String filename;	// The file name.
	private String speaker;		// The speaker in the media collection.
	private int year;			// The year of the release of the file.
	
	/**
	 * Creates a SeinfeldClip with the user-entered values.
	 * 
	 * @param filename	The file name.
	 * @param speaker	The speaker in the file.
	 * @param year		The year of release of the file.
	 */
	public SeinfeldClip(String filename, String speaker, int year)
	{
		this.filename = filename;
		this.speaker = speaker;
		this.year = year;
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
