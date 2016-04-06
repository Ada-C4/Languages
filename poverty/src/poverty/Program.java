package poverty;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {	
		System.out.println("Welcome to CA/WA Poverty Educator!");
		System.out.print("Enter a county in either California or Washington: ");
		Scanner scan = new Scanner(System.in);
		String county = scan.nextLine();
		System.out.println("County: "+ county);
		scan.close();
	}
}
