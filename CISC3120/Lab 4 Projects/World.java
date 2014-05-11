/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 4				PART 5 World
 */
import java.util.*;
import java.util.Random;
public class World
{
	private Vector<Suspect> criminals;
	private Vector<PatrolCar> cops;
	private Vector<Civilian> people;
	public static int SIZE = 9;
	public static int EAST = 0;
	public static int WEST = 1;
	public static int NORTH = 2;
	public static int SOUTH =3;
	
	//This constuctor initalizes the vectors with their repspective objects
	public World()
	{
		int numOfCriminals = 3;
		int numOfCops = 2;
		int numOfPeople = 5;
		
		criminals = new Vector<Suspect>(numOfCriminals);
		for(int i = 0; i < numOfCriminals; i++)
		{
			criminals.addElement(new Suspect());
		}
		
		cops = new Vector<PatrolCar>(numOfCops);
		for(int j = 0; j < numOfCops; j++)
		{
			cops.addElement(new PatrolCar());
		}
		
		people = new Vector<Civilian>(numOfPeople);
		for(int k = 0; k < numOfPeople; k++)
		{
			people.addElement(new Civilian());
		}
	}
	
	//Updates the values based on certain comparions
	public void update()
	{
		for(int i = 0; i < criminals.size(); i++)
		{
			for(int j = 0; j < people.size(); j++)
			{
				if(criminals.elementAt(i).getLocation().compareTo(people.elementAt(j).getLocation()) == 0)
				{
					if(people.elementAt(j).getMoney() != 0)
					{
						criminals.elementAt(i).rob();
						people.elementAt(j).giveMoney();
					}
					else
					{
						people.removeElementAt(j);		
					}
				}
			}
		}
		
		for(int i = 0; i < cops.size(); i++)
		{
			for(int j = 0; j < criminals.size(); j++)
			{
				if(cops.elementAt(i).getLocation().compareTo(criminals.elementAt(j).getLocation()) == 0)
				{
					criminals.elementAt(j).caught();
					cops.elementAt(i).addAressted(criminals.elementAt(j).getId());
				}
			}
		}
	}
	
	//Move Each Person in a random direction and update
	public void move()
	{
		Random value = new Random();
		int civilDirection;
		int susDirection;
		int copDirection;
		int numOfCells;
		int count;
		
		for(int i = 0; i < people.size(); i++)
		{
			civilDirection = value.nextInt(4);
			switch(civilDirection)
			{
				case 0:
					people.elementAt(i).moveEast();
					update();
					break;
				case 1:
					people.elementAt(i).moveWest();
					update();
					break;
				case 2:
					people.elementAt(i).moveNorth();
					update();
					break;
				case 3:
					people.elementAt(i).moveSouth();
					update();
					break;		
			}
		}
		
		for(int j = 0; j < criminals.size(); j++)
		{
			susDirection = value.nextInt(4);
			switch(susDirection)
			{
				case 0:
					criminals.elementAt(j).moveEast();
					update();
					break;
				case 1:
					criminals.elementAt(j).moveWest();
					update();
					break;
				case 2:
					criminals.elementAt(j).moveNorth();
					update();
					break;
				case 3:
					criminals.elementAt(j).moveSouth();
					update();
					break;		
			}
		}
		
		for(int k = 0; k < cops.size(); k++)
		{
			count = 0;
			numOfCells = value.nextInt(cops.elementAt(k).range)+1;
			
			while(count < numOfCells)
			{
				copDirection = value.nextInt(4);
				switch(copDirection)
				{
					case 0:
						cops.elementAt(k).moveEast();
						update();
						break;
					case 1:
						cops.elementAt(k).moveWest();
						update();
						break;
					case 2:
						cops.elementAt(k).moveNorth();
						update();
						break;
					case 3:
						cops.elementAt(k).moveSouth();
						update();
						break;		
				}
				count++;
			}
		}
	}
	
	//Print the summary information for Suspects, Patrol Cars and Civilians
	public void print()
	{
		System.out.println("Suspects Summaray");
		System.out.println("");
		for(int i = 0; i < criminals.size(); i++)
		{
			System.out.println(criminals.elementAt(i).toString());
		}
		
		System.out.println("");
		System.out.println("Civilians Summary");
		System.out.println("");
		for(int j = 0; j < people.size(); j++)
		{
			System.out.println("Civilian " + j + ": " +people.elementAt(j).toString());
		}
		
		System.out.println("");
		System.out.println("Patrol Car Summary");
		System.out.println("");
		for(int k = 0; k < cops.size(); k++)
		{
			System.out.println("Patrol Car" + cops.elementAt(k).getId() + ": ");
			System.out.println(cops.elementAt(k).toString());
			System.out.println("");
		}
	}
	
	public static void main(String [] args)
	{
		World earth = new World();
		
		while(earth.cops.elementAt(0).getNumSuspectsArrested() + earth.cops.elementAt(1).getNumSuspectsArrested() != earth.criminals.size())
		{
			earth.move();
			earth.print();
		}
		int totalArrested = earth.cops.elementAt(0).getNumSuspectsArrested() + earth.cops.elementAt(1).getNumSuspectsArrested();
		System.out.println("Total Num Supects Arrested = " + totalArrested);
	}
}
