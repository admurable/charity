package charityapp.v2;

import java.util.ArrayList;
import java.util.List;

public class Cause {

	private String name;
	
	private ArrayList<Charity> charities;
	
	public Cause(String name) {
		this.name = name;
		charities = new ArrayList<Charity>();
	}
	
	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @return the charities
	 */
	protected ArrayList<Charity> getCharities() {
		return charities;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @param charities the charities to set
	 */
	protected void setCharities(ArrayList<Charity> charities) {
		this.charities = charities;
	}

	public Charity getByName(String toGet) {
		return charities.stream()
		.filter(charity -> charity.getName().equalsIgnoreCase(toGet))
		.findFirst().orElse(null);
	}
	
	public void sortByName() {
		Sorter.sortByNameDescending(charities);
	}

	/**
	 * Returns an array of strings that have charity information
	 * @return
	 */
	public List<String> getCharitiesInfo() {
//		String[] info = new String[charities.size()];
//		int i = 0;
//		for(Charity cha : charities)
//		{
//			info[i] = cha.display();
//			i++;
//		}
		List<String> info = new ArrayList<>();
		charities.forEach(cha -> info.add(cha.display()));
		return info;
	}

}
