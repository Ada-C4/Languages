
public class Crew {
	int thirst = 50;
	int work = 50;
	int horde = 50;
	int hunger = 50;
	int receipts = 50;
	boolean stable = true;
	int score = 50;
	
	public void drink() {
		thirst -= 5;
		work += 5;
	}
	
}
