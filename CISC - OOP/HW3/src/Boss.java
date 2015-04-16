/** SHAWN SINGH			SRING 2015
 *	CISC 3150-TR2		PROF. Rudowsky	
 *  HW#3				Inheritance 
 */

/*The Boss class extends the Employee class and contains
 * some other variables and methods that are specific to the Boss.
 * Boss will inherit some variables and methods from the employee class.*/

public class Boss extends Employee
{
	private double bonus; // Specific variable to the boss
	
	/*Default Constructor.*/
	public Boss() {	}
	
	/*Constructor with variables that need to be passed which are inherited by the Employee class
	 * along with the new variable for the Boss class.*/
	public Boss(String SSN, String lastName, int empID, double salary,double bonus)
	{
		super(SSN, lastName, empID, salary); // Pass parameters using the Employee constructor
		this.bonus = bonus;
	}
	
	/*Mutators and Accessors for Boss private variable.*/
	public void setBonus(Double b) {bonus = b;}
	public double getBonus() {return bonus;}
	
	/*Methods computerCompensation and toString are overriden to suit the Boss class.*/
	@Override
	public double computeCompensation()
	{
		return super.computeCompensation() + bonus;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " bonus: " + bonus;
	}
}

