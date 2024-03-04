package helen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Theatre {
	
	private String name;
	private ArrayList<Seat> seats = new ArrayList<Seat>();
	
	private int orchestraCounter = 0;
	private int mezzanineCounter = 0;
	
	public Theatre() { } // The default constructor
	
	// You need to complete this constructor
	
	public Theatre(String filename) throws TheatreFileNotFoundException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			name = reader.readLine();
			
			for(int i = 1; i < 2; i++) {
				reader.readLine();
			}
			
			String s = null;
			while((s = reader.readLine()) != null) {
				String[] fields = s.split(",");
				
				int firstSeat = Integer.parseInt(fields[2]);
				int numberOfSeats = Integer.parseInt(fields[3]) - firstSeat;
				for(int i = 0; i <= numberOfSeats; i++) {
					if (fields[0].equals("Orchestra")) {
						this.addSeat(new OrchestraSeat(fields[1], firstSeat + i));
						orchestraCounter++;
					}
					else if (fields[0].equals("Mezzanine")) {
						this.addSeat(new MezzanineSeat(fields[1], firstSeat + i));
						mezzanineCounter++;
					}
				}
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			throw new TheatreFileNotFoundException("The file named " + filename + " not found");
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Exception found");
		}
	}

	/**
	 * The addSeat method will add a new seat to the 
	 * array list of seats for a theatre.
	 * 
	 * @param seat		The Seat to be added
	 */
	public void addSeat(Seat seat) {
		this.seats.add(seat);
	}
	
	// You need to complete the following three methods
	
	/**
	 * listSeats() will display every seat in the theatre 
	 * on a new line.
	 */
	public void listSeats() {
		System.out.println("\nHere is the list of seats:\n");
		
		for (Seat seat: seats) {
			System.out.println(seat.getClass().getSimpleName() + " " + seat.getRow() + "-" + seat.getSeatNumber());
		}
	}

	/**
	 * orchestraSeats() will return the number of orchestra
	 * seats for this theatre.
	 * 
	 * @return		# of orchestra seas
	 */
	public int orchestraSeats() {
		return orchestraCounter;
	}

	/**
	 * mezzanineSeats() will return the number of mezzanine
	 * seats for this theatre.
	 * 
	 * @return		# of orchestra seas
	 */
	public int mezzanineSeats() {
		return mezzanineCounter;
	}
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	
}
