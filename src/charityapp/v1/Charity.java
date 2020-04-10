package charityapp.v1;

public abstract class Charity implements Comparable<Charity> {

	private String name;
	
	private String leader;
	
	private float percentageToCause;
	
	private String website;
	
	private String phoneNumber;
	
	private boolean isGovernment;
	
	public Charity(String name, String leader, float percentageToCause,
			String website, String phoneNumber, boolean isGovernment) {
		this.name = name;
		this.leader = leader;
		this.percentageToCause = percentageToCause;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.isGovernment = isGovernment;
	}

	public abstract String display();

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @return the leader
	 */
	protected String getLeader() {
		return leader;
	}

	/**
	 * @return the percentageToCause
	 */
	protected float getPercentageToCause() {
		return percentageToCause;
	}

	/**
	 * @return the website
	 */
	protected String getWebsite() {
		return website;
	}

	/**
	 * @return the phoneNumber
	 */
	protected String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the isGovernment
	 */
	protected boolean isGovernment() {
		return isGovernment;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @param leader the leader to set
	 */
	protected void setLeader(String leader) {
		this.leader = leader;
	}

	/**
	 * @param percentageToCause the percentageToCause to set
	 */
	protected void setPercentageToCause(float percentageToCause) {
		this.percentageToCause = percentageToCause;
	}

	/**
	 * @param website the website to set
	 */
	protected void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param isGovernment the isGovernment to set
	 */
	protected void setGovernment(boolean isGovernment) {
		this.isGovernment = isGovernment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Charity other = (Charity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Charity charity) {
		return this.name.compareTo(charity.getName());
	}
	
}
