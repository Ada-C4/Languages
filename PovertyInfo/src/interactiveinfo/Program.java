package interactiveinfo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Give me some input: ");
		String input = scnr.next();
		GetPovertyInfo.printCountyInfo(GetPovertyInfo.getMatch(input.trim()));
		scnr.close();
	}

}
