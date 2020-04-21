package charityapp.v1;

public interface Volunteerable {
	
	public abstract boolean isVolunteerable();
	public abstract void becomeVolunteer(Charity charity);
	public abstract void leaveVolunteer(Charity charity);


}