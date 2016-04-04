
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

	public void deliver() {
        work -= 5;
        receipts += 5;
    }

    public void steal() {
        horde += 5;
        work += 5;
    }

    public void eat() {
        hunger -= 5;
        work += 5;
    }

    public void account() {
        receipts -= 5;
        horde -= 5;
    }

    public int score() {
        if (thirst >= 100 || work >= 100 || horde <= 0 || hunger >= 100 || receipts <= 0) {
            score = 0
        }
        return score
    }

    public boolean check() {
        return true
    }
	
}
