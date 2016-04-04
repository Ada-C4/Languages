package PlanetExpress;

public class Program {

	public static void main(String[] args) {
	
		Crew crew = new Crew();
		
		for (Member member : crew.members) {
			System.out.println(member.name + " reporting for space adventures!");
		}

	}

}
