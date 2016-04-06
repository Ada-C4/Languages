package PlanetExpress;

public class Fry extends Member {
	
	private int thirst;

	public Fry() {
		super("Fry");
		
		this.thirst = 50;
	}
	
	public void drink() {
		thirst -= 10;
	}
	
	public int thirst() {
		return thirst;
	}

}
