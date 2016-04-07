package interactiveinfo;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GetPovertyInfo {

	public static String getMatch(String county) throws FileNotFoundException {
		File data = new File("support/povWA.txt");
		Scanner scnr = new Scanner(data);
		scnr.nextLine(); // skip first line
		
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
			if ((county + " County").equals(line.substring(193, 238).trim()) ) {
				String match = line;
				scnr.close();
				return match;
			}
		}
		
		scnr.close();
		return null;
	}
	
	public static void printCountyInfo(String countyRecord) {
		System.out.println(String.format("In %s, %s children (%s%%) are in poverty. The median household income is $%s.", countyRecord.substring(193, 239).trim(), countyRecord.substring(49, 57).trim(), countyRecord.substring(76, 80).trim(), countyRecord.substring(133, 139).trim()));
	}
}
