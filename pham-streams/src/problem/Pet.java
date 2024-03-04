package problem;

/**
 * The abstract class Pet represents a pet animal that has its own characteristics.
 * 
 * @author	Colin Lambe
 */
public abstract class Pet {
	String name;		// The name of the pet.
	int age;			// The age of the pet.
	char sex;			// The gender of the pet.
	
	/**
	 * A constructor used to help create a pet animal.
	 * 
	 * @param name	The name of the pet.
	 * @param age	The age of the pet.
	 * @param sex	The gender of the pet ("f" for female, "m" for male).
	 */
	public Pet(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	// Getters and setters.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
	
}
