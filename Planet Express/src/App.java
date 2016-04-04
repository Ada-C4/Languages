import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		PlanetExpress crew = new PlanetExpress();
		Scanner actionReader = new Scanner(System.in);
		
		System.out.println("Welcome to Planet Express!");
		System.out.println("Your team is just getting started.");
		System.out.println("What would you like do to?");
		System.out.println("Choose one: 'drink', 'eat', 'deliver', 'steal', 'account'");
		System.out.println("Type 'score' to get your current score.");
		
		String action = actionReader.next();
		
		do {
			crew.act(action);
			System.out.println("What would you like do to?");
			System.out.println("Choose one: 'drink', 'eat', 'deliver', 'steal', 'account'");
			System.out.println("Type 'score' to get your current score.");
			action = actionReader.next();
		} 
		while (crew.check());
		
		System.out.println("Uh oh, your crew is no longer stable.");
		System.out.println("GAME OVER");
	}
}
