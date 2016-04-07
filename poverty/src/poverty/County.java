package poverty;

public class County {
	
	public String name;
	public String povPercent;
	public String povCount;
	public String medIncome;

	public County(String line) {
		this.name = line.substring(193, 238);
		
		String[] details = line.split("\\s+");
		this.povPercent = details[11];
		this.povCount = details[8];
		this.medIncome = details[20];
	}

}
