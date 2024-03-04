package stream;

import java.util.Comparator;

import javax.swing.JOptionPane;

public class Person implements Comparator {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String ssn;
	private int age;
	public enum Gender { MALE, FEMALE };
	private Gender gender;
	private double salary;
	static int maxAge;

	/**
	 * getFullName returns a Person's full name
	 * 
	 * @return string with format FirstName MiddleName LastName
	 */
	public String toString() {
		return firstName + " " + 
	           (middleName.length() == 0 ? "" : middleName + " ") +
			   lastName;
	}
	/**
	 * getEmailDomain returns the part of the email address after
	 * the "@" which corresponds to the domain.
	 * 
	 * @return the domain portion of the email address
	 */
	public String getEmailDomain() {
		int ampLocation = email.indexOf("@");
		return email.substring(ampLocation+1);
	}
	/**
	 * getLast4SSN returns the last four digits of a Social
	 * Security Number
	 * 
	 * @return last four digits of SSN
	 */
	public String getLast4SSN() {
		return ssn.substring(ssn.length()-4);
	}
	/**
	 * Static (class) method isValidEmail performs several validation checks.<br />
	 * - It ensures email address contains an '@' and a '.' character;<br />
	 * - It also checks that only one '@' is present in the email;<br />
	 * - It also will verify that at least one '.' follows the '@' character.
	 * 
	 * @param address The email address to be validated
	 * @return true on successful validation, otherwise false
	 */
	public static boolean isValidEmail(String address) {
		String errorMessage;
		if (!address.contains("@") || !address.contains(".")) {
			errorMessage = "Email address must contain both an ampersand and period.";
			JOptionPane.showMessageDialog(null, errorMessage);
			return false;
		}
		else if (address.lastIndexOf("@") != address.indexOf("@")) {
			errorMessage = "Email address cannot contain two ampersands.";
			JOptionPane.showMessageDialog(null, errorMessage);
			return false;
		}
		else if (address.lastIndexOf(".") < address.indexOf("@")) {
			errorMessage = "A period must follow the ampersand in an email address.";
			JOptionPane.showMessageDialog(null, errorMessage);
			return false;
		}
		else
			return true;
	}

	/**
	 * Static (class) method isValidSSN performs several validation checks.<br />
	 * - It ensures a Social Security Number (ssn) contains only digits and 
	 *   '-' characters;<br />
	 * - It ensures that exactly two '-' characters are present in the ssn
	 *   in the correct positions;<br />
	 * - It also will verify the length of 11 (including hyphens).
	 * 
	 * @param ssn The Social Security Number to be validated
	 * @return true on successful validation, otherwise false
	 */
	public static boolean isValidSSN(String ssn) {
		String errorMessage;
		char[] ssnChars = ssn.toCharArray();
		int numberOfHyphens = 0;
		
		for (int i=0; i < ssnChars.length; i++) {
			if (!Character.isDigit(ssnChars[i]) && ssnChars[i] != '-') {
				errorMessage = "Every character of an SSN must be a digit or a hyphen.";
				JOptionPane.showMessageDialog(null, errorMessage);
				return false;
			}
			else
				// Character is either a digit or a hyphen, let's count the hyphens!
				if (ssnChars[i] == '-') numberOfHyphens++;
		}
		
		// Make sure number of slashes is two
		if (numberOfHyphens != 2) {
			errorMessage = "SSNs must contain two hyphens.";
			JOptionPane.showMessageDialog(null, errorMessage);
			return false;
		}
		
		
		if (ssn.length() != 11) {
			errorMessage = "Length of SSN must be 11 characters including hyphens.";
			JOptionPane.showMessageDialog(null, errorMessage);
			return false;
		}
		else if (ssn.indexOf("-") != 3 || ssn.lastIndexOf("-") != 6) {
			errorMessage = "Hyphens must be included in the 4th and 7th positions.";
			JOptionPane.showMessageDialog(null, errorMessage);
			return false;
		}
		else
			return true;
	}
	
	/**
	 * Static (class) method isValidAge checks to see if the String can
	 * be turned into a valid integer and, if so, if that value is greater
	 * than 15.
	 *  
	 * @param myAge The age to be validated
	 * @return true on successful validation, otherwise false
	 */
	public static boolean isValidAge(String myAge) {
		String errorMessage;
		if (Integer.parseInt(myAge) > 15) {
			return true;
		}
		else {
			return false;
		}
	}	
	
	/**
	 * Method isOldest checks to see if a particular age is the max value for class
	 * or false if it is not
	 * 
	 * @return true if a person's age is the oldest (including ties), otherwise false
	 */
	public boolean isOldest() {
		if (this.age >= Person.maxAge) return true;
		else return false;
	}
	
	// Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
	
	// Constructors
	
	public Person(int id, String firstName, String middleName, String lastName,
			String email, String ssn, int age, Gender gender, double salary) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.ssn = ssn;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		
		if (age > Person.maxAge) {
			Person.maxAge = age;
		}
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((Person) o1).getAge() - ((Person) o2).getAge();
	}
	
}