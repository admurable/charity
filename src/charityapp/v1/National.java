package charityapp.v1;

public class National extends Charity {
	private String country;
	private int members;

	public National(String name, String leader, float percentageToCause,
			String website, String phoneNumber, boolean isGovernment,
			String country, int members) {
		super(name, leader, percentageToCause, website, phoneNumber, isGovernment);
		this.country = country;
		this.members = members;
	}
	
	public String display() {
		return this.getName() + " is in " + country + " and has " + members + " members.";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

}