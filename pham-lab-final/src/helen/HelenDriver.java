package helen;

public class HelenDriver { 
	
	public static void main(String[] args) throws TheatreFileNotFoundException {
		Theatre theatre = new Theatre("resources/helen.csv");
		/* You need to create two methods that return the number of
		 * Orchestra seats and Mezzanine seats to finish this printf statement. */
		System.out.printf("The %s has %d seats: %d orchestra and %d mezzanine.\n", 
				theatre.getName(), theatre.getSeats().size(),
				theatre.orchestraSeats(), theatre.mezzanineSeats());
		theatre.listSeats();
	}
}

