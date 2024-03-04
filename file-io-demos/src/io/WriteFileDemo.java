package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFileDemo {

	private static final String FILE_NAME_1 = "resources/output_o.txt";
	private static final String FILE_NAME_2 = "resources/output_a.txt";
	private static final boolean APPEND_MODE = true;		// The boolean value for creating the 
	private static final boolean OVERWRITE_MODE = false;

	public static void main(String[] args)  {

		try (Writer myWriter_O = new FileWriter(FILE_NAME_1, OVERWRITE_MODE); 
			 Writer myWriter_A = new FileWriter(FILE_NAME_2, OVERWRITE_MODE);) {;

				// In the beginning both files were opened as overwrite
				myWriter_O.write("Working with FileReaders and FileWriters is rough!");
				myWriter_A.write("Working with FileReaders and FileWriters is rough!");
				myWriter_O.write(System.lineSeparator());  // new line (regardless of op system!)
				myWriter_A.write(System.lineSeparator());
				myWriter_O.write("Why did I sign up for this course?");
				myWriter_A.write("Why did I sign up for this course?");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Both comments were added to each file.  (Overwrite is just how to BEGIN writing)

		// Then each file was opened in a different mode
		try (Writer myWriter_O = new FileWriter(FILE_NAME_1, OVERWRITE_MODE); 
			 Writer myWriter_A = new FileWriter(FILE_NAME_2, APPEND_MODE);) {
			myWriter_O.write(System.lineSeparator());
			myWriter_A.write(System.lineSeparator());
			myWriter_O.write("Scratch that.  FileReaders and FileWriters are easy.");
			myWriter_A.write("Scratch that.  FileReaders and FileWriters are easy.");
			myWriter_O.close();
			myWriter_A.close(); 
			// output_o only has one line in it; output_a has all three.

			System.out.println("Your files " + FILE_NAME_1 + " and " 
					+ FILE_NAME_2 + " are ready.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}