/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 2 Part 2		CoinUnitTest
 */
 
public class CoinUnitTest
{
	public static void main(String [] args)
	{
		//Instantiate one each objects
		Coin heads = new Coin(0);
		Coin tails = new Coin(1);
		
		//Print each objects face and value using to String
		System.out.println(heads.toString());
		System.out.println(tails.toString());
		
		//Flip each object
		heads.flip();
		tails.flip();
		
		// Test getValue and getFace methods by printing them out.
		System.out.println("value:" + heads.getValue() + ", face:" +heads.getFace());
		System.out.println("value:" + tails.getValue() + ", face:" +tails.getFace());
		
	}
}