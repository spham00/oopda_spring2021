package celebrity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamDriver {

	private enum Names {Amber, Ashley, Agnes, Boxer, Boris, Baby, CutiePie, Cocoa, 
	      Darla, Dave, Desmond, Dexter, Elf, Edie, Eddie, Friendly, 
	      Figgy, GrapeNuts, Gary, Giggles, Harvey, Harriette, Iris, 
	      India, Jasmine, Jerry, Julie, Jasper, Jangles, Jingle, Harper,
	      Sam, Sugar, Cinnamon, Larry, Lulu, Morris, Mannie, Moe, Mame,
	      Nancy, Knickers, Sneakers, Almond, Baxter, Violet, Vera, Tinkerbelle,
	      Tammy, Tiger, Terence, Wanda, Whisper, Zoey, Sylvia };

	
	public static void main(String[] args) {
		Map<Integer, Celebrity> celebrities = new HashMap<Integer, Celebrity>();
		populateCelebrities(celebrities);
		
		// Make collection of celebrity kittens and then print out the kittens
		// A kitten is a Cat that is 6 months old or younger.
		
		ArrayList<Pet> kittens = new ArrayList<Pet>();
		
		// for (Celebrity c : celebrities.values()) {
		kittens = add(celebrities.values().forEach(p -> p.getPets().stream().filter(p -> p instanceof Cat)
				.filter(p -> ((Cat)p).getAgeInMonths() <= 6)
				.collect(Collectors.toList()));
		}
	}

	private static void populateCelebrities(Map<Integer, Celebrity> celebrities) {
		int i = 0;
		celebrities.put(++i, new Celebrity("Liam", "Hemsworth"));
		celebrities.put(++i, new Celebrity("Tom", "Cruise"));
		celebrities.put(++i, new Celebrity("Amy", "Adams"));
		celebrities.put(++i, new Celebrity("Ben", "Affleck"));
		celebrities.put(++i, new Celebrity("Jonah", "Hill"));
		celebrities.put(++i, new Celebrity("Kanye", "West"));
		celebrities.put(++i, new Celebrity("Denzel", "Washington"));
		celebrities.put(++i, new Celebrity("Meryl", "Streep"));
		celebrities.put(++i, new Celebrity("Howard", "Stern"));
		celebrities.put(++i, new Celebrity("Garth", "Brooks"));
		celebrities.put(++i, new Celebrity("Ariana", "Grande"));
		celebrities.put(++i, new Celebrity("Taylor", "Swift"));
		celebrities.put(++i, new Celebrity("Robert", "Downey"));
		celebrities.put(++i, new Celebrity("Ellen", "DeGeneres"));
		celebrities.put(++i, new Celebrity("Justin", "Timberlake"));
		celebrities.put(++i, new Celebrity("Sean", "Combs"));
		celebrities.put(++i, new Celebrity("Beyonce", "Knowles"));
		celebrities.put(++i, new Celebrity("Jennifer", "Lawrence"));
		celebrities.put(++i, new Celebrity("Bradley", "Cooper"));
		celebrities.put(++i, new Celebrity("Jared", "Leto"));
		
		Random random = new Random(4); // with a seed for constant results
		
		for (int c = 1; c <= 20; c++) {
			// Add random pets to celebrities
			int numDogs = random.nextInt(3);
			int numCats = random.nextInt(4);
			for (int j = 0; j < numDogs; j++) {
				celebrities.get(c).addPet(new Dog(Names.values()[random.nextInt(Names.values().length)].toString(), random.nextInt(49)+1));
			}
			for (int j = 0; j < numDogs; j++) {
				celebrities.get(c).addPet(new Cat(Names.values()[random.nextInt(Names.values().length)].toString(), random.nextInt(49)+1));
			}
			System.out.println(celebrities.get(c));
		}
		System.out.println();
	}

}