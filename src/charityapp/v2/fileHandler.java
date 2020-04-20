package charityapp.v2;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.logging.*;
import java.util.HashSet;
import java.util.Set;

public class fileHandler {
	
	private HashMap<Charity, String> charities;
	
	
	private File information;
	
	private Logger log;
	
	private int lineNum;
	
	public fileHandler() 
	{
		information = new File("charities.txt");
		charities = new HashMap<Charity, String>();
		log = Logger.getLogger("fileHandler");
		lineNum = 1;
		readFile();
		
	}
	
	public ArrayList<Charity> getCharities(String cause)
	{
		ArrayList<Charity> list = new ArrayList<Charity>();
		boolean found = false;
		Set<Charity> keys = charities.keySet();
		for(Charity c : keys) {
			if(charities.get(c).contains(cause)) {
				list.add(c);
				found = true;
			}
			
		}
		if(!found) {
			log.fine("No charites with that cause found");
			return list;
		}
		return list;
	}
	
	private void readFile()
	{
		try (BufferedReader br =
                new BufferedReader(new FileReader(information))) {
			String line = br.readLine();
			while(line != null) {
				createObject(line.split(","));
				line = br.readLine();
				
			}
			lineNum = 1;
		}
		catch(FileNotFoundException e ) {
			log.warning(e.getMessage());
			log.warning("File not Found");
		}
		catch(IOException e) {
			log.warning(e.toString());
		}
		catch(Exception e) {
			log.warning(e.toString());
			throw e;
		}
	}
	
	public void createObject(String[] info)
	{
		String classType = info[0];
		String cause = info[1];
		String location = "";
		HashSet<String> locations = new HashSet<String>();
		for(String s : info) {
			s.replace("\"", "");
		}
		int i = 8;
		
		if(info[i].contains("~") && !info[i].endsWith("~")) {
			do {
				locations.add(info[i].replace("~", ""));
				i++;;
			} while(!info[i].contains("~"));
			locations.add(info[i].replace("~", ""));
			
		}
		else if (info[i].startsWith("~") && info[i].endsWith("~")) {
			locations.add(info[i].replace("~", ""));
		}
		else {
			location = info[i];
		}
		i++;
		if(classType.contains("Local")) {
			charities.put(new Local(info[2], info[3], Float.parseFloat(info[4]), info[5], info[6], info[7].contains("True"), locations, Integer.parseInt(info[i])), cause);	
		}
		else if (classType.contains("National")) {
			charities.put(new National(info[2], info[3], Float.parseFloat(info[4]), info[5], info[6], info[7].contains("True"), location, Integer.parseInt(info[i])), cause);
		}
		else if (classType.contains("International")) {
			charities.put(new International(info[2], info[3], Float.parseFloat(info[4]), info[5], info[6], info[7].contains("True"), locations, Integer.parseInt(info[i]), info[i+1]), cause);
		}
		else {
			log.warning("Charity Type invalid");
		}
		/**
		 * Decoupled file handler once I figure out how to do that
		if(info.length == i) {
			
		}
		else {
			
		}
				
				
		
			try {
			
				Class temp = Class.forName(classType);
			}
			catch(Exception e) {
				log.warning("Information is in an invalid format for line " + lineNum);
			}
		 * 	
		 * }
		 * catch {
		 * 		) 
		 * } 
		 * charities.add(cause, temp);
		 * 
		 */
		lineNum++;
	}

}
