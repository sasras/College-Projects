/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 1.2 			PART 1 MODIFICATION OF RANDOM NUMBER
 */

public class Coin
{
	public static final int HEADS = 0;
	public static final int TAILS = 1;
	private int face;
	private int value;

	public Coin()
	{
		flip();
	}
	
	public Coin(int value)
	{
		this.value = value;
		flip();
	}
	
	public void flip()
	{
		face = (int) (Math.random()*2);
	}

	public int getFace()
	{
		return face;
	}

	public int getValue()
	{
		return value;
	}

	public String toString()
	{
		String facename;
		if(face == HEADS)
		{
			facename = "heads";	
		}
		else
		{
			facename = "tails";
		}
		return (Integer.toString(value) + " cent coin, face: " + facename);
	}
	
}
