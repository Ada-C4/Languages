package poverty;

public class County {
	final int NAME_START = 193;
	final int NAME_END = 238;
	
	public String name;
	public String povPercent;
	public String povCount;
	public String medIncome;

	public County(String line) {
		this.name = line.substring(NAME_START, NAME_END);
		
		String[] details = line.split("\\s+");
		this.povPercent = details[11];
		this.povCount = details[8];
		this.medIncome = details[20];
	}

}
