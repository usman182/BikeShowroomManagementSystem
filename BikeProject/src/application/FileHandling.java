package application;

import java.io.File;
import java.io.IOException;

public class FileHandling 
{
 
	public static void Create_File(String Fname) 
    {
 	 
 	 try {
 	      File myObj = new File(Fname);
 	      if (myObj.createNewFile()) 
 	      {
 	        System.out.println("File created: " + myObj.getName());
 	      } 
 	      else 
 	      {
 	        System.out.println("File already exists.");
 	      }
 	    } 
 	    
 	    catch (IOException e) 
 	     {
 	      System.out.println("An error occurred.");
 	      e.printStackTrace();
 	     }
 	  
    }
	

}