package foxes_rabbits_v2;

import java.util.List;
import java.util.Random;

/**
 * The Mouse class represents a mouse, who can be age, move, breed, and die.
 * 
 * @author Sarah Pham
 */
public class Mouse extends Animal {

	// Characteristics shared by all mice (class variables).

    // The age at which a mouse can start to breed.
    private static final int BREEDING_AGE = 4;
    // The age to which a mouse can live.
    private static final int MAX_AGE = 50;
    // The likelihood of a mouse breeding.
    private static final double BREEDING_PROBABILITY = 0.10;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
	public Mouse(boolean randomAge, Field field, Location location) {
		super(randomAge, field, location);
	}
	
	public void setRandomAge (boolean randomAge) {
    	if(randomAge) {
            setAge(rand.nextInt(MAX_AGE));
        }
    }
    
    /**
     * This is what the mouse does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newMice A list to return newly born mice.
     */
    public void act(List<Animal> newMice)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newMice);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Returns the maximum age of a mouse.
     * @return	The maximum age of a mouse.
     */
    public int getMaxAge() {
    	return MAX_AGE;
    }
    
    /**
     * Check whether or not this mouse is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newMice A list to return newly born mice.
    private void giveBirth(List<Animal> newMice)
    {
        // New mice are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Mouse young = new Mouse(false, field, loc);
            newMice.add(young);
        }
    }
    */
    
    /**
     * Returns the breeding age of a mouse.
     * @return	The age a mouse can breed.
     */
    public int getBreedingAge() {
    	return BREEDING_AGE;
    }
    
    /**
     * Returns the random number generator.
     * @return	The random number generator.
     */
    public Random getRand() {
    	return rand;
    }
    
    /**
     * Returns the mouse's breeding probability.
     * @return	The mouse's breeding probability.
     */
    public double getBreedingProbability() {
    	return BREEDING_PROBABILITY;
    }
    
    /**
     * Returns the mouse's max litter size.
     * @return	The mouse's max litter size.
     */
    public int getMaxLitterSize() {
    	return MAX_LITTER_SIZE;
    }

    /**
     * Returns the created mouse.
     * 
     * @param	The location of the mouse.
     * @param	The field of the mouse.
     * @return	The created mouse.
     */
    public Animal createAnimalYoung(Field field, Location loc) {
    	return new Mouse(false, field, loc);
    }
}
