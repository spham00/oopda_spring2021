package deptStore;

/**
 * A class to create an Employee working at a store
 * 
 * @author OOPDA Instructor
 *
 */
public abstract class Employee {
	
	protected String name;			// The name of the employee.
	protected int employeeID;		// The employee's ID.
	protected double hourlyWage;	// The employee's hourly wage.
	protected double productivity;	// The employee's productivity rating.
	
	/**
	 * Takes parameters of an employee.
	 * 
	 * @param name			The name of the employee.
	 * @param employeeID	The employee's ID.
	 * @param hourlyWage	The employee's hourly wage.
	 */
	public Employee(String name, int employeeID, double hourlyWage) {
		this.name = name;
		this.employeeID = employeeID;
		this.hourlyWage = hourlyWage;
		productivity = 0;				// Initially set productivity to 0.
	}
	
	/**
	 * Calculates the productivity of an employee depending on their type.
	 * 
	 * @param e		The employee whose productivity is going to be calculated.
	 * @return		The productivity of the employee depending on their type.
	 */
	public double calculateProductivity(Employee e) {
		if (e instanceof Cashier) {
			productivity = ((Cashier)e).getTransactions()/20.0;
		}
		else if (e instanceof SalesAssociate) {
			productivity = ((((SalesAssociate)e).getSales()/3.0) + (((SalesAssociate)e).getRevenue()/1000.0))/2.0;
		}
		return productivity;
	}

	/**
	 * Returns the name of the employee.
	 * 
	 * @return	The name of the employee.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the employee's ID.
	 * 
	 * @return	The employee's ID.
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * Returns the employee's hourly wage.
	 * 
	 * @return	The employee's hourly wage.
	 */
	public double getHourlyWage() {
		return hourlyWage;
	}
	
	/**
	 * Returns the employee's productivity rating.
	 * 
	 * @return	The employee's productivity rating.
	 */
	public double getProductivity() {
		return productivity;
	}

}