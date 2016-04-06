package planetExpress;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) 
	{
		PlanetExpress planet;
		Score score;
		Boolean stable = true;
		
		 planet = new PlanetExpress();
		 score = new Score();
		 Scanner reader = new Scanner(System.in);
		 
		 
		 while (stable = true)
		 {
			System.out.println("Choose what do you want to do next:");
			System.out.println("press \"1\" if you want to deliver");
			System.out.println("press \"2\" if you want to steal");
			System.out.println("press \"3\" if you want to eat");
			System.out.println("press \"4\" if you want to drink");
			System.out.println("press \"5\" if you want to account");
			int step = reader.nextInt();
			
			switch(step)
			{
				case '1' :
					planet.deliver();
				case '2' :
					planet.steal();
				case '3' :
					planet.eat();
				case '4' :
					planet.drink();
				case '5' :
					planet.account();
				default :
		            System.out.println("Invalid number");
			}
			
			score.setScore(planet.getThirst(), planet.getWork(), planet.getHorde(), planet.getHunger(), planet.getReceipts());
			if (planet.check() == false)
			{
				stable = false;
			}
		 }
	}

}
