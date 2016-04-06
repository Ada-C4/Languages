package planetExpress;

public class PlanetExpress {
	
	private int thirst;
	private int work;
	private int horde;
	private int hunger;
	private int receipts;
	private boolean stable;
	
	public PlanetExpress() {
		thirst = 50;
		work = 50;
		horde = 50;
		hunger = 50;
		receipts = 50;
		stable = true;
	}
	
	public int getThirst()
	{ 
		return thirst;
	}
	
	public int getWork()
	{ 
		return thirst;
	}
	
	public int getHorde()
	{ 
		return thirst;
	}
	
	public int getHunger()
	{ 
		return thirst;
	}
	
	public int getReceipts()
	{ 
		return thirst;
	}
	
	public void drink()
	{
		thirst -= 10;
		work += 10;
	}
	
	public void deliver()
	{
		work -= 10;
		receipts += 10;
	}
	
	public void steal()
	{
		horde += 10;
		work += 10;
	}
	
	public void eat()
	{
		hunger -= 10;
		work += 10;
	}
	
	public void account()
	{
		receipts -= 10;
		horde -= 10;
	}
	
	public boolean check()
	{
		if ((this.thirst > 80) || (this.work > 80) || (this.hunger > 80) || (this.horde <  20) || (this.receipts < 20))
		{
			this.stable  = false;
			return false;
		}
		else
		{
			if(this.thirst > 70)
			{
				System.out.println("You should drink more");
			}
			if(this.work > 70)
			{
				System.out.println("You have too much work to do");
			}
			if(this.hunger > 70)
			{
				System.out.println("You need to eat something");
			}
			if(this.horde < 30)
			{
				System.out.println("The horde is too low");
			}
			if(this.receipts < 30)
			{
				System.out.println("The receipts are too low");
			}
		}
	return true;
	}
	
}
