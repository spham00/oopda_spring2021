package v1;

/**
 * The Instructor class represents an instructor with a department, who is also a Person.
 * 
 * @author 	Sarah Pham
 * @version	March 14, 2021
 */
public class Instructor extends Person {

	private String department;	// The department the instructor works in.
	
	/**
	 * Creates an instructor with the user-entered values.
	 * 
	 * @param firstName		The instructor's first name.
	 * @param middleName	The instructor's middle name.
	 * @param lastName		The instructor's last name.
	 * @param email			The instructor's email.
	 * @param ssn			The instructor's social security number.
	 * @param age			The instructor's age.
	 * @param department	The instructor's department.
	 */
	public Instructor(String firstName, String middleName, String lastName, String email, String ssn, int age, String department) {
		super(firstName, middleName, lastName, email, ssn, age);
		this.department = department;
	}

	/**
	 * Returns the department the instructor works in.
	 * 
	 * @return	The department the instructor works in.
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Changes the instructor's department to the user-entered department.
	 * 
	 * @param department	The instructor's new department.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

}
