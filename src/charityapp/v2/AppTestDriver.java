package charityapp.v2;

public class AppTestDriver {

	public static void main(String[] args) {
		Cause cause = new Cause("All");
		cause.setCharities(new fileHandler().getCharities("All"));
		System.out.println("--- Testing display methods ---");
		cause.getCharities().forEach(c -> System.out.println(c.display()));
		System.out.println("\n--- Testing sort by name ---");
		cause.setCharities(Sorter.sortByNameDescending(cause.getCharities()));
		cause.getCharities().forEach(c -> System.out.println(c.display()));
		System.out.println("\n--- Testing get by name ---");
		System.out.println(cause.getByName("Red Cross").getName());
		fileHandler l = new fileHandler();
		l.createReport(cause.getByName("Red Cross"));
	}

}
