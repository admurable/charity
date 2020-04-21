package charityapp.v1;

import java.util.HashSet;

public class International extends Charity {

	private HashSet<String> countriesServed;
	private String homeCountry;
	private int members;
	
	public International(String name, String leader, float percentageToCause,
			String website, String phoneNumber, boolean isGovernment,
			HashSet<String> countriesServed, String homeCountry, int members) {
		super(name, leader, percentageToCause, website, phoneNumber, isGovernment);
		this.countriesServed = countriesServed;
		this.homeCountry = homeCountry;
		this.members = members;
		
	}
	
	public String display() {
		StringBuilder builder = new StringBuilder();
		builder.append("The countries " + this.getName() + " is involved in are the following: ");
		countriesServed.forEach(country -> builder.append("\n" + country));
		builder.append("\nThere are " + members + " members involved in " + this.getName());
		return builder.toString();
	}
	

	public HashSet<String> getCountriesServed() {
		return countriesServed;
	}

	public void setCountriesServed(HashSet<String> countriesServed) {
		this.countriesServed = countriesServed;
	}

	public String getHomeCountry() {
		return homeCountry;
	}

	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

}