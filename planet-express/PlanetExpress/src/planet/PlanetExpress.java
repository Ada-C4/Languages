package planet;

import java.util.Scanner;

public class PlanetExpress {
	int thirst;
	int work;
	int receipts;
	int horde;
	int hunger;
	boolean stable;
	
	PlanetExpress() {
		thirst = 50;
		work = 50;
		receipts = 50;
		horde = 50;
		hunger = 50;
		stable = true;
		
	}

	public static void main(String[] args) {
		PlanetExpress p = new PlanetExpress();
		System.out.println("Welcome to Planet Express!");
		while (p.stable) {
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("Type drink, deliver, steal, eat, or account to continue playing.");
			String input = reader.next();
			while (!input.toLowerCase().equals("drink") && !input.toLowerCase().equals("deliver") && !input.toLowerCase().equals("steal")
					&& !input.toLowerCase().equals("eat") && !input.toLowerCase().equals("account")) {
				System.out.println("That's not a valid choice. Try again.");
				System.out.println("Type drink, deliver, steal, eat, or account to continue playing.");
				input = reader.next();
			}
			if (input.equals("drink")) {
				p.drink();
			} else if (input.equals("deliver")) {
				p.deliver();
			} else if (input.equals("steal")) {
				p.steal();
			} else if (input.equals("eat")) {
				p.eat();
			} else if (input.equals("account")) {
				p.account();
			}
			System.out.println("Score: " + p.score());
			if (!p.check()) {
				System.out.println("GAME OVER");
			}
		}
	}
	
	public void drink() {
		thirst -= 4;
		work += 4;
	}
	
	public void deliver() {
		receipts += 4;
		work += 4;
	}
	
	public void steal() {
		horde += 4;
		work += 4;
	}
	
	public void eat() {
		hunger -= 4;
		work += 4;
	}
	
	public void account() {
		receipts -= 4;
		horde -= 4;
	}
	
	public int score() {
		int hordeScore = horde * 1000;
		int thirstScore = thirst * -20;
		int receiptsScore = receipts * -30;
		int workScore = work * -20;
		int hungerScore = hunger * -15;
		return hordeScore + thirstScore + receiptsScore + workScore + hungerScore;
	}
	
	public boolean check() {
		if (thirst >= 90 && thirst < 100) {
			System.out.println("Warning! Fry is very thirsty and is in danger of crashing the ship.");
		}
		if (work >= 90 && work < 100) {
			System.out.println("Warning! Leela has tons of work and is in danger of crashing the ship.");
		}
        if (horde <= 10 && work > 0) {
        	System.out.println("Warning! Bender's horde is very low and is in danger of crashing the ship.");
        }	
        if (hunger >= 90 && hunger < 100) {
        	System.out.println("Warning! Zoidberg is very hungry and is in danger of crashing the ship.");
        }
        if (receipts >= 90 && receipts < 100) {
        	System.out.println("Warning! Hermes' backlog of receipts is huge and is in danger of crashing the ship.");
        }
        if (thirst > 100 || work > 100 || hunger > 100 || horde <= 0 || receipts > 100) {
        	 stable = false;
        }  
		return stable;
	}

}
