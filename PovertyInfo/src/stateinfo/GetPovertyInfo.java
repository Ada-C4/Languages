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

}
