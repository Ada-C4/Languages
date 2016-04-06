package stateinfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

public class PrintPovertyInfo {
	
	private static final Map<String, String> stateFiles;
	static
	{
		stateFiles = new HashMap<String, String>();
		stateFiles.put("Washington", "support/povWA.txt");
		stateFiles.put("South Dakota", "support/povSD.txt");
	}
	
	public static String getMinimumChildPovertyRecord(String state) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(stateFiles.get(state)));
		List<String> list = new ArrayList<String>();
		String str;
		
		while((str = br.readLine()) != null){
		    list.add(str);
		}
		
		br.close();
		return list.get(0);
	}
	
	public static void main(String[] args) throws IOException {
		String result = PrintPovertyInfo.getMinimumChildPovertyRecord("Washington");
		System.out.println(result);
		String result2 = PrintPovertyInfo.getMinimumChildPovertyRecord("South Dakota");
		System.out.println(result2);

	}

}
