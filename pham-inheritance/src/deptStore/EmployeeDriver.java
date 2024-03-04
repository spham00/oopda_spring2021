package deptStore;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.ArrayList;

/**
 * A Driver to display Employees created
 * 
 * @author OOPDA Instructor
 *
 */
public class EmployeeDriver {
	private static HashSet<Employee> employees = new HashSet<>();	// HashSet of employees.
	
	public static void main(String[] args) {
		makeEmployees();								// Creates employees.
		employees.forEach(e -> simulateSalesDay(e));	// Simulates one sales day.
		displayEmployees();								// Displays the statuses of the employees.
	}
	
	/**
	 * This method creates an instance of all three types of
	 * Employees and adds them to a HashSet.
	 */
	private static void makeEmployees() {
		Cashier cashier1 = new Cashier("Franny Wilkins", 100, 10.75, 200);
		Cashier cashier2 = new Cashier("Barbara Smith", 76, 11.00, 100);
		SalesAssociate sa = new SalesAssociate("Will Martin", 166, 11.50, "Shoes");
			
		employees.add(sa);	
		employees.add(cashier1);
		employees.add(cashier2);
	}
	
	/**
	 * Simulates a sales day depending on what type of employee is entered.
	 * 
	 * @param emp	The employee that the a sales day is simulated on.
	 */
	private static void simulateSalesDay(Employee emp) {
		if (emp instanceof Cashier) {
			makeTransactions((Cashier) emp);
		}
		else if (emp instanceof SalesAssociate) {
			makeSales((SalesAssociate) emp);
		}
	}
	
	/**
	 * Generates a random amount of transactions to simulate them for the day.
	 * 
	 * @param emp	The employee who makes the random amount of transactions.
	 */
	private static void makeTransactions(Cashier emp) {
		// Set parameters for the simulation
		final int MIN_SALES = 4;
		final int MAX_SALES = 30;
		final int MIN_RETURNS = 0;
		final int MAX_RETURNS = 3;

		int randomSales = ThreadLocalRandom.current().nextInt(MIN_SALES, MAX_SALES + 1);
		int randomReturns = ThreadLocalRandom.current().nextInt(MIN_RETURNS, MAX_RETURNS + 1);
		double randomAmount;
		
		// Simulate the sales for the day 
		for (int i = 0; i < randomSales; i++) {
			randomAmount = 	(double) ThreadLocalRandom.current().nextInt(1000, 25000) / 100;
			emp.ringup(randomAmount);
			System.out.println(emp.getName() + " rang up $" + randomAmount);
		}
		
		// Simulate the returns for the day 
		for (int i = 0; i < randomReturns; i++) {
			randomAmount = 	(double) ThreadLocalRandom.current().nextInt(1000, 25000) / 100;
			emp.completeReturn(randomAmount);
			System.out.println(emp.getName() + " processed return of $" + randomAmount);
		}
	}

	/**
	 * Generates a random amount of sales to simulate them for the day.
	 * 
	 * @param emp	The employee who makes the random amount of sales.
	 */
	private static void makeSales(SalesAssociate emp) {
		// Set parameters for the simulation
		final int MIN_SALES = 0;
		final int MAX_SALES = 5;
		
		int randomSales = ThreadLocalRandom.current().nextInt(MIN_SALES, MAX_SALES + 1);
		double randomAmount;
		
		for (int i = 0; i < randomSales; i++) {
			randomAmount = 	(double) ThreadLocalRandom.current().nextInt(1000, 25000) / 100;
			emp.makeSale(randomAmount);
			System.out.println(emp.getName() + " made sale of $ " + randomAmount);
		}
	}

	/**
	 * This method loops through the employees
	 * and displays ALL information about each one.
	 */
	private static void displayEmployees() {
		System.out.println("\nHere are the employees:");
		List<Employee> listOfEmployees = new ArrayList<Employee>(employees);
		listOfEmployees.forEach(e -> {
			System.out.println("\n" + e.getClass().getSimpleName());
			System.out.println("Name: " + e.getName());
			System.out.println("ID: " + e.getEmployeeID());
			System.out.println("Hourly Wage: " + e.getHourlyWage());
			System.out.println("Productivity: " + e.calculateProductivity(e));
			if (e instanceof Cashier) {
				System.out.println("Drawer Amount: " + ((Cashier)e).getDrawerAmount());
			}
			if (e instanceof SalesAssociate) {
				System.out.println("Department: " + ((SalesAssociate)e).getDepartment());
				System.out.println("Number of sales: " + ((SalesAssociate)e).getSales());
				System.out.println("Amount of Revenue: " + ((SalesAssociate)e).getRevenue());
			}
		});
	}

}