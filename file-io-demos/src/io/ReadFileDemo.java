package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadFileDemo {

	final static String FILE_NAME = "resources/java.txt";

	public static void main(String[] args)  {

		int i;

		/* Case 1:  Use FileReader */

		try (Reader myReader = new FileReader(FILE_NAME)) {
			System.out.println("\nIs the stream ready? " + myReader.ready());
			printline();

			while ((i = myReader.read()) != -1) {
				System.out.print((char) i);
			}
			System.out.println(System.lineSeparator());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	


		/*  Case 2:  Use BufferedReader as a more efficient Reader */

		try (Reader myReader = new BufferedReader(new FileReader(FILE_NAME))) {
			printline();

			while((i = myReader.read()) != -1) {			
				myReader.skip(1);            // Let's skip every other character
				System.out.print((char) i);
			}
			System.out.println(System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* Since BufferedReader is a Reader, it can do everything Case 1 can.
		 * e.g., read(), skip(), close()
		 */

		/*  Case 3:  Use BufferedReader as a more functional Reader */

		try (Reader myReader = new BufferedReader(new FileReader(FILE_NAME))) {
			printline();

			String thisLine; 
			while ((thisLine = ((BufferedReader) myReader).readLine()) != null) {
				System.out.println(thisLine);
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	private static void printline() {
		for (int i = 0; i < 80; i++) System.out.print("-");
		System.out.println(System.lineSeparator());
	}
}