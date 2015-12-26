package my.Learning;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileChk {
	   @SuppressWarnings("resource")
	public static void main(String[] args) {
		  String filename = null;
		  Scanner input = new Scanner(System.in);
		  do{
		      System.out.print("Enter file name: ");
		      filename = input.nextLine();
		  } while (!(new File(filename).exists()));
		  
          File file = new File(filename);
          String line;
          try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
          line = input.nextLine();
          line = input.nextLine();
		  input.close();
		  System.out.println(line); //Always Print the Second Line.
	   }
	}