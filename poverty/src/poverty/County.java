package poverty;

public class County {

	public String pov_percent;

	public County(String line) {
		String[] details = line.split("\\s+");
		this.pov_percent = details[11];
	}

}
