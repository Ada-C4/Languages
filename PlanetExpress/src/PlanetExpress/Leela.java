package PlanetExpress;

public class Leela extends Member {
	
	int work;

	public Leela() {
		super("Leela",  "Leela works it out.", "Give Leela a break.");
		
		this.work = 50;
	}
	
	public void deliver() {
		work -= 10;
	}
	
	public int work() {
		return work;
	}


}