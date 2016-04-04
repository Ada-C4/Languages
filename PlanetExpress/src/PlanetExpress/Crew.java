package PlanetExpress;

public class Crew {

	Member[] members;
	Fry fry;
	Leela leela;
	Bender bender;
	Zoidberg zoidberg;
	Hermes hermes;

	public Crew() {
		
		this.fry = new Fry();
		this.leela = new Leela();
		this.bender = new Bender();
		this.zoidberg = new Zoidberg();
		this.hermes = new Hermes();
		this.members = new Member[]{ this.fry, this.leela, this.bender, this.zoidberg, this.hermes };
		
	}
	
	private Boolean checkRange(int value) {
		return (value < 100 && value > 0) ? true : false;
	}
	
	private Integer score() {
		return (bender.hoard + hermes.receipts) - (fry.thirst + leela.work + zoidberg.hunger);
	}
	
	public String drink() {
		if (checkRange(fry.thirst) && checkRange(leela.work)) {
			fry.thirst -= 25;
			leela.work += 25;
			
			return "Fry drinks.";
		} else {
			return "Fry cannot drink any more.";
		}
		
	}
	
	public String deliver() {
		if (checkRange(leela.work) && checkRange(hermes.receipts)) {
			leela.work -= 25;
			hermes.receipts += 25;
			
			return "Leela works it out.";
		} else {
			return "Give Leela a break.";
		}
	}
	
	public String steal() {
		if (checkRange(bender.hoard) && checkRange(leela.work)) {
			bender.hoard += 25;
			leela.work += 25;
			
			return "Bender steals stuff.";
		} else {
			return "Bender cannot steal any more. Chill!";
		}
	}
	
	public String eat() {
		if (checkRange(zoidberg.hunger) && checkRange(leela.work)) {
			zoidberg.hunger -= 25;
			leela.work += 25;
			
			return "Zoidberg eats.";
		} else {
			return "Zoidberg cannot eat right now.";
		}
	}
	
	public String account() {
		if (checkRange(hermes.receipts) && checkRange(bender.hoard)) {
			bender.hoard -= 25;
			hermes.receipts -= 25;
			
			return "Hermes has an accounting party.";
		} else {
			return "Hermes is busy doing the limbo.";
		}
	}
	
	
}
