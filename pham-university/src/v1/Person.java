package v1;

import java.util.HashMap;
import java.util.function.Predicate;

/**
 * The Person class represents one person, each with certain properties.
 * 
 * @author 	Sarah Pham
 * @version	March 14, 2021
 */
public class Person {

	private static long id = 916421998;	// The last person's ID.
	private String firstName;			// The person's first name.
	private String middleName;			// The person's middle name.
	private String lastName;			// The person's last name.
	private String email;				// The person's email address.
	private String ssn;					// The person's social security number.
	private int age;					// The person's age.

	public static HashMap<String, Predicate<Person>> order;	// Evaluates whether people are youngest/oldest.
	static {
		order = new HashMap<String, Predicate<Person>>();
		order.put("oldest", pers -> {
			int ageOfPers = pers.getAge();
			for (Person person : Driver.people.values()) {
				if (ageOfPers < person.getAge()) {
					return false;
				}
			}
			return true;
		});
		order.put("youngest", pers -> {
			int ageOfPers = pers.getAge();
			for (Person person : Driver.people.values()) {
				if (ageOfPers > person.getAge()) {
					return false;
				}
			}
			return true;
		});
	}

	/**
	 * Creates a person with the user-entered values and assigns an ID.
	 * 
	 * @param firstName		The person's first name.
	 * @param middleName	The person's middle name.
	 * @param lastName		The person's last name.
	 * @param email			The person's email address.
	 * @param ssn			The person's social security number.
	 * @param age			The person's age.
	 */
	public Person(String firstName, String middleName, String lastName, String email, String ssn, int age) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		id++;							// Assigns ID based on the previous person's ID.

		if (checkEmail(email)) {
			this.email = email;
		}
		else {
			System.out.println("Email is invalid");
		}

		if (checkSSN(ssn)) {
			this.ssn = ssn;
		}
		else {
			System.out.println("SSN is invalid");
		}

		if (checkAge(age)) {
			this.age = age;
		}
		else {
			System.out.println("Age is invalid");
		}
	}

	/**
	 * Checks if the age is valid or not.
	 * 
	 * @param age	The age being tested.
	 * @return		Whether the age is valid or not.
	 */
	public static boolean checkAge(int age) {
		if (age < 16) {
			System.out.println("Age must be greater than 16");
			return false;
		}
		else if (age > 123) {
			System.out.println("Age cannot be greater than the oldest person in the world");
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Checks if the email is valid or not.
	 * 
	 * @param email		The email being tested.
	 * @return			Whether the email is valid or not.
	 */
	public static boolean checkEmail(String email) {
		String pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9]*)*@[A-Za-z0-9][A-Za-z0-9-][A-Za-z0-9-]*.[A-Za-z0-9][A-Za-z0-9-][A-Za-z0-9-.]*$";
		boolean match = email.matches(pattern);

		// If the email doesn't match, execute this
		if (!match) {
			String atSign = "@";
			if (!email.contains(atSign)) {
				System.out.println("The email requires an @ sign");
			}
			else if (email.indexOf(atSign) != email.lastIndexOf(atSign)) {		// Tests if there are more @ than required
				System.out.println("The email requires only one @ sign");
			}
			else {
				int indexAfterSign = email.indexOf(atSign) + 1;
				String domain = email.substring(indexAfterSign, email.length());

				if (email.indexOf(atSign) == 0) {
					System.out.println("There needs to be at least one character at the start of the email before the @ sign");
				}
				if (!domain.contains(".")) {
					System.out.println("The email must have a dot (.) in its domain");
				}
				else {
					if (email.substring(indexAfterSign, indexAfterSign + 2).contains(".")) {
						System.out.println("Email must have at least 2 characters in the domain name before the dot (.)");
					}
					if (domain.length() - domain.indexOf(".") < 3) {
						System.out.println("Email must have at least 2 characters in the domain name after the dot (.)");
					}
				}
			}
			System.out.println("Please make sure that each character is a letter, number, @, or dot (.)");
		}
		return match;
	}

	/**
	 * Checks if the social security number is valid or not.
	 * 
	 * @param ssn	The social security number being tested.
	 * @return		Whether the social security number is valid or not.
	 */
	public static boolean checkSSN(String ssn) {
		String pattern = "[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]";
		boolean match = ssn.matches(pattern);

		if (!match) {
			String dash = "-";

			if (ssn.length() != 11) {
				System.out.println("SSN needs to be 11 characters long, including hyphens");
			}
			else {
				if (ssn.substring(3, 4).contains(dash) && ssn.substring(6,7).contains(dash)) {
					if (!ssn.substring(0,3).matches("[0-9][0-9][0-9]")) {
						System.out.println("The first three characters should be integers");
					}
					if (!ssn.substring(4,6).matches("[0-9][0-9]")) {
						System.out.println("The characters between the hyphens should be integers");
					}
					if (!ssn.substring(7, ssn.length()).matches("[0-9][0-9][0-9][0-9]")) {
						System.out.println("The last four characters should be integers");
					}
				}
				else {
					System.out.println("The SSN needs hyphens according to the format: ####-##-###, where # represents integers");
					if (ssn.indexOf(dash) == ssn.lastIndexOf(dash)) {
						//TODO Figure out how to count multiple instances maybe?
						System.out.println("There needs to be two hyphens in the SSN");
					}
				}
			}
		}
		return match;
	}

	@Override
	/**
	 * Returns the person's first name, middle name (if any), and last name.
	 * 
	 * @return	The person's first name, middle name (if any), and last name.
	 */
	public String toString() {
		if (middleName == "") {
			return firstName + " " + lastName;
		}
		else {
			return firstName + " " + middleName + " " + lastName;	
		}
	}

	/**
	 * Returns the person's email domain.
	 * 
	 * @return	The person's email domain.
	 */
	public String getEmailDomain() {
		return email.substring(email.indexOf("@") + 1, email.length());
	}

	/**
	 * Returns the last 4 digits of the person's social security  number.
	 * 
	 * @return	The last 4 digits of the person's social security  number.
	 */
	public String getLast4SSN() {
		return ssn.substring(7, ssn.length());
	}

	/**
	 * Returns the person's ID.
	 * 
	 * @return	The person's ID.
	 */
	public long getID() {
		return id;
	}

	/**
	 * Returns the person's first name.
	 * 
	 * @return	The person's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Changes the person's first name to the user-entered name.
	 * 
	 * @param firstName		The person's new first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the person's middle name.
	 * 
	 * @return	The person's middle name.
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Changes the person's middle name to the user-entered name.
	 * 
	 * @param middleName	The person's new middle name.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Returns the person's last name.
	 * 
	 * @return	The person's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Changes the person's last name to the user-entered name.
	 * 
	 * @param lastName		The person's new last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the person's email address.
	 * 
	 * @return	The person's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Changes the person's email address to the user-entered email.
	 * 
	 * @param email		The person's new email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the person's social security number.
	 * 
	 * @return	The person's social security number.
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * Changes the person's social security number to the user-specified number.
	 * 
	 * @param ssn		The person's new social security number.
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * Returns the person's age.
	 * 
	 * @return	The person's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Changes the person's age to the user-specified age.
	 * 
	 * @param age		The person's new age.
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
