package foxes_rabbits_v2;

import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * A simple model of a fox.
 * Foxes age, move, eat rabbits, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Fox extends Animal
{
    // Characteristics shared by all foxes (class variables).
    
    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.08;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 9;
    // The food value of a single mouse. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int MOUSE_FOOD_VALUE = 3;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    // Individual characteristics (instance fields).
    // The fox's food level, which is increased by eating rabbits and mice.
    private int foodLevel;

    /**
     * Create a fox. A fox can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Fox(boolean randomAge, Field field, Location location)
    {
        super(randomAge, field, location);
    }
    
    /**
     * When a fox is created, its age can either be randomized or not.
     * 
     * @param randomAge	Whether the age should be randomized or not.
     */
    public void setRandomAge (boolean randomAge) {
    	if(randomAge) {
            setAge(rand.nextInt(MAX_AGE));
            foodLevel = rand.nextInt(RABBIT_FOOD_VALUE) + rand.nextInt(MOUSE_FOOD_VALUE);
        }
        else {
            foodLevel = RABBIT_FOOD_VALUE + MOUSE_FOOD_VALUE;
        }
    }
    
    /**
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newFoxes A list to return newly born foxes.
     */
    public void act(List<Animal> newFoxes)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newFoxes);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
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
     * Returns the maximum age of a fox.
     * @return	The maximum age of a fox.
     */
    public int getMaxAge() {
    	return MAX_AGE;
    }
    
    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    /**
     * Look for rabbits and mice adjacent to the current location.
     * Only the first live rabbit or mouse is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isAlive()) { 
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
            else if (animal instanceof Mouse) {
            	Mouse mouse = (Mouse) animal;
            	if (mouse.isAlive()) {
            		mouse.setDead();
            		foodLevel = MOUSE_FOOD_VALUE;
            		// Remove the dead rabbit from the field.
            		return where;
            	}
            }
        }
        return null;
    }
    
    /**
     * Check whether or not this fox is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newFoxes A list to return newly born foxes.
    private void giveBirth(List<Animal> newFoxes)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Fox young = new Fox(false, field, loc);
            newFoxes.add(young);
        }
    }
    */
    
    /**
     * Returns the breeding age of a fox.
     * @return	The age a fox can breed.
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
     * Returns the fox's breeding probability.
     * @return	The fox's breeding probability.
     */
    public double getBreedingProbability() {
    	return BREEDING_PROBABILITY;
    }
    
    /**
     * Returns the fox's max litter size.
     * @return	The fox's max litter size.
     */
    public int getMaxLitterSize() {
    	return MAX_LITTER_SIZE;
    }
    
    /**
     * Returns the created fox.
     * 
     * @param	The location of the fox.
     * @param	The field of the fox.
     * @return	The created fox.
     */
    public Animal createAnimalYoung(Field field, Location loc) {
    	return new Fox(false, field, loc);
    }
}