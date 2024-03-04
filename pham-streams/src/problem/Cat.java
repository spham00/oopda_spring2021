package problem;

/**
 * The class Cat represents a cat with different characteristics.
 * 
 * @author	Colin Lambe
 */
public class Cat extends Pet {
	boolean declawed;			// Whether the cat is declawed or not.
	boolean litterBoxTrained;	// Whether the cat is litter box-trained or not.
	
	/**
	 * Creates a cat with the user-entered parameters.
	 * 
	 * @param name				The name of the cat.
	 * @param age				The age of the cat.
	 * @param sex				The gender of the cat.
	 * @param declawed			Whether the cat is declawed or not.
	 * @param litterBoxTrained	Whether the cat is litter box-trained or not.
	 */
	public Cat(String name, int age, char sex, boolean declawed, boolean litterBoxTrained) {
		super(name, age, sex);
		this.declawed = declawed;
		this.litterBoxTrained = litterBoxTrained;
	}
	
	/**
	 * Returns the characteristics of the cat in a formatted way.
	 * @return	The characteristics of the cat in a formatted way.
	 */
	public String toString() {
		String gender = sex == 'f' ? "female" : "male";
		return "\nCat's name: " + name
				+ ("\n\tAge: " + age)
				+ ("\n\tGender: " + gender)
				+ ("\n\tDeclawed: " + declawed)
				+ ("\n\tLitterbox trained: " + litterBoxTrained);
	}

	// Getters and setters.
	public boolean isDeclawed() {
		return declawed;
	}

	public void setDeclawed(boolean declawed) {
		this.declawed = declawed;
	}

	public boolean isLitterBoxTrained() {
		return litterBoxTrained;
	}

	public void setLitterBoxTrained(boolean litterBoxTrained) {
		this.litterBoxTrained = litterBoxTrained;
	}
	
}
