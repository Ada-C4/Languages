package poverty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {	
		System.out.println("Welcome to the CA/WA Poverty Educator!");
		Scanner scan = new Scanner(System.in);
		// capture user input for state 
		System.out.print("Enter 'CA' for California or 'WA' for Washington: ");
		String state = scan.nextLine().toUpperCase();
		// use appropriate file based on user state selection
		File file = null; 
		if(state.equals("WA")) {
			file = new File("washington.txt");
		} else if(state.equals("CA")){
			file = new File("california.txt");
		}
		try {
			Scanner scanner = new Scanner(file);
			// capture user input for county 
			System.out.print("Enter a county in " + state + ": ");
			String county = scan.nextLine();
			scan.close();
			// find and print the line matching the county entered by user
			String line; 
			boolean no_county = true;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				
				if(line.toLowerCase().contains(county.toLowerCase())) { 
		            System.out.println("Line contents: " + line);
		            
		            //the median household income.
		            County user_county = new County(line);
		            System.out.println("County: " );
		            System.out.println("Percentage of children in poverty: " + user_county.pov_percent);
		            System.out.println("Number of children in poverty: " + user_county.pov_count);
		            System.out.println("Median household income: "+ user_county.med_income);
		            no_county = false;
		        }
			}
		    scanner.close();
		    if(no_county) {
		    	System.out.println("Invalid county for " + state);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
