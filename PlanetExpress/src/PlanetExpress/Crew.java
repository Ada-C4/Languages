package PlanetExpress;

public class Crew {
	
	public enum Action {
		DRINK, DELIVER, STEAL, EAT, ACCOUNT
	}

	Member[] members;
	Fry fry;
	Leela leela;
	Bender bender;
	Zoidberg zoidberg;
	Hermes hermes;
	int score;

	public Crew() {
		this.score = 0;
		this.fry = new Fry();
		this.leela = new Leela();
		this.bender = new Bender();
		this.zoidberg = new Zoidberg();
		this.hermes = new Hermes();
		this.members = new Member[]{ this.fry, this.leela, this.bender, this.zoidberg, this.hermes };
		
	}
	
	private boolean checkRange(int value) {
		return (value < 100 && value > 0) ? true : false;
	}
	
	public int score() {
		int tmp = (bender.hoard() + hermes.receipts()) - (fry.thirst() + leela.work() + zoidberg.hunger()) / 100;
		if (tmp > 0) {
			score += tmp;
		}
		
		return score;
	}
	
	public String warn() {
		String warning = "";
		
		if (fry.thirst() > 85) {
			warning += "Fry is thirsty.\n";
		}
		
		if (leela.work() > 85) {
			warning += "Leela has too much work.\n";
		}
		
		if (bender.hoard() < 25) {
			warning += "Bender's hoard is getting pretty small.\n";
		} 
		
		if (zoidberg.hunger() > 85) {
			warning += "Zoidberg is starving!\n";
		} 
		
		if (hermes.receipts() > 85) {
			warning += "Hermes has too many receipts!\n";
		}
		
		return warning;
	}
	
	public boolean check() {
		if (fry.thirst() == 100 || leela.work() == 100 || zoidberg.hunger() == 0 || hermes.receipts() == 0 || bender.hoard() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public String status() {
		return "Crew status:\nFry's thirst: " + fry.thirst() + "\nLeela's workload: " + leela.work() + "\nBender's hoard: " + bender.hoard() +"\nZoidberg's hunger: " + zoidberg.hunger() + "\nHermes' receipts: " + hermes.receipts();
	}
	
	public String perform(Action action) {
		boolean checkStatus = false;
		Member crewMember = null;
		
		switch (action) {
		case DRINK:
			crewMember = fry;
			fry.drink();
			leela.work += 10;
			checkStatus = checkRange(fry.thirst()) && checkRange(leela.work());
			break;
		case DELIVER:
			crewMember = leela;
			leela.deliver();
			hermes.receipts += 10;
			checkStatus = checkRange(leela.work()) && checkRange(hermes.receipts());
			break;
		case STEAL:
			crewMember = bender;
			bender.steal();
			leela.work += 10;
			checkStatus = checkRange(bender.hoard()) && checkRange(leela.work());
			break;
		case EAT:
			crewMember = zoidberg;
			zoidberg.eat();
			leela.work += 10;
			checkStatus = checkRange(zoidberg.hunger()) && checkRange(leela.work());
			break;
		case ACCOUNT:
			crewMember = hermes;
			hermes.account();
			bender.hoard -= 10;
			checkStatus = checkRange(hermes.receipts()) && checkRange(bender.hoard());
			break;
		}
		
		return (checkStatus) ? crewMember.action : crewMember.stahp;
	}	
}
