package practice_for_lab_final;

import java.util.ArrayList;

public class Driver {

	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		makeEmployees();
		printOutEmployees();
		moveEmployeesToB();
	}
	
	private static void makeEmployees() {
		employees.add(new Cashier("Felix", "Kjellberg", 31, 1, 2));
		employees.add(new Cashier("Joel", "Gutenberg", 34, 2, 8));
		employees.add(new Packer("Marzia", "Kjellberg", 29, 3, Sector.A));
	}

	private static void printOutEmployees() {
		System.out.println("List of Employees: ");
		employees.forEach(p -> System.out.println(p));
	}
	
	private static void moveEmployeesToB() {
		employees.forEach(p -> p.moveToSector(Sector.B));
		
		// Display the state of Marzia to check whether her sector was moved.
		System.out.println("\nChecking whether Marzia was moved: ");
		System.out.println(employees.get(2));
	}
}
