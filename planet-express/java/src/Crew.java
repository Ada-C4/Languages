
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
            score = 0;
        }
        return score;
    }

    public boolean check() {
        if (score <= 0) {
            stable = false;
            return false;
        }
        else {
            if (thirst >= 85) {
                System.out.println("Fry is scary-thirsty!");
            }

            if (work >= 85) {
                System.out.println("Leela is exhausted from all this work!");
            }

            if (horde <= 15) {
                System.out.println("Bender is sad because he doesn't have enough treasure!");
            }

            if (hunger >= 85) {
                System.out.println("Zoidberg is going to eat something and it's not going to be pretty!");
            }

            if (receipts <= 15) {
                System.out.println("Hermes doesn't have enough receipts!");
            }

            return true;
        }

    }

    public static void main (String[] args) {
        Crew spaceship = new Crew();
        System.out.println(spaceship.check());
        System.out.println(spaceship.work);
        for (int i = 0; i < 7; i++) {
            spaceship.drink();
        }
        System.out.println(spaceship.work);
        System.out.println(spaceship.check());
        for (int j = 0; j < 3; j++) {
            spaceship.drink();
        }
        System.out.println(spaceship.work);
        System.out.println(spaceship.score());
        System.out.println(spaceship.check());
    }
}
