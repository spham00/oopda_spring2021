package v1;

/**
 * The DarkClip represents one type of media collection
 * whose files are of .gif type, each having a scene featured.
 * 
 * @author 	Sarah Pham
 * @version	February 19th, 2021
 */
public class DarkClip implements Gif
{

	private String filename;		// The file name.
	private String scene;			// The scene featured in the file.
	
	/**
	 * Creates a DarkClip from the user-entered values.
	 * 
	 * @param filename	
	 * @param scene
	 */
	public DarkClip (String filename, String scene)
	{
		this.filename = filename;
		this.scene = scene;
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
