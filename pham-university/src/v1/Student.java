package v1;

/**
 * The Student class represents a student with a major, who is also a Person.
 * 
 * @author 	Sarah Pham
 * @version	March 14, 2021
 */
public class Student extends Person {

	private String major;	// The major of the student.
	
	/**
	 * Creates a student based on the user-entered values.
	 * 
	 * @param firstName		The student's first name.
	 * @param middleName	The student's middle name.
	 * @param lastName		The student's last name.
	 * @param email			The student's email.
	 * @param ssn			The student's social security number.
	 * @param age			The student's age.
	 * @param major			The student's major.
	 */
	public Student(String firstName, String middleName, String lastName, String email, String ssn, int age, String major) {
		super(firstName, middleName, lastName, email, ssn, age);
		this.major = major;
	}

	/**
	 * Returns the student's major.
	 * 
	 * @return	The student's major.
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * Changes the student's major to the user-entered major.
	 * 
	 * @param major		The student's new major.
	 */
	public void setMajor(String major) {
		this.major = major;
	}
}
