package planetExpress;

public class Score {
	float score;
	
	public Score() {
		score = 0;
	}
	
	private float checkLow(int num)
	{
		return (((100 - num) * 2) / 10);
	}
	
	private float checkHigh(int num)
	{
		return ((num * 2) / 10);
	}
	
	public float setScore (int thirst, int work, int horde, int hunger, int receipts)
	{
		this.score = checkLow(thirst) + checkLow(work) + checkLow(hunger) + checkHigh(horde) + checkHigh(receipts);
		return this.score;
	}
	
	public float getScore ()
	{
		return this.score;
	}

}
