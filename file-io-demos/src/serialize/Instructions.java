package serialize;

import javax.swing.JOptionPane;

public class Instructions {

	public static void display() {
		String s;
		s  = "Welcome to the Serialization Demo.\n\n";
		s += "In order to fully appreciate the value of serialVersionUIDs, you will\n";
		s += "need to understand the setup of this demonstration.  This demo is set up\n";
		s += "so that the Player class represents a serializable object for version 2\n";
		s += "of this class.  A serialized file can be created for a 'version 2' style\n";
		s += "player.\n\n";
		s += "The Player class can then be edited back to its original version, so that\n";
		s += "a serialized file can be created for a 'version 1' style player.  We will\n";
		s += "rely on the serialVersionUIDs to preserve application integrity.\n\n";
		s += "Instructions:\n\n";
		s += "   1.  Modify the Player class to restore the old serialVersionUID and list\n";
		s += "         of roles.  (Don't delete code, just comment out.) \n\n";
		s += "   2.  Use the SerializePlayer1 class to create a file for player 1.\n\n";	
		s += "   3.  Modify the Player class to return to the new serialVersionUID and \n";
		s += "         updated list of roles.  (Don't delete code, just comment out.) \n\n";
		s += "   3.  Use the SerializePlayer2 Java class to create a file for player 2.\n\n";
		s += "   4.  Finally, run the DeserialzeDemo program to see the results.";
		System.out.println(s);
		// JOptionPane.showMessageDialog(null, s, "Instructions", JOptionPane.INFORMATION_MESSAGE);
	}

}