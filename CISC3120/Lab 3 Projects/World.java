/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 3				PART 3 World
 */
import java.util.Random;
public class World
{
	int numofSuspects = 25;
	Point2D [] suspects = new Point2D[numofSuspects];
	PatrolCar police = new PatrolCar();
	public static int SIZE = 9;

	/*This constructor sets the location of the suspects and patrol
	 *car to a random number*/
	public World()
	{
		Random numbers = new Random();
		for(int i = 0; i < numofSuspects; i++)
		{
			suspects[i] = new Point2D();
			suspects[i].setX(numbers.nextInt(10));
			suspects[i].setY(numbers.nextInt(10));
		}
		police.location.setX(numbers.nextInt(10));
		police.location.setY(numbers.nextInt(10));
	}
	
	/*Check to see if patrolcar location and suspects location are
	 *the same and then add arrested value*/
	public void update()
	{
		for(int i = 0; i < numofSuspects; i++)
		{
			if(police.getLocation().compareTo(suspects[i]) == 0)
			{
				suspects[i].setX(-1);
				suspects[i].setY(-1);
				police.addAressted();
			}
		}
	}
	
	/*Move partrol car in a random direction for a random number 
	 *of times*/
	public void move()
	{
		Random value = new Random();
		int direction;
		int numofcells = value.nextInt(9)+1;
		int count = 0;
		
		while(count < numofcells)
		{
			direction = value.nextInt(4);
			switch(direction)
			{
				case 0:
					police.moveEast();
					update();
					break;
				case 1:
					police.moveWest();
					update();
					break;
				case 2:
					police.moveNorth();
					update();
					break;
				case 3:
					police.moveSouth();
					update();
					break;
			}
			count++;
		}
	}
	
	/*Keep moving until all suspects are arressted while printing out 
	 *the results*/
	public static void main (String[] args) 
	{
		World world = new World();
		int num = 0;
		
		while(world.police.getNumSuspectsArrested() != world.numofSuspects)
		{
			world.move();
			System.out.println("");
			System.out.println("Location of PartrolCar: " + world.police.getLocation().toString());
			System.out.println("Num of Suspects Arrested: " + world.police.getNumSuspectsArrested());
			
		}
		
	}
	
}
