package PlanetExpress;

import java.util.HashMap;

public class Crew {

	Member[] members;
	private Fry fry;
	private Leela leela;
	private Bender bender;
	private Zoidberg zoidberg;
	private Hermes hermes;

	public Crew() {
		
		this.fry = new Fry();
		this.leela = new Leela();
		this.bender = new Bender();
		this.zoidberg = new Zoidberg();
		this.hermes = new Hermes();
		this.members = new Member[]{ this.fry, this.leela, this.bender, this.zoidberg, this.hermes };
		
	}
	
}
