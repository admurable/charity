package charityapp.v2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Person implements Volunteerable, Serializable {
	private static final long serialVersionUID = -1931944206571829679L;
	private static Random rand = new Random();
	private static int userID;
	private static ArrayList<Person> users = new ArrayList<>();
	private int id;
	private ArrayList<Charity> listToVolunteer = new ArrayList<>();
	private static Logger LOG = Logger.getGlobal();

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
	
	public void createProfile() 
	{
		File file = new File(userID + ".txt");
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			if(file.createNewFile()) {
				LOG.info("Created new file for ID: " + userID);
			} else LOG.info("Profile already exists; please use update profile.");
			out.writeObject(this);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}