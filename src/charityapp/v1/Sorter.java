package charityapp.v1;

import java.util.ArrayList;
import java.util.Comparator;

public class Sorter {

	public Sorter() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Charity> sortByNameDescending(ArrayList<Charity> toSort) {
		toSort.sort(Comparator.comparing(Charity::getName));
		return toSort;
	}

}