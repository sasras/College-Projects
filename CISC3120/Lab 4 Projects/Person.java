/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 4			PART 2 Person
 */

public class Person
{
	private Point2D location = new Point2D();
	
	//This constructor sets Person's location to (0,0)
	public Person()
	{
		location.setX(0);
		location.setY(0);	
	}

	//This constructor sets the x and y values for Person's location
	public Person(int x, int y)
	{
		location.setX(x);
		location.setY(y);
	}
	
	//Move Person west
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

	//Move Person east
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
	
	//Move Person north
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
	
	//Move Person south
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

	//Accepts an int and then moves, person in the respective direction defined in World class
	public boolean move(int direction)
	{
		if(direction == World.EAST)
		{
			return moveEast();
		}
		else if(direction == World.WEST)
		{
			return moveWest();
		}
		else if(direction == World.NORTH)
		{
			return moveNorth();
		}
		else if(direction == World.SOUTH)
		{
			return moveSouth();
		}
		else
		{
			System.out.println("Not a valid input");
			return false;
		}
	}

	//Return location object of person
	public Point2D getLocation()
	{
		return location;	
	}

	//Set Person location's x and y values
	public void setLocation(int a, int b)
	{
		location.setX(a);
		location.setY(b);
	}
	
	// Converts Person location to String and returns it
	public String toString()
	{
		return location.toString();
	}
	
	//Compares a passed Person object's location and returns an int
	public int compareTo(Person persons)
	{
		return this.location.compareTo(persons.location);
		
	}
	
	//This main mehtod performs a unit test for the Person class
	public static void main(String [] args)
	{
		Person Person1 = new Person(7,4);
		Person Person2 = new Person(6,1);
		
		//Print x and y values that the Objects' passed to constructor, using get methods and toString method
		System.out.println("Person 1 x and y values: x = " + Person1.getLocation().getX() + " y = " + Person1.getLocation().getY());
		System.out.println("Person 1 x and y values as a co-ordinate: " + Person1.toString());
		System.out.println("Person 2 x and y values: x = " + Person2.getLocation().getX() + " y = " + Person2.getLocation().getY());
		System.out.println("Person 2 x and y values as a co-ordinate: " + Person2.toString());
		
		System.out.println("");
		
		/* Move Person1 and Person 2 in everydirection to test the direction methods using the move method, using
		 *0 through 3 to represent east,west,north and south respectively*/
		System.out.println("Move East");
		Person1.move(0);
		System.out.println("Person 1 Location: " + Person1.toString());
		System.out.println("Move West");
		Person1.move(1);
		System.out.println("Person 1 Location: " + Person1.toString());
		System.out.println("Move North");
		Person1.move(2);
		System.out.println("Person 1 Location: " + Person1.toString());
		System.out.println("Move South");
		Person1.move(3);
		System.out.println("Person 1 Location: " + Person1.toString());
		
		System.out.println("");
		
		System.out.println("Move East");
		Person2.move(0);
		System.out.println("Person 2 Location: " + Person2.toString());
		System.out.println("Move West");
		Person2.move(1);
		System.out.println("Person 2 Location: " + Person2.toString());
		System.out.println("Move North");
		Person2.move(2);
		System.out.println("Person 2 Location: " + Person2.toString());
		System.out.println("Move South");
		Person2.move(3);
		System.out.println("Person 2 Location: " + Person2.toString());
		
		System.out.println("");
		
		//Use compare to and set methods to test the compareto method and print
		System.out.println("Person 1 current location: " + Person1.toString());
		System.out.println("Person 2 current location: " + Person2.toString());
		if(Person1.compareTo(Person2) == 0)
		{
			System.out.println("The two people are at the same location");
		}
		else
		{
			System.out.println("The two people are at different locations");
		}
		
		System.out.println("");
		
		Person1.setLocation(8,2);
		Person2.setLocation(8,2);
		System.out.println("Person 1 current location: " + Person1.toString());
		System.out.println("Person 2 current location: " + Person2.toString());
		if(Person1.compareTo(Person2) == 0)
		{
			System.out.println("The two people are at the same location");
		}
		else
		{
			System.out.println("The two people are at different locations");
		}	
	}
}
