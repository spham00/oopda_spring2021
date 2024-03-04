package serialize;

import java.io.*;

public class DeserializeDemo {

	private static String FILE_NAME_1 = "resources//filename1.txt";
	private static String FILE_NAME_2 = "resources//filename2.txt";
	
	public static void deserializePlayers() {
		Player player1, player2;
		
		// These are initialized to null so that they can be utilized and created according to the file
		// FileInputStream obtains input bytes from a file, which is shown when initialized (new)
		FileInputStream fileIn = null;
		
		// ObjectInputStream can be used to read objects that were previously written by ObjectOuputStream
		// Will convert streams back to the corresponding objects (deserialization)
		ObjectInputStream in = null;
		
		System.out.println("Deserializing player 1...\n");
		try {
			fileIn = new FileInputStream(FILE_NAME_1);
			in = new ObjectInputStream(fileIn);
			
			// Reads the object from the ObjectInputStream
			// AKA deserializes them and assigns that deserialized input to the object
			player1 = (Player) in.readObject();
			in.close();
			fileIn.close();
			
			// Prints out the deserialized player
			displayPlayer(player1);
		} 
		catch (ClassNotFoundException c) {
			System.out.println("Player class not found");
			c.printStackTrace();
			return;
		}
		catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		}
		finally {
			try {
				in.close();
				fileIn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		System.out.println("Deserializing player 2...\n");		
		try {
			fileIn = new FileInputStream(FILE_NAME_2);
			in = new ObjectInputStream(fileIn);
			player2 = (Player) in.readObject();
			in.close();
			fileIn.close();
			displayPlayer(player2);
		} 
		catch (IOException i) {
			i.printStackTrace();
			return;
		}
		catch (ClassNotFoundException c) {
			System.out.println("Player class not found");
			c.printStackTrace();
			return;
		}
		catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		}
		finally {
			try {
				in.close();
				fileIn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}



	}
	
	private static void displayPlayer(Player p) {
		System.out.println("  Name: " + p.getName());
		System.out.println("Gender: " + p.getGender());	
		System.out.println(" Level: " + p.getLevel());		
		System.out.println("  Race: " + p.getRace());
		System.out.println("  Role: " + p.getRole());
		System.out.println("  Zone: " + p.getZone());
		System.out.print  (" Stats:");
		for (Statistic s : p.getStats()) {
			System.out.println("\t" + s.getType() + ": " + s.getValue());
		}
	}
}