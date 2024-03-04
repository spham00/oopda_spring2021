package problem;
import java.util.Random;

public class Driver {
	public static Random rng = new Random();
	
	public static void main(String[] args) throws Exception {
		try {
			callsRiskyCode();
		}
		catch (AnotherException ex) {
			ex.printStackTrace();
			System.out.println("Caught in main");
		}
	}

	//handle exceptions from risky code and throw custom exception
	public static void callsRiskyCode() throws AnotherException {
		for(int i = 0; i < 12; i++) {
			try {
				int n = rng.nextInt(100);
				int result = riskyCode(n);
				System.out.println(n + " -> " +result);
			}
			catch (SuperSpecificException ex) {
				System.out.println("Exception " + ex + ": n cannot be equal to 7");
			}
			catch (SpecificException ex) {
				System.out.println("Exception " + ex + ": n cannot be divisible by 6");
			}
			catch (GenericException ex) {
				System.out.println("Exception " + ex + ": n cannot be more than 80");
				throw new AnotherException("Thrown from Generic Exception");
			}
		}
	}

	//don't change method body
	public static int riskyCode(int n) throws GenericException{
		if(n % 6 == 0) {
			throw new SpecificException("Specific Exception!");
		}
		else if(n == 7) {
			throw new SuperSpecificException("More Specific Exception");
		}
		else if(n > 80) {
			throw new GenericException("Generic catch all exception");
		}
		else return 2 * n;
	}
}