package PlanetExpress;

public class Bender extends Member {
	
	int hoard;

	public Bender() {
		super("Bender", "Bender steals stuff.", "Bender cannot steal any more. Chill!");
		
		this.hoard = 50;
	}
	
	public void steal() {
		hoard += 10;
	}
	
	public int hoard() {
		return hoard;
	}


}