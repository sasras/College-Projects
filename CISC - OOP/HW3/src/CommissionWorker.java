/** SHAWN SINGH			SRING 2015
 *	CISC 3150-TR2		PROF. Rudowsky	
 *  HW#3				Inheritance 
 */

/*The CommissionWorker class extends the Employee class and contains
 * some other variables and methods that are specific to the CommissionWorker.
 * CommissionWorker will inherit some variables and methods from the employee class.*/
public class CommissionWorker extends Employee
{
	/*Private varibles specific to this class.*/
	private double commissionRate; 
	private double quantitySold;
	
	/*Default constructor.*/
	public CommissionWorker() {	}
	
	/*Constructor with variables that need to be passed which are inherited by the Employee class
	 * along with the new variables for the CommissionWorker class.*/
	public CommissionWorker(String SSN, String lastName, int empID, double salary, double commissionRate, double quantitySold)
	{
		super(SSN, lastName, empID, salary);
		this.commissionRate = commissionRate;
		this.quantitySold = quantitySold;
	}
	
	/*Mutators and Accessors for the variables of this class.*/
	public void setComissionRate(double cR) {commissionRate = cR;}
	public double getCommissionRate() {return commissionRate;}
	
	public void setQuantitySold(double qS) {quantitySold = qS;}
	public double getQuantitySold() {return quantitySold;}
	
	/*Methods computerCompensation and toString are override to suit the CommissionWorker class.*/
	@Override
	public double computeCompensation()
	{
		return super.computeCompensation() + (commissionRate*quantitySold);
	}
	
	public String toString()
	{
		return super.toString() + " commission rate: " + commissionRate +
				" quantity sold: " + quantitySold;
	}
}
