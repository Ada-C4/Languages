package PlanetExpress;

public class Zoidberg extends Member {

	int hunger;

	public Zoidberg() {
		super("Zoidberg");
		
		this.hunger = 50;
	}
	
	public void eat() {
		hunger -= 10;
	}
	
	public int hunger() {
		return hunger;
	}
	
}
