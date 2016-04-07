package poverty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws FileNotFoundException {	
		System.out.println("Welcome to the CA/WA Poverty Educator!");

		File caFile = new File("california.txt");
		File waFile = new File("washington.txt");

		
		County highestCACounty = findExtremeCounty(caFile, true);
//		County lowestCACounty = findExtremeCounty(caFile, false);
//		County highestWACounty = findExtremeCounty(waFile, true);
//		County lowestWACounty = findExtremeCounty(waFile, false);
//		
		System.out.print("In California, the county with the highest poverty percent is: ");
		System.out.println(highestCACounty.name);
		System.out.println(highestCACounty.povPercent);
		
		
		Scanner scanInput = new Scanner(System.in);

		File file = null; 
		String state = null;
		while(file == null) {
			// capture user input for state 
			System.out.print("Enter 'CA' for California, 'WA' for Washington, or 'q' to quit: ");
			state = scanInput.nextLine().toUpperCase();
			// use appropriate file based on user state selection
			if(state.equals("WA")) {
				file = waFile;
			} else if(state.equals("CA")){
				file = caFile;
			} else if(state.equals("Q")) {
				scanInput.close();
				System.out.println("BYE.");
				return;
			}
		}
		
		boolean countyFound = false;
		while (!countyFound) {
			try {
				Scanner scanFile = new Scanner(file);
				// capture user input for county 
				System.out.print("Enter a county in " + state + " or 'q' to quit: ");
				String county = scanInput.nextLine();
				if (county.equals("q")) { 
					scanFile.close();
					System.out.println("BYE.");
					return; 
				}
				// find and print the line matching the county entered by user
				String line; 
				
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
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
		
		scanInput.close();	
	}
	
	
	public static County findExtremeCounty(File file, boolean highest) throws FileNotFoundException {
		
		Scanner scanFile = new Scanner(file);
		String currentLine = scanFile.nextLine(); 
		String[] currentLineColumns; 
		Double currentLinePovPercent; 
		String targetLine = currentLine;
		String[] targetLineColumns = targetLine.split("\\s+");
		Double targetPovPercent = Double.parseDouble(targetLineColumns[11]);
		
		
		while (scanFile.hasNextLine()) {
			currentLine = scanFile.nextLine();
			currentLineColumns = currentLine.split("\\s+");
			currentLinePovPercent = Double.parseDouble(currentLineColumns[11]);
			
			if (currentLinePovPercent > targetPovPercent) {
				targetLine = currentLine;
				targetPovPercent = currentLinePovPercent;
			}
		}
		scanFile.close();
		return new County(targetLine);
	}
}
