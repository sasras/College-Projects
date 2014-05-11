/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 2 Part 1		CoinFlip Game
 */
import java.util.Scanner;
import java.io.*;

public class CoinFlip
{
	public static void main(String [] args)
	{
		int userInput = 0;
		Scanner keyboard =  new Scanner(System.in);
		
		//Try and catch is used to catch error of entering a letter.
		try
		{
			userInput = Integer.parseInt(keyboard.next());
			
			while(userInput != Coin.HEADS && userInput != Coin.TAILS) //Used to catch invalid number input
			{
				System.out.println("Not a Valid Number please re-enter");
				printUsage();
				userInput = Integer.parseInt(keyboard.next());	
				
			}
							
		}
		catch(NumberFormatException e)
		{
			System.out.println("Not a number, Goodbye!");
			printUsage();
			System.exit(0);
		}
		
		Coin userCoin = new Coin(userInput); //Instantiate Coin Object
		userCoin.flip(); //Flip Coin
		
		if(userCoin.getFace() == userInput) // Compare user input with flipped coin to see if there was a match.
		{
			System.out.println("YOU WIN!");	
		}	
		else
		{
			System.out.println("YOU LOSE!");	
		}	
	}
	
	// This method prints the rules of the game when called
	public static void printUsage()
	{
		System.out.println("Please enter a 0 for heads or a 1 for tails.");
		System.out.println("Do Not enter a letter.");
		System.out.println("Upon enterimg a number a Coin will be flipped");
		System.out.println("to see if YOU WIN! or YOU LOSE!.");
	}
}
