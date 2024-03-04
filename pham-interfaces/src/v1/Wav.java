package v1;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The Wav interface is implemented by media collections that are of the .wav file type.
 * 
 * @author 	Sarah Pham
 * @version	February 19th, 2021
 */
public interface Wav extends Playable
{

	/**
	 * Plays the .wav file.
	 */
	public default void play()
	{
		String filename = this.getFilename();
		System.out.println("Playing " + filename);
		AudioInputStream audioStream;

		try {
		   Clip clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(new File(filename)));
		   clip.start();
		   Thread.sleep(clip.getMicrosecondLength() / 1000);
		   clip.close();
		}
		catch (Exception e) {
		   e.printStackTrace(); 
		}
	}
	
	/**
	 * Returns the file name for the play method to get the clip's file name.
	 * 
	 * @return	The file name.
	 */
	public String getFilename();
	
}
