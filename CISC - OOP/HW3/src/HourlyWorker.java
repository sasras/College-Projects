/** SHAWN SINGH			SRING 2015
 *	CISC 3150-TR2		PROF. Rudowsky	
 *  HW#3				Inheritance 
 */

/*The HourlyWorker class extends the Employee class and contains
 * some other variables and methods that are specific to the HourlyWorker.
 * HourlyWorker will inherit some variables and methods from the employee class.*/
public class HourlyWorker extends Employee
{
	/*Private variables specific to this class.*/
	private double hourlyWage;
	private double numHours;
	
	/*Default Constructor*/
	public HourlyWorker() { }
	
	/*Constructor with variables that need to be passed which are inherited by the Employee class
	 * along with the new variables for the HourlyWorker class.*/
	public HourlyWorker(String SSN, String lastName, int empID, double hourlyWage, double numHours)
	{
		super(SSN, lastName, empID);
		this.hourlyWage = hourlyWage;
		this.numHours = numHours;
	}
	
	/*Mutators and Accessors for the variables of this class.*/
	public void setHourlyWage(double hW) {hourlyWage = hW;}
	public double getHourlyWage() {return hourlyWage;}
	
	public void setNumHours(double nH) {numHours = nH;}
	public double getNumHours() {return numHours;}
	
	/*Methods computerCompensation and toString are override to suit the CommissionWorker class.*/
	@Override
	public double computeCompensation()
	{
		return hourlyWage*numHours;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " hourly wage: " + hourlyWage +
				" number of hours: " + numHours;
	}
}
