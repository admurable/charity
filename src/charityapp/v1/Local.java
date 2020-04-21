package charityapp.v1;

import java.util.HashSet;

public class Local extends Charity {
	private HashSet<String> cities;
	private int members;


	public Local(String name, String leader, float percentageToCause,
			String website, String phoneNumber, boolean isGovernment,
			HashSet<String> cities, int members) {
		super(name, leader, percentageToCause, website, phoneNumber, isGovernment);
		this.cities = cities;
		this.members = members;
	}

	public String display() {
		StringBuilder builder = new StringBuilder();
		builder.append("The cities " + this.getName() + " is involved in are the following: ");
		cities.forEach(country -> builder.append("\n" + country));
		builder.append("\nThere are " + members + " members involved in " + this.getName());
		return builder.toString();
	}

	public void addCity(String city) {
		cities.add(city);
	}

	public HashSet<String> getCities() {
		return cities;
	}

	public int getMembers() {
		return members;
	}

	public void setCities(HashSet<String> cities) {
		this.cities = cities;
	}
	
	public void setMembers(int members) {
		this.members = members;
	}
}
