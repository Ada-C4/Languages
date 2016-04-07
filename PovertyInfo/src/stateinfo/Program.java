package stateinfo;

import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		String result = GetPovertyInfo.getMinimumChildPovertyRecord("Washington");
		System.out.println(result);
		result = GetPovertyInfo.getMinimumChildPovertyRecord("South Dakota");
		System.out.println(result);
	}

}
