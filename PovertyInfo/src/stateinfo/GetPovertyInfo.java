package stateinfo;

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;

public class GetPovertyInfo {
	
	private static final Map<String, String> stateFiles;
	static
	{
		stateFiles = new HashMap<String, String>();
		stateFiles.put("Washington", "support/povWA.txt");
		stateFiles.put("South Dakota", "support/povSD.txt");
	}
	
	public static String getMinimumChildPovertyRecord(String state) throws FileNotFoundException {
		File data = new File(stateFiles.get(state));
		Scanner scnr = new Scanner(data);
		
		scnr.nextLine(); // skip first line
	
		String minCountyRecord = null;
		Double currentMin = null;

		while(scnr.hasNextLine()){
			
			String line = scnr.nextLine();
			
			if (currentMin == null) {
				currentMin = Double.parseDouble(line.substring(76, 80));
				minCountyRecord = line;
			}

			if (Double.parseDouble(line.substring(76, 80)) < currentMin) {
				currentMin = Double.parseDouble(line.substring(76, 80));
				minCountyRecord = line;
			}
			
        }       
				
		scnr.close();
		return minCountyRecord;
	}
	
	public static String getMaximumChildPovertyRecord(String state) throws FileNotFoundException {
		File data = new File(stateFiles.get(state));
		Scanner scnr = new Scanner(data);
		
		scnr.nextLine(); // skip first line
	
		String maxCountyRecord = null;
		Double currentMax = null;

		while(scnr.hasNextLine()){
			
			String line = scnr.nextLine();
			
			if (currentMax == null) {
				currentMax = Double.parseDouble(line.substring(76, 80));
				maxCountyRecord = line;
			}

			if (Double.parseDouble(line.substring(76, 80)) > currentMax) {
				currentMax = Double.parseDouble(line.substring(76, 80));
				maxCountyRecord = line;
			}
			
        }       
				
		scnr.close();
		return maxCountyRecord;
	}
	
	public static void printChildPovertyInfo(String state) throws FileNotFoundException {
		String minCountyRecord = GetPovertyInfo.getMinimumChildPovertyRecord(state);
		String maxCountyRecord = GetPovertyInfo.getMaximumChildPovertyRecord(state);
		
		System.out.println(String.format("In %s:", state));
		System.out.println(String.format("The county with the lowest percentage of children in poverty is %s. In that county, %s children (%s%%) are in poverty. The median household income is $%s.", minCountyRecord.substring(193, 239).trim(), minCountyRecord.substring(49, 57).trim(), minCountyRecord.substring(76, 80).trim(), minCountyRecord.substring(133, 139).trim()));
		System.out.println(String.format("The county with the highest percentage of children in poverty is %s. In that county, %s children (%s%%) are in poverty. The median household income is $%s.", maxCountyRecord.substring(193, 239).trim(), maxCountyRecord.substring(49, 57).trim(), maxCountyRecord.substring(76, 80).trim(), maxCountyRecord.substring(133, 139).trim()));

	}

}
