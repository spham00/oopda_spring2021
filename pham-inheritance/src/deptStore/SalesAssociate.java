package deptStore;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * A class to create a SalesAssociate working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public class SalesAssociate extends Employee {

	private String department;		// The department the sales associate belongs to.
	private int sales;				// The number of sales the sales associate made.
	private double revenue;			// The revenue the sales associate made from sales.
	
	/**
	 * Creates a sales associate with the user-entered parameters.
	 * 
	 * @param name			The name of the sales associate.
	 * @param employeeID	The sales associate's ID.
	 * @param hourlyWage	The sales associate's hourly wage.
	 * @param department	The sales associate's department.
	 */
	public SalesAssociate(String name, int employeeID, double hourlyWage, String department) {
		super(name, employeeID, hourlyWage);
		this.department = department;
		sales = 0;							// Initialize number of sales to 0.
		revenue = 0;						// Initialize revenue to 0.
	}

	/**
	 * Makes a sale and adds a random amount of money to the revenue.
	 * 
	 * @param randomAmount	The amount of money added to the revenue.
	 */
	public void makeSale(double randomAmount) {	
		sales++;
		revenue = new BigDecimal(revenue + randomAmount, new MathContext(6)).doubleValue();
	}
	
	/**
	 * Returns the sales associate's department.
	 * 
	 * @return	The sale associate's department.
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Returns the number of sales the sales associate made.
	 * 
	 * @return	The number of sales the sales associate made.
	 */
	public int getSales() {
		return sales;
	}
	
	/**
	 * Returns the revenue the sales associate made from sales.
	 * 
	 * @return	The revenue the sales associate made from sales.
	 */
	public double getRevenue() {
		return revenue;
	}
}
