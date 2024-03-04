package serialize;

import java.io.*;
import java.util.ArrayList;


public class SerializePlayer1 {
	
	// private static String FILE_NAME = "C://temp//player1.ser";
	private static String FILE_NAME = "resources//filename1.txt";
	
	public static void serializePlayer()	{
		
		ArrayList<Statistic> stats = new ArrayList<Statistic>();
		stats.add(new Statistic(Statistic.StatType.STRENGTH, 11));
		stats.add(new Statistic(Statistic.StatType.AGILITY, 11));
		stats.add(new Statistic(Statistic.StatType.STAMINA, 180));
		stats.add(new Statistic(Statistic.StatType.INTELLECT, 163));
		stats.add(new Statistic(Statistic.StatType.SPIRIT, 17));
		
		Player player = new Player("Jaxxon", Player.Race.ELF, Player.Role.MAGE,
				'M', 45, stats, Zone.SWAMP_OF_SORROWS);
		
		writeToFile(player);
		
		try {
			// FileOutputStream is an output stream used for writing data to a file
			// Used for primitive values (also good for byte things, like here serializing it)
			// Where objects from ObjectOutputStream are written
			FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
			
			// ObjectOutputStream is used to write objects that can be read by ObjectInputStream
			// Only writes objects that implement the Serializable interface
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			// Writes the object to the file
			out.writeObject(player);
			
			// Closing updates the files to the serialized data
			out.close();
			fileOut.close();
			System.out.printf("Serialized data for player %s is saved in %s", 
					player.getName(), FILE_NAME);
		} 
		catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	public static void writeToFile(Player player) {
		try {
			// After executing this line, a blank text file is created
			FileWriter myWriter = new FileWriter(FILE_NAME, true);
			// Writes the text in the parameter to the text file
			myWriter.write(player.toString());
			// Always close the file after you're finished writing or doing things with it
			myWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}