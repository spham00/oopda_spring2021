package practice_for_lab_final;

/**
 * The Employee class is a class that represents all employees under a grocery store.
 * 
 * @author Sarah Pham
 */
public abstract class Employee {
	
	private String firstName;
	private String lastName;
	private int age;
	private int ID;

	// Creates the Employee
	public Employee(String firstName, String lastName, int age, int ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ID = ID;
	}
	
	abstract public void moveToSector(Sector sector);

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
