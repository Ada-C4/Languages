package poverty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {	
		System.out.println("Welcome to the CA/WA Poverty Educator!");
		Scanner scanInput = new Scanner(System.in);

		File file = null; 
		String state = null;
		while(file == null) {
			// capture user input for state 
			System.out.print("Enter 'CA' for California or 'WA' for Washington: ");
			state = scanInput.nextLine().toUpperCase();
			// use appropriate file based on user state selection
			if(state.equals("WA")) {
				file = new File("washington.txt");
			} else if(state.equals("CA")){
				file = new File("california.txt");
			}
		}
		
		try {
			Scanner scanFile = new Scanner(file);
			// capture user input for county 
			System.out.print("Enter a county in " + state + ": ");
			String county = scanInput.nextLine();
			scanInput.close();
			// find and print the line matching the county entered by user
			String line; 
			boolean countyFound = false;
			while (scanFile.hasNextLine()) {
				line = scanFile.nextLine();
				
				if(line.toLowerCase().contains(county.toLowerCase())) { 		            
		            County userCounty = new County(line);
		            System.out.println("County: " + userCounty.name );
		            System.out.println("Percentage of children in poverty: " + userCounty.povPercent);
		            System.out.println("Number of children in poverty: " + userCounty.povCount);
		            System.out.println("Median household income: "+ userCounty.medIncome);
		            countyFound = true;
		        }
			}
			scanFile.close();
		    if(!countyFound) {
		    	System.out.println("Invalid county for " + state);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
