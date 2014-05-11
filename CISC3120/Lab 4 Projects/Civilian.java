/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 4				PART 5 Civilian
 */
import java.util.Random;
public class Civilian extends Person
{
	private int money;
	
	public Civilian()
	{
		money = 30;
		Random numbers = new Random();
		setLocation(numbers.nextInt(World.SIZE + 1),numbers.nextInt(World.SIZE + 1));
	}
	
	//Accessor for money
	public int getMoney()
	{
		return money;
	}
	
	//If no money set location to (-1,-1) and if there is money decrement by 10
	public void giveMoney()
	{
		if(money == 0)
		{
			setLocation(-1,-1);
		}
		else
		{
			money -= 10;
		}
	}
	
	//Convert location and money to a String and return it
	public String toString()
	{
		String summary;
		summary = ("Location: " + getLocation().toString() + " Money Left: " + getMoney());
		return summary;
	}
	
	//This main method performs a unit test for Civilian Class
	
	public static void main(String [] args)
	{
		Civilian man = new Civilian();
		
		//Set the loaction of the man
		man.setLocation(8,4);
		
		//Print how much money man has using get money method
		System.out.println("Money the man has: " + man.getMoney());
		
		//Man was robbed and had to give his money twice
		man.giveMoney();
		man.giveMoney();
		System.out.println("Money man has after being robbed: " + man.getMoney());
		
		System.out.println("");
		
		//Man summary of location and current money using toString
		System.out.println("Man's summary");
		System.out.println(man.toString());
		
		
		System.out.println("");
		
		//Man Looses he last amount of money cause he can't pay twice again and dies
		man.giveMoney();
		man.giveMoney();
		System.out.println("Money gets robbed again by same guy");
		System.out.println("Summary of a dead man");
		System.out.println(man.toString());
	}
	
	
}