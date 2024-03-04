package v1;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The RockyAndBullwinkleClip represents one type of media collection
 * whose files are of .wav type, each having an array of speakers.
 * 
 * @author 	Sarah Pham
 * @version	February 19th, 2021
 */
public class RockyAndBullwinkleClip implements Wav
{

	private String filename;	// The file name.
	private String[] speakers;	// An array of speakers in the file.
	
	/**
	 * Creates a RockyAndBullwinkleClip with the user-entered values.
	 * 
	 * @param filename			The file name.
	 * @param numberOfSpeakers	The number of speakers in the file.
	 */
	public RockyAndBullwinkleClip (String filename, int numberOfSpeakers)
	{
		this.filename = filename;
		speakers = new String[numberOfSpeakers];
		
		if (numberOfSpeakers == 1) {
			speakers[0] = "Natasha";
		}
		else if (numberOfSpeakers == 2) {
			speakers[0] = "Rocky";
			speakers[1] = "Bullwinkle";
		}
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
