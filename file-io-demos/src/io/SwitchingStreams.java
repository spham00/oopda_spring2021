package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class SwitchingStreams {
	
	private static final boolean APPEND_MODE = true;
	private static final boolean OVERWRITE_MODE = false;
	private static final String FILE_NAME = "resources/redirectedOutput.txt";

	public static void main(String[] args) throws IOException {
			switchStreams();
	}

	private static void switchStreams()  {
		try (OutputStream output = new FileOutputStream(FILE_NAME, APPEND_MODE);
			 PrintStream printOut = new PrintStream(output);) {

			System.out.println("This should go to the console (System.out)");		
			
			// Sets "out" (the output stream of the System) to the PrintStream,
			// which will print the output stream to the file
			System.setOut(printOut);
			
			// Prints in the file instead of the console
			System.out.println("but this should go to a file.");

			// After you're done writing everything, some data may still be in the buffer. 
			// Now you have to flush the buffer, to force it to send all the data.
			printOut.flush();

			// Never forget to close the file or 
			// include your Closeable objects in try with resources
			printOut.close();  // not really needed here
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
