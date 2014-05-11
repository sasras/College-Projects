/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 4				PART 4 Patrol Car
 */

public class PatrolCar extends Person
{
	private static int count =0;
	private int id;
	Point2D location = new Point2D();
	private int [] arrested;
	public static int range = 2;
	
	//This constructor creates a unique id, sets arrested array values to -1
	public PatrolCar()
	{
		count++;
		this.id = count;
		arrested = new int[3];
		for(int i = 0; i < arrested.length; i++)
		{
			arrested[i] = -1;
		}
	}
	
	//Return unique id of partrol car ojbect
	public int getId()
	{
		return id;
	}
	
	//Return number of suspects arrestd by partrol object
	public int getNumSuspectsArrested()
	{
		int numSuspArrested = 0;
		for(int i = 0; i < arrested.length; i++)
		{
			if(arrested[i] != -1)
			{
				numSuspArrested++;
			}	
		}	
		return numSuspArrested;	
	}
	
	//Put Id of suspect in respctive index location of arrested array
	public void addAressted(int Id)
	{
		arrested[Id-1] = Id;
	}

	/*Convert location and num arrested to string and return it along with
	 *all arrested Suspects' Ids*/
	public String toString()
	{
		String position;
		for(int i = 0; i < arrested.length; i++)
		{
			if(arrested[i] !=  -1)
			{
				System.out.println("Arrested Suspects Id: " + arrested[i]);	
			}
		}
		position = ("location: " + getLocation().toString() + " Arrested: " + getNumSuspectsArrested());
		return position;
	}
	//Recieves a patrol car object to be compared and returns a number
	public int compareto(PatrolCar patrolCar)
	{
		if(this.id == patrolCar.getId())
			return 0;
		else if(this.id > patrolCar.getId())
			return 1;
		else
			return -1;
	}
	
	//This main method will perform a unit test of Patrol Car
	public static void main(String[] args) 
	{	
		PatrolCar Car1 = new PatrolCar();
		PatrolCar Car2 = new PatrolCar();
		
		//Set Car1 and Car2 locations and print along with their Ids
		Car1.setLocation(8,7);
		Car2.setLocation(2,3);
		System.out.println("Car 1 Location: " + Car1.getLocation().toString() + " Id: " + Car1.getId());
		System.out.println("Car 2 Location: " + Car2.getLocation().toString() + " Id: " + Car2.getId());
		
		//Use addAressted mehtod to simulate arrest for each each car and print number of suspects arrested
		Car1.addAressted(1);
		Car1.addAressted(3);
		Car2.addAressted(2);
		
		System.out.println("");
		
		System.out.println("Car 1 arrested " + Car1.getNumSuspectsArrested() + " suspects");
		System.out.println("Car 2 arrested " + Car2.getNumSuspectsArrested() + " suspects");
		
		
		//Print summary of each Car's journey using toString method
		
		System.out.println("");
		
		System.out.println("Car 1 Summary -:");
		System.out.println(Car1.toString());
		System.out.println("");
		System.out.println("Car 2 Summary -:");
		System.out.println(Car2.toString());
		
		System.out.println("");
		
		//Use compareto to see which car was more current
		if(Car1.compareto(Car2) == 0)
		{
			System.out.println("The two cars are the same");
		}
		else if(Car1.compareto(Car2) == 1)
		{
			System.out.println("Car 1 is newer than Car 2");
		}
		else
		{
			System.out.println("Car 2 is newer than Car 1");
		}
		
		
	}
}
