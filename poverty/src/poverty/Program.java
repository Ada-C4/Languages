package poverty;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {	
		System.out.println("Welcome to Poverty Educator!");
		System.out.print("Enter a U.S. county to learn about: ");
		Scanner scan = new Scanner(System.in);
		String county = scan.nextLine();
		System.out.println("County: "+ county);
		scan.close();
	}
}
