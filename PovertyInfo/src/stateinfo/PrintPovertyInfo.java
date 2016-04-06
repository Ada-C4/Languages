package stateinfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class PrintPovertyInfo {
	
	public static String getMinimumChildPovertyRecord() throws IOException {
		BufferedReader abc = new BufferedReader(new FileReader("support/povWA.txt"));
		List<String> list = new ArrayList<String>();
		String str;
		
		while((str = abc.readLine()) != null){
		    list.add(str);
		}
		
		abc.close();
		return list.get(0);
	}
	
	public static void main(String[] args) throws IOException {
		String result = PrintPovertyInfo.getMinimumChildPovertyRecord();
		System.out.println(result);
	}

}
