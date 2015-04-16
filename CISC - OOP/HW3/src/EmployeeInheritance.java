/** SHAWN SINGH			SRING 2015
 *	CISC 3150-TR2		PROF. Rudowsky	
 *  HW#3				Inheritance 
 */
/*This class is the driver program to test the Emmployee inheritance 
 * concept being used by all the classes.*/

import java.util.ArrayList;

public class EmployeeInheritance 
{
	public static void main(String[] args) 
	{
	     ArrayList<Employee> empList = new ArrayList<>(); //create an Array list of Employee objects.
	     /*Add objects with appropriate parameter input fields.*/
	      empList.add(new Employee("123-44-7890","Smith",6543,45500));
	      empList.add(new Boss("349-08-4912","Chavez",7833,52175,2200));
	      empList.add(new HourlyWorker("556-34-0998","Kennedy",5422, 23.5, 52.5));
	      empList.add(new CommissionWorker("909-23-0154","Murphy",3636, 23000,150, .125));
	     
	      /*Print array list.*/
	      for (int i=0;i<empList.size();i++)
	          System.out.println((empList.get(i)).toString());
	   }

}
