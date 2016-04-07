package stateinfo;

import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		GetPovertyInfo.printChildPovertyInfo("Washington");
		GetPovertyInfo.printChildPovertyInfo("South Dakota");
	}

}
