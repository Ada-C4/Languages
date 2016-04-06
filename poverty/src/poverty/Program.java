package poverty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {	
		System.out.println("Welcome to CA/WA Poverty Educator!");
		System.out.print("Enter a county in either California or Washington: ");
		Scanner scan = new Scanner(System.in);
		String county = scan.nextLine();
		System.out.println("County: "+ county);
		scan.close();
		
		File washington = new File("washington.txt");
		
		try {
			Scanner scanner = new Scanner(washington);
			int lineNum = 0;
			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				lineNum++;
				
				if(lineNum == 2) { 
		            System.out.println("Line contents: " + line);
		        }
			}
		    scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
