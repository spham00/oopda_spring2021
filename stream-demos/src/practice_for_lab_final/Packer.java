package practice_for_lab_final;

/**
 * Packs the food onto the shelves.
 * 
 * @author Sarah
 */
public class Packer extends Employee {

	private Sector sector;
	
	public Packer(String firstName, String lastName, int age, int ID, Sector sector) {
		super(firstName, lastName, age, ID);
		this.sector = sector;
	}
	
	public void moveToSector(Sector sector) {
		this.sector = sector;
		System.out.println("\n" + getFirstName() + " " + getLastName() + " moved to sector " + sector);
	}
	
	public String toString() {
		return "\nPacker" + "\nName: " + getFirstName() + " " + getLastName() + "\nAge: " +
				getAge() + "\nID: " + getID() + "\nSector: " + sector;
	}

	// Getters and setters.
	public Sector getSector() {
		return sector;
	}

}
