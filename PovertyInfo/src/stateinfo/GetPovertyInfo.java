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
		
		String firstLine = scnr.nextLine();
		
		scnr.close();
		return firstLine;
	}

}
