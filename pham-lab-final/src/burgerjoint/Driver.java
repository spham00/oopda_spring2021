package burgerjoint;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
	
		ArrayList<Item> orderedItems = new ArrayList<Item>();
		
		addItems(orderedItems);
		loopThroughItems(orderedItems);
	}
	
	private static void addItems(ArrayList<Item> orderedItems) {
		orderedItems.add(new BigMac());
		orderedItems.add(new FrenchFry());
		orderedItems.add(new BigMac());
		orderedItems.add(new Shake());
		orderedItems.add(new BigMac());
		orderedItems.add(new FrenchFry());
		orderedItems.add(new Shake());
	}
	
	private static void loopThroughItems(ArrayList<Item> orderedItems) {
		orderedItems.forEach(i -> {
			if (i instanceof Promptable) {
				((Promptable) i).prompt();
			}
			else {
				System.out.println(i);
			}
		});
	}
}
