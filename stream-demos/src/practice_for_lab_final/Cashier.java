package practice_for_lab_final;

/**
 * The Cashier is an Employee for the grocery store.
 * 
 * @author Sarah
 */
public class Cashier extends Employee {

	private int station;
	
	public Cashier(String firstName, String lastName, int age, int ID, int station) {
		super(firstName, lastName, age, ID);
		this.station = station;
	}
	
	public void moveToSector(Sector sector) {
		System.out.println("\nUnable to move " + getFirstName() + " " + getLastName() +
				" because they are a Cashier");
	}

	public String toString() {
		return "\nCashier" + "\nName: " + getFirstName() + " " + getLastName() + "\nAge: " +
				getAge() + "\nID: " + getID() + "\nStation: " + station;
	}
	
	// Getters and setters
	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

}
