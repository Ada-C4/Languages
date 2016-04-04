import java.util.Scanner;

public class PlanetExpress {
	private int thirst;
	private int work;
	private int horde;
	private int hunger;
	private int receipts;
	private boolean stable;
	

	public PlanetExpress() {
		thirst = 50;
		work = 50;
		horde = 50;
		hunger = 50;
		receipts = 50;
		stable = true;
	}

	public int getHunger() {
		return this.hunger;
	}
	
	public int getThirst() {
		return this.thirst;
	}
	
	public int getWork() {
		return this.work;
	}
	
	public int getHorde() {
		return this.horde;
	}
	 
	public int getReceipts() {
		return this.receipts;
	}
	
	private boolean isStable() {
		if (this.hunger >= 100 || this.thirst >= 100 || this.work >= 100) {
			this.stable = false;
		} else if (this.receipts <= 0 || this.horde <= 0) {
			this.stable = false;
		}
		return this.stable;
	}
	
	public void act(String action) {
		switch (action) {
			case "drink":
				this.drink();
				System.out.println("You drank some stuff.\n");
				break;
			case "eat":
				this.eat();
				System.out.println("Yum, you ate some food.\n");
				break;
			case "account":
				this.account();
				System.out.println("Great, you did some accounting.\n");
				break;
			case "deliver":
				this.deliver();
				System.out.println("The crew delivered some packages!");
				break;
			case "steal":
				this.steal();
				System.out.println("Oops, Bender stole some things.");
				break;
			case "score":
				int score = this.getScore();
				System.out.println("Your score is: " + score + ".");
		}
		String warning = this.warn();
		System.out.println(warning);
	}
	
	public boolean check() {
		return this.isStable();
	}
	
	private String warn() {
		String warning = "";
		if (this.hunger > 70) {
			warning += "Your hunger is getting dangerously high.\n";
		}
		if (this.thirst > 70) {
			warning += "Your thirst is getting dangerously high.\n";
		}
		if (this.work > 70) {
			warning += "Your workload is getting dangerously high.\n";
		}
		if (this.receipts < 30) {
			warning += "You have dangerously few receipts.\n";
		}
		if (this.horde < 30) {
			warning += "Your horde is dangerously small.\n";
		}
		return warning;
	}
	
	private void drink() {
		this.thirst -= 10;
		this.work += 10;
	}
	
	private void deliver() {
		this.work -= 10;
		this.receipts += 10;
	}
	
	private void steal() {
		this.horde += 10;
		this.work += 10;
	}
	
	private void eat() {
		this.hunger -= 10;
		this.work += 10;
	}
	
	private void account() {
		this.receipts -= 10;
		this.horde -= 10;
	}
	
	private int getScore() {
		int score = 0;
		if (this.hunger > 70) {
			score += 1;
		} else if (this.hunger < 30) {
			score -= 1;
		}
		if (this.thirst > 70) {
			score += 1;
		} else if (this.thirst < 30) {
			score -= 1;
		}
		if (this.horde > 70) {
			score += 1;
		} else if (this.horde < 30) {
			score -= 1;
		}
		if (this.receipts > 70) {
			score -= 1;
		} else if (this.receipts < 30) {
			score += 1;
		}
		if (this.work > 70) {
			score -= 1;
		} else if (this.work < 30) {
			score += 1;
		}
		return score;
	}
}
