package problem;

/**
 * The class Dog represents a dog with different characteristics.
 * 
 * @author	Colin Lambe
 */
public class Dog extends Pet{
	String breed;			// What breed the dog is.
	boolean fixed;			// Whether the dog is fixed or not.
	boolean houseTrained;	// Whether the dog is house-trained or not.
	boolean aggressive;		// Whether the dog is aggressive or not.
	int weight;				// The weight of the dog.
	
	/**
	 * Creates a dog with the user-entered parameters.
	 * 
	 * @param name			The name of the dog.
	 * @param age			The age of the dog.
	 * @param weight		The weight of the dog.
	 * @param sex			The gender of the dog.
	 * @param breed			The breed of the dog.
	 * @param fixed			Whether the dog is fixed or not.
	 * @param houseTrained	Whether the dog is house-trained or not.
	 * @param aggressive	Whether the dog is aggressive or not.
	 */
	public Dog(String name, int age, int weight, char sex, String breed, boolean fixed, boolean houseTrained,
			boolean aggressive) {
		super(name, age, sex);
		this.weight = weight;
		this.breed = breed;
		this.fixed = fixed;
		this.houseTrained = houseTrained;
		this.aggressive = aggressive;
	}
	
	/**
	 * Returns the characteristics of the dog in a formatted way.
	 * @return	The characteristics of the dog in a formatted way.
	 */
	public String toString() {
		String gender = sex == 'f' ? "female" : "male";
		return "\nDog's name: " + name
				+ "\n\tAge: " + age
				+ "\n\tWeight: " + weight + " pounds"
				+ "\n\tGender: " + gender
				+ "\n\tBreed: " + breed
				+ "\n\tFixed: " + fixed
				+ "\n\tHouse trained: " + houseTrained
				+ "\n\tAggressive: " + aggressive;
	}

	// Getters and setters.
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public boolean isHouseTrained() {
		return houseTrained;
	}

	public void setHouseTrained(boolean houseTrained) {
		this.houseTrained = houseTrained;
	}

	public boolean isAggressive() {
		return aggressive;
	}

	public void setAggressive(boolean aggressive) {
		this.aggressive = aggressive;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
