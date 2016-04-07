package interactiveinfo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.lang3.text.WordUtils;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a county name in Washington (e.g., King), or type `quit` to quit: ");
		String input = WordUtils.capitalizeFully(scnr.nextLine().trim());
				
		String record = null;
		while (!input.equals("Quit") && !input.equals("Q")) {
			record = GetPovertyInfo.getMatch(input);
			
			while (record == null) {
				scnr = new Scanner(System.in);
				System.out.println("No match found. Try again: ");
				input = WordUtils.capitalizeFully(scnr.nextLine().trim());
				record = GetPovertyInfo.getMatch(input);
			}
			
			GetPovertyInfo.printCountyInfo(record);
			scnr = new Scanner(System.in);
			System.out.println("Enter another county, or type `quit` to quit: ");
			input = WordUtils.capitalizeFully(scnr.nextLine().trim());
		}
		
		scnr.close();
	}

}
