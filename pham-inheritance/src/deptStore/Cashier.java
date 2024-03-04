package deptStore;

import java.math.BigDecimal;		// To assist in adding doubles together and presenting in a precise format.
import java.math.MathContext;		// Defines what format the final result of the doubles' addition is in.

/**
 * A class to create a Cashier working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public class Cashier extends Employee {

	private double drawerAmount;		// The amount of money the cashier has in the drawer.
	private int transactions;			// The number of transactions the cashier has made.
	
	/**
	 * Creates a cashier with the user-entered parameters.
	 * 
	 * @param name			The name of the cashier.
	 * @param employeeID	The cashier's ID.
	 * @param hourlyWage	The cashier's hourly wage.
	 * @param drawerAmount	The amount of money the cashier has in the drawer.
	 */
	public Cashier(String name, int employeeID, double hourlyWage, double drawerAmount) {
		super(name, employeeID, hourlyWage);
		this.drawerAmount = drawerAmount;
		transactions = 0;						// Initialize number of transactions to 0.
	}

	/**
	 * Makes a sale (transaction) and adds a random amount of money to the drawer amount.
	 * 
	 * @param randomAmount	The amount of money made in the sale.
	 */
	public void ringup(double randomAmount) {
		transactions++;
		drawerAmount = new BigDecimal(drawerAmount + randomAmount, new MathContext(6)).doubleValue();
	}

	/**
	 * Makes a return (transaction) and subtracts a random amount of money from the drawer amount.
	 * 
	 * @param randomAmount	The amount of money returned to the customer.
	 */
	public void completeReturn(double randomAmount) {
		transactions++;
		double difference = drawerAmount - randomAmount;
		if (difference <= 0) {
			drawerAmount = 0;
			System.out.println("Cashier has no money left in the drawer");
		}
		else {
			drawerAmount = new BigDecimal(difference, new MathContext(6)).doubleValue();
		}
	}
	
	/**
	 * Returns the amount of money the cashier has in the drawer.
	 * 
	 * @return	The amount of money the cashier has in the drawer.
	 */
	public double getDrawerAmount() {
		return drawerAmount;
	}
	
	/**
	 * Returns the number of transactions the cashier has made.
	 * 
	 * @return	The number of transactions the cashier has made.
	 */
	public int getTransactions() {
		return transactions;
	}
}

