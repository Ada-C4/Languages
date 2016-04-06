package PlanetExpress;

public class Hermes extends Member {
	
	int receipts;

	public Hermes() {
		super("Hermes");
		
		this.receipts = 50;
	}
	
	public void account() {
		receipts -= 10;
	}
	
	public int receipts() {
		return receipts;
	}

}
