package foxes_rabbits_v2;

import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Rabbit extends Animal
{
    // Characteristics shared by all rabbits (class variables).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.12;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(randomAge, field, location);
    }
    
    public void setRandomAge (boolean randomAge) {
    	if(randomAge) {
            setAge(rand.nextInt(MAX_AGE));
        }
    }
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to return newly born rabbits.
     */
    public void act(List<Animal> newRabbits)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newRabbits);            
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
     * Returns the maximum age of a rabbit.
     * @return	The maximum age of a rabbit.
     */
    public int getMaxAge() {
    	return MAX_AGE;
    }
    
    /**
     * Check whether or not this rabbit is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newRabbits A list to return newly born rabbits.
    private void giveBirth(List<Animal> newRabbits)
    {
        // New rabbits are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Rabbit young = new Rabbit(false, field, loc);
            newRabbits.add(young);
        }
    }
    */
    
    /**
     * Returns the breeding age of a rabbit.
     * @return	The age a rabbit can breed.
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
     * Returns the rabbit's breeding probability.
     * @return	The rabbit's breeding probability.
     */
    public double getBreedingProbability() {
    	return BREEDING_PROBABILITY;
    }
    
    /**
     * Returns the rabbit's max litter size.
     * @return	The rabbit's max litter size.
     */
    public int getMaxLitterSize() {
    	return MAX_LITTER_SIZE;
    }
    
    /**
     * Returns the created rabbit.
     * 
     * @param	The location of the rabbit.
     * @param	The field of the rabbit.
     * @return	The created rabbit.
     */
    public Animal createAnimalYoung(Field field, Location loc) {
    	return new Rabbit(false, field, loc);
    }
}