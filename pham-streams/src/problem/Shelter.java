package problem;

import java.util.ArrayList;

/**
 * The class Shelter contains many pets.
 * 
 * @author	Colin Lambe
 */
public class Shelter {
	private ArrayList<Pet> pets;	// The collection of pets.
	
	/**
	 * When a Shelter is created, an empty collection of pets is also created.
	 */
	public Shelter() {
		pets = new ArrayList<Pet>();
	}
	
	// Getter
	public ArrayList<Pet> getPets(){
		return pets;
	}
	
	/**
	 * Creates and adds numerous pets to the collection of pets in the Shelter.
	 */
	public void initialize() {
		pets.add(new Dog("Brittany", 2, 50, 'f', "pitbull", true, false, false));
		pets.add(new Dog("Donnie", 6, 50, 'm', "lab", false, true, true));
		pets.add(new Dog("Eddie", 1, 30, 'm', "lab", true, false, false));
		pets.add(new Dog("Rico", 4, 60, 'm', "boxer", true, true, false));
		pets.add(new Dog("Princess", 8, 65, 'f', "pitbull", true, true, true));
		
		// Added another dog since no dog met the conditions for "the guard dog" to test.
		// This was because the description said "over 50 pounds" and the closest dog to fit this
		// was Donnie, but Donnie's weight is 50 exactly, not over.
		pets.add(new Dog("Beverly", 4, 70, 'm', "shepherd", true, true, true));
		
		pets.add(new Cat("Hammy", 10, 'f', false, true));
		pets.add(new Cat("Mr. Newt", 4, 'm', true, true));
		pets.add(new Cat("Mrs. Mary Mack", 1, 'f', false, false));
		pets.add(new Cat("Rufuss", 1, 'm', false, false));
		pets.add(new Cat("Zoomie", 0, 'f', false, false));
		
	}
}
