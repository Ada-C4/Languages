package PlanetExpress;

public class Zoidberg extends Member {

	int hunger;

	public Zoidberg() {
		super("Zoidberg", "Zoidberg eats.", "Zoidberg cannot eat right now.");
		
		this.hunger = 50;
	}
	
	public void eat() {
		hunger -= 10;
	}
	
	public int hunger() {
		return hunger;
	}
	
}