package burgerjoint;

import java.util.function.Consumer;

public class Shake extends Item implements Promptable {

	private Consumer<Shake> prompting = s -> System.out.println(s);
	
	public Shake() {
	}
	
	public void prompt() {
		prompting.accept(this);
	}
	
	public String toString() {
		return "You have ordered a Shake - vanilla, chocolate or strawberry?";
	}

}
