package v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The Driver class displays a collection of people and their characteristics with predefined people and a
 * user-input-dependent person. This class will also evaluate the collection of people based on user-input.
 * 
 * @author 	Sarah Pham
 * @version March 14, 2021
 */
public class Driver {

	public static HashMap<Long, Person> people = new HashMap<>();	// The polymorphic collection of Persons.
	
	public static void main(String[] args) {
		// Checks how the user wants people to be evaluated by.
		Scanner sc = new Scanner(System.in);
		System.out.println("How should we evaluate? [Enter 'oldest' or 'youngest']: ");
		String evaluatorType = sc.nextLine();
		while (!evaluatorType.equals("oldest") && !evaluatorType.equals("youngest")) {
			System.out.println("Input must be 'oldest' or 'youngest': ");
			evaluatorType = sc.nextLine();
		}
		
		// Creates the persons in the collection.
		createPerson(sc);
		createStudent();		
		createInstructor();
		
		sc.close();
		
		// Displays all the persons in the people collection.
		displayPeople(evaluatorType);
	}
	
	/**
	 * Creates a Student named Jane Marie Doe and puts them in the collection of Persons.
	 */
	private static void createStudent() {
		Student doe = new Student("Jane", "Marie", "Doe", "doe@students.rowan.edu", "123-14-4444", 20, "Computer Science");
		people.put(doe.getID(), doe);
	}

	/**
	 * Creates an Instructor named Chia Chien and puts them in the collection of Persons.
	 */
	private static void createInstructor() {
		Instructor chien = new Instructor("Chia", "C.", "Chien", "chien@rowan.edu", "123-14-5555", 30, "Math/Science");
		people.put(chien.getID(), chien);
	}
	
	/**
	 * Creates a Person based on valid user-input, including checks, and puts them in the collection of Persons.
	 * 
	 * @param scanner	The scanner associated to get user input.
	 */
	private static void createPerson(Scanner scanner) {
		System.out.println("Enter person's first name: ");
		String firstName = scanner.nextLine();
		
		System.out.println("Enter person's middle name (if not applicable, press enter): ");
		String middleName = scanner.nextLine();
		
		System.out.println("Enter person's last name: ");
		String lastName = scanner.nextLine();
		
		System.out.println("Enter person's email address: ");
		String email = scanner.nextLine();
		while (!Person.checkEmail(email)) {
			System.out.println("Please try again: ");
			email = scanner.nextLine();
		}
		
		System.out.println("Enter person's SSN in ###-##-#### format: ");
		String ssn = scanner.nextLine();
		while (!Person.checkSSN(ssn)) {
			System.out.println("Please try again: ");
			ssn = scanner.nextLine();
		}
		
		System.out.println("Enter person's age: ");
		int age = scanner.nextInt();
		while (!Person.checkAge(age)) {
			System.out.println("Please try again: ");
			age = scanner.nextInt();
		}
		
		Person person = new Person(firstName, middleName, lastName, email, ssn, age);
		people.put(person.getID(), person);
	}
	
	/**
	 * Displays every person's information within the people collection.
	 * 
	 * @param evaluatorType	Whether the user wants to evaluate the people as oldest or youngest.
	 */
	private static void displayPeople(String evaluatorType) {
		people.forEach((k, v) -> {
			System.out.println("\n" + k);
			System.out.println(v + " (" + v.getClass().getSimpleName() + ")");
			System.out.println(v.getEmailDomain());
			System.out.println(v.getLast4SSN());
			System.out.println(evaluatorType + ": " + Person.order.get(evaluatorType).test(v));
			if (v instanceof Instructor) {
				System.out.println(((Instructor)v).getDepartment());
			}
			else if(v instanceof Student) {
				System.out.println(((Student)v).getMajor());
			}
		});
	}
}
