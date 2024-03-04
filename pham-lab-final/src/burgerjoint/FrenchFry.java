package burgerjoint;

import java.util.function.Consumer;

public class FrenchFry extends Item implements Promptable {

	private Consumer<FrenchFry> prompting = f -> System.out.println(f);
			
	public FrenchFry() {
	}

	public void prompt() {
		prompting.accept(this);
	}
	
	public String toString() {
		return "You have ordered a FrenchFry - supersized, large or regular?";
	}

}
