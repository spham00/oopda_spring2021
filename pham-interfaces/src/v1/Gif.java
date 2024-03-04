package v1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * The Gif interface is implemented by media collections that are of the .gif file type.
 * 
 * @author 	Sarah Pham
 * @version	February 19th, 2021
 */
public interface Gif extends Playable
{

	/**
	 * Plays the .gif file.
	 */
	public default void play()
	{
		String filename = this.getFilename();
		System.out.println("Playing " + filename);

		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(filename);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.pack(); 
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocation(filename.length()* 10, filename.length() * 10);
		frame.setVisible(true);
	}

	/**
	 * Returns the file name.
	 * 
	 * @return	The file name.
	 */
	public String getFilename();
}
