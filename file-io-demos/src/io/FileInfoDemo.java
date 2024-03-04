package io;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;

public class FileInfoDemo {
	   public static void main(String[] args) {
     
	      File myDirectory = new File("resources");
	      
	      // Load an array list of file names
	      @SuppressWarnings("unused")
		  ArrayList<String> fileNames = new ArrayList<String>(Arrays.asList(myDirectory.list()));
	      
	      // Load an array list of Files   (better!)
	      ArrayList<File> files = new ArrayList<File>(Arrays.asList(myDirectory.listFiles()));
	      
	      try {
	         // for each string in string array 
	         for (File f : files )
	         {
	            
	            // true if this program has permission to read the file
	            boolean executable = f.canRead(); 
	        	 
	            // true if this program has permission to write to the file
	            boolean writeable = f.canWrite();
	        	 
	            // true if this program has permission to execute the file
	            // (even if it is not an executable file!) 
	            boolean readable = f.canExecute();
	            
	            // find the absolute path
	            String a = f.getAbsolutePath(); 
	            
	            // prints absolute path
	            System.out.println(a);
	            
	            // prints  (Look up File in Java API.  You can do a lot.)
	            System.out.println("  is readable: " + readable +
	            		           "; is writeable: " + writeable +
	            		           "; is executable: " + executable);
	            
	            Instant instant = Instant.ofEpochMilli(f.lastModified());
	            LocalDateTime date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
	            System.out.println("  parent: " + f.getParent() + 
	            		           "; modified: " + date); 	
	         } 
	      } catch (Exception e){
	         // if any I/O error occurs
	         e.printStackTrace();
	      }
	   }
	}

