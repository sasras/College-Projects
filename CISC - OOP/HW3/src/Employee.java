/** SHAWN SINGH			SRING 2015
 *	CISC 3150-TR2		PROF. Rudowsky	
 *  HW#3				Inheritance 
 */

public class Employee 
{
	private String SSN;
	private String lastName;
	private int empID;
	private double salary;
	
	public Employee() { }
	
	Employee(String SSN, String lastName, int empID, double salary)
	{
		this.SSN = SSN;
		this.lastName = lastName;
		this.empID = empID;
		this.salary = salary;
	}
	
	Employee(String SSN, String lastName, int empID)
	{
		this.SSN = SSN;
		this.lastName = lastName;
		this.empID = empID;
	}
	
	
	public void setSSN (String s) {SSN = s;}
	public String getSSN() {return SSN;}
	
	public void setLastName (String s){ lastName = s; }
    public String getLastNametSSN(){return lastName;}
    
    public void setEmpId (int eid){ empID = eid; }
    public int getEmpID(){return empID;}
    
    public void setSalary (double sal){ salary = sal; }
    public double getSalary(){return salary;}
    
    public double computeCompensation()
    {
    	return salary/52.0;
    }
    
    @Override
    public String toString()
    {
    	return "Employee name: " + lastName+ " ID: "+empID+" SSN: "+ SSN+
    		       " salary: "+ salary+ " compensation: " +  
    			String.format("%10.2f",computeCompensation());//this is to avoid extended decimals

    }

}
