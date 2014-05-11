/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 3				PART 2 Patrol Car
 */

public class PatrolCar
{
	static int count =0;
	private int id;
	Point2D location = new Point2D();
	private int arrested = 0;
	
	/*This constructor creates a unique id, sets arrested value and 
	 *location to 0*/
	public PatrolCar()
	{
		count++;
		this.id = count;
		arrested = 0;
		location.setX(0);
		location.setY(0);
	}

	//Move patrol car west
	public boolean moveWest()
	{
		if(location.getX() == 0)
		{
			return false;
		}
		else
		{
			location.setX(location.getX()-1);
			return true;
		}
	}

	//Move patrol car east
	public boolean moveEast()
	{
		if(location.getX() == World.SIZE)
		{
			return false;
		}
		else 
		{
			location.setX(location.getX() + 1);
			return true;
		}	
	}
	
	//Move patrol car north
	public boolean moveNorth()
	{
		if(location.getY() == 0)
		{
			return false;
		}
		else
		{
			location.setY(location.getY() - 1);
			return true;
		}	
	}
	
	//Move patrol car south
	public boolean moveSouth()
	{
		if(location.getY() == World.SIZE)
		{
			return false;
		}
		else
		{
			location.setY(location.getY() + 1);
			return true;
		}	
	}

	//Return unique id of partrol car ojbect
	public int getId()
	{
		return id;
	}

	//Retrun location of partrol car object
	public Point2D getLocation()
	{
		return location; 
	}

	//Return number of suspects arrestd by partrol object
	public int getNumSuspectsArrested()
	{
		return arrested;
	}
	
	//Add 1 to arrested value
	public void addAressted()
	{
		arrested++;
	}

	//Convert location and num arrested to string and return it
	public String toString()
	{
		String position;
		position = ("location: " + location.toString() + " arrested: " + getNumSuspectsArrested());
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
		PatrolCar car1 = new PatrolCar();
		PatrolCar car2 = new PatrolCar();
		
		//Set car1 and car2 locations and print using getlocation and print id
		car1.location.setX(7);
		car1.location.setY(5);
		System.out.println("Car 1 Location: " + car1.getLocation().toString() + " Id: " + car1.getId());
		car2.location.setX(2);
		car2.location.setY(12);
		System.out.println("Car 2 Location: " + car2.getLocation().toString() + " Id: " + car2.getId());
		
		
		
		// Move each car in every direction and print new location each step and id.
		//Also addarrested value after each complete movement of all 4 directions
		
		System.out.println("");
		System.out.println("Move East");
		car1.moveEast();
		System.out.println("Car 1 Location: " + car1.getLocation().toString() + " Id: " + car1.getId());
		System.out.println("Move West");
		car1.moveWest();
		System.out.println("Car 1 Location: " + car1.getLocation().toString() + " Id: " + car1.getId());
		System.out.println("Move North");
		car1.moveNorth();
		System.out.println("Car 1 Location: " + car1.getLocation().toString() + " Id: " + car1.getId());
		System.out.println("Move South");
		car1.moveSouth();
		System.out.println("Car 1 Location: " + car1.getLocation().toString() + " Id: " + car1.getId());
		car1.addAressted();
		
		System.out.println("");
		System.out.println("Move East");
		car2.moveEast();
		System.out.println("Car 2 Location: " + car2.getLocation().toString() + " Id: " + car2.getId());
		System.out.println("Move West");
		car2.moveWest();
		System.out.println("Car 2 Location: " + car2.getLocation().toString() + " Id: " + car2.getId());
		System.out.println("Move North");
		car2.moveNorth();
		System.out.println("Car 2 Location: " + car2.getLocation().toString() + " Id: " + car2.getId());
		System.out.println("Move South");
		car2.moveSouth();
		System.out.println("Car 2 Location: " + car2.getLocation().toString() + " Id: " + car2.getId());
		car2.addAressted();
		
		/*Add arrested value 2 times to car 1 and 1 times to car 2 to simulate arresting and print 
		numsuspects arrested*/
		
		car1.addAressted();
		car1.addAressted();
		System.out.println("");
		System.out.println("Car " + car1.getId() + " num of arrest: " + car1.getNumSuspectsArrested());
		car2.addAressted();
		System.out.println("Car " + car2.getId() + " num of arrest: " + car2.getNumSuspectsArrested());
		
		//Print summary of each of the cars' journey using toString
		System.out.println("");
		System.out.println("Car 1 " + car1.toString());
		System.out.println("Car 2 " + car2.toString());
		
		//Use compare to to see if car is the same, newer than the current car or old than the current car
		
		System.out.println("");
		if(car1.compareto(car2) == 0)
		{
			System.out.println("Car 2 is the same Car 1");
		}
		else if(car1.compareto(car2) == 1)
		{
			System.out.println("Car 2 is older than Car 1");
		}
		else
		{
			System.out.println("Car 2 is newer than Car 1");
		}
		
	}

	
}
