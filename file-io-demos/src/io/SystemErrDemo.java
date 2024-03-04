package io;

public class SystemErrDemo {

	public static void main(String[] args) {
		
		try {
			// Run a method that will cause an exception
			raiseAnException();
		}
		catch (Exception e) {
			System.err.println("Yes, we just caused an exception.  See below.\n");
			//  Using the printStackTrace of the Exception object 
			//  also uses System.err
	         e.printStackTrace();  
		}
	}
	
	private static void raiseAnException() {
		throw new IllegalStateException();		
	}

}
