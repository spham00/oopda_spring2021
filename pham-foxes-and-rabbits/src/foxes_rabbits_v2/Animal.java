package foxes_rabbits_v2;

import java.util.List;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public abstract class Animal
{
	// Whether the animal is alive or not.
	private boolean alive;
	// The animal's field.
	private Field field;
	// The animal's position in the field.
	private Location location;
	// The age of the animal.
	private int age;

	/**
	 * Create a new animal at location in field.
	 * 
	 * @param field The field currently occupied.
	 * @param location The location within the field.
	 */
	public Animal(boolean randomAge, Field field, Location location)
	{
		alive = true;
		setAge(0);
		setRandomAge(randomAge);
		this.field = field;
		setLocation(location);
	}

	/**
	 * When constructed, if an animal has a random age, create the animal accordingly.
	 * @param randomAge	Whether the age of the animal being created should be randomized or not.
	 */
	abstract protected void setRandomAge (boolean randomAge);
	
	/**
	 * Creates an instance of an animal accordingly.
	 */
	abstract protected Animal createAnimalYoung(Field field, Location loc);

	/**
     * Check whether or not this animal is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newAnimals A list to return newly born animals.
     */
    protected void giveBirth(List<Animal> newAnimals)
    {
        // New animals are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = createAnimalYoung(field, loc);
            newAnimals.add(young);
        }
    }
	
	/**
	 * Returns the age of the animal.
	 * @return	The age of the animal.
	 */
	protected int getAge() {
		return age;
	}
	
	/**
	 * Sets the age to the input.
	 * @param age	The new age of the animal.
	 */
	protected void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Returns the maximum age of the animal.
	 * @return	The maximum age of the animal.
	 */
	abstract protected int getMaxAge();

	/**
	 * Increases the animal's age. This could result in the animal's death.
	 */
	protected void incrementAge() {
		age++;
        if(age > getMaxAge()) {
            setDead();
        }
	}
	
	/**
	 * Make this animal act - that is: make it do
	 * whatever it wants/needs to do.
	 * @param newAnimals A list to receive newly born animals.
	 */
	abstract protected void act(List<Animal> newAnimals);

	/**
	 * Check whether the animal is alive or not.
	 * @return true if the animal is still alive.
	 */
	protected boolean isAlive()
	{
		return alive;
	}

	/**
	 * Indicate that the animal is no longer alive.
	 * It is removed from the field.
	 */
	protected void setDead()
	{
		alive = false;
		if(location != null) {
			field.clear(location);
			location = null;
			field = null;
		}
	}

	/**
	 * Return the animal's location.
	 * @return The animal's location.
	 */
	protected Location getLocation()
	{
		return location;
	}

	/**
	 * Place the animal at the new location in the given field.
	 * @param newLocation The animal's new location.
	 */
	protected void setLocation(Location newLocation)
	{
		if(location != null) {
			field.clear(location);
		}
		location = newLocation;
		field.place(this, newLocation);
	}

	/**
	 * Return the animal's field.
	 * @return The animal's field.
	 */
	protected Field getField()
	{
		return field;
	}
	
	/**
	 * An animal can breed if it has reached the breeding age.
	 * @return true if the animal can breed
	 */
	protected boolean canBreed() {
		return age >= getBreedingAge();
	}
	
	/**
	 * Return the breeding age of this animal
	 * @return	The breeding age of this animal
	 */
	abstract protected int getBreedingAge();
	
	/**
	 * Returns the random number generator associated with the animal.
	 * @return	The random number generator associated with the animal.
	 */
	abstract protected Random getRand();
	
	/**
	 * Returns the breeding probability of this animal
	 * @return	The breeding probability of this animal
	 */
	abstract protected double getBreedingProbability();
	
	/**
	 * Returns the maximum litter size of this animal
	 * @return	The maximum litter size of this animal
	 */
	abstract protected int getMaxLitterSize();
	
	/**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    protected int breed()
    {
        int births = 0;
        if(canBreed() && getRand().nextDouble() <= getBreedingProbability()) {
            births = getRand().nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }
}