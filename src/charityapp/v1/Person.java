package charityapp.v1;

import java.util.ArrayList;
import java.util.Random;

public class Person implements Volunteerable {
	private static Random rand = new Random();
	private static int userID;
	private static ArrayList<Person> users = new ArrayList<>();
	private int id;
	private ArrayList<Charity> listToVolunteer = new ArrayList<>();

	public Person(ArrayList<Charity> volunteer) {
		listToVolunteer = volunteer;
		id = setUserID();
	}
	
	public Person() {
		id = setUserID();
		users.add(this);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the registered volunteering users
	 */
	public static ArrayList<Person> getUsers() {
		return users;
	}


	/**
	 * @return the listToVolunteer
	 */
	public ArrayList<Charity> getListToVolunteer() {
		return listToVolunteer;
	}

	/**
	 * @param listToVolunteer the listToVolunteer to set
	 */
	public void setListToVolunteer(ArrayList<Charity> listToVolunteer) {
		this.listToVolunteer = listToVolunteer;
	}

	private static int setUserID() {
		userID = rand.nextInt(1000);
		for(int i = 0; i < users.size(); i++) {
			if(userID == users.get(i).getId()) {
				i = 0;
				userID = rand.nextInt(1000);
			}
		}
		return userID;
	}

	@Override
	public boolean isVolunteerable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void becomeVolunteer(Charity charity) {
		listToVolunteer.add(charity);
		
	}

	@Override
	public void leaveVolunteer(Charity charity) {
		if(listToVolunteer.size() > 0) {
			for(Charity c: listToVolunteer) {
				if(charity.getName().equals(c.getName())) {
					listToVolunteer.remove(charity);
				}
			}
		}
		
	}

}