package PlanetExpress;

public class Member implements IMember {
	
	private String name;

	public Member(String name) {
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}

}
