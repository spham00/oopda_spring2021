package v1;

/**
 * The DarkShadowsClip class represents one type of media collection
 * whose files are of .wav type, each with a number of episodes and a speaker.
 * 
 * @author 	Sarah Pham
 * @version	February 19th, 2021
 */
public class DarkShadowsClip implements Wav
{

	private String filename;	// The file name.
	private int episode;		// The episode number of the file.
	private String speaker;		// The speaker in the file.
	
	/**
	 * Creates a DarkShadowsClip file based on the user-entered values.
	 * 
	 * @param filename	The file name.
	 * @param episode	The episode number of the file.
	 * @param speaker	The speaker in the file.
	 */
	public DarkShadowsClip (String filename, int episode, String speaker)
	{
		this.filename = filename;
		this.episode = episode;
		this.speaker = speaker;
	}

	/**
	 * Returns the file's name.
	 * 
	 * @return	The file name.
	 */
	public String getFilename() {
		return filename;
	}
	
}
