package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStreamDemo {

	public static void main(String[] args) {

		int data = 0;  // Notice that this example is byte-based.
		
		// This section prints out the data as bytes
		try (InputStream input = new FileInputStream("resources/ada.txt")) {
			do  {
				data = input.read();
				System.out.print(data + " ");  // echo the data read to console
			} while (data != -1); // Do while there is data needs to be read
			System.out.println();
			input.close();  // really not needed, because try with resources will close
		} 
		catch (IOException e) {		
			e.printStackTrace();
		}

		data = 0;  // reset variable to store bytes
		// Re-read data, but printout character equivalents
		try (InputStream input = new FileInputStream("resources/ada.txt")) {
			while (data != -1) {
				data = input.read();
				if (data != -1) System.out.print((char) data + " ");  // echo the data read to console
				// Notice this is casted to char to get the char equivalent to the corresponding byte
			}
		} 
		catch (IOException e) {		
			e.printStackTrace();
		}			


	}
}
