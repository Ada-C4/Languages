package poverty;

public class County {
	
	public String name;
	public String pov_percent;
	public String pov_count;
	public String med_income;

	public County(String line) {
		this.name = line.substring(193, 238);
		
		String[] details = line.split("\\s+");
		this.pov_percent = details[11];
		this.pov_count = details[8];
		this.med_income = details[20];
	}

}
