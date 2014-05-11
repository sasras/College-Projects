/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 4			PART 3 Suspect
 */
import java.util.Random;
public class Suspect extends Person
{
	static int count;
	private int id;
	private boolean arrested;
	private int money;
	Random numbers = new Random();

	/*This constructor sets the x and y values for Suspect's location randomly, creates a
	 *a unique id for suspect objects, sets arrested value to false and money to 0*/
	public Suspect()
	{
		super.setLocation(numbers.nextInt(World.SIZE +1),numbers.nextInt(World.SIZE + 1));
		count++;
		id = count;
		arrested = false;
		money = 0;	
	}
	
	//Return suspects unique id
	public int getId()
	{
		return id;
	}

	//Returns a boolen value of arrested
	public boolean isArrested()
	{
		return arrested;
	}

	//Sets arrested to true and sets suspect location to (-1,-1)
	public void caught()
	{
		arrested = true;
		super.getLocation().setX(-1);
		super.getLocation().setY(-1);
	}
	
	//Adds 10 to money everytime its called
	public void rob()
	{
		money += 10;
	}
	
	//Returns suspect location as a string, along with money and arrested value.
	public String toString()
	{
		String output;
		output = ("Suspect Id: " + getId() + ", Location: " + super.toString() + ", Money: " + money + " Arrested: " + isArrested());
		return output;
	}
	
	// Compares the passed suspect object id with the current suspect and returns a value
	public int compareto(Suspect suspect)
	{
		if(this.getId() == suspect.getId())
		{
			return 0;
		}
		else if(this.getId() > suspect.getId())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	//This main method peforms a unit test for Suspect Class
	public static void main(String [] args)
	{
		Suspect suspect1 = new Suspect();
		Suspect suspect2 = new Suspect();
		
		//Print suspect1 and suspect2 locations, Ids, Money Held and Aresseted values using toString
		System.out.println("Suspect " + suspect1.getId() + " Info");
		System.out.println(suspect1.toString());
		
		System.out.println("");
		
		System.out.println("Suspect " + suspect2.getId() + " Info");
		System.out.println(suspect2.toString());
		
		//Simulating Robing and getting caught using the mehtods for each suspect and print out new info
		
		suspect1.rob();
		suspect1.rob();
		suspect1.rob();
		suspect2.rob();
		suspect1.caught();
		
		System.out.println("");
		
		System.out.println("Suspect " + suspect1.getId() + " Updated Info");
		System.out.println(suspect1.toString());
		
		System.out.println("");
		
		System.out.println("Suspect " + suspect2.getId() + " Updated Info");
		System.out.println(suspect2.toString());
		
		//Use isArrested method to see whether each suspect was arrested or not
		
		System.out.println("");
		
		if(suspect1.isArrested() == true)
		{
			System.out.println("Suspect " + suspect1.getId() + " was arrested");
		}
		else
		{
			System.out.println("Suspect " + suspect1.getId() + " was not arrested");
		}
		
		if(suspect2.isArrested() == true)
		{
			System.out.println("Suspect " + suspect2.getId() + " was arrested");
		}
		else
		{
			System.out.println("Suspect " + suspect2.getId() + " was not arrested");
		}
		
	}
}
