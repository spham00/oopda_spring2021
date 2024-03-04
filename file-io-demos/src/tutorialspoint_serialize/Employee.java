package tutorialspoint_serialize;

public class Employee implements java.io.Serializable {
	   public String name;
	   public String address;
	   public transient int SSN;	// Any nonserializable content must be marked transient
	   public int number;
	   
	   public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
}
