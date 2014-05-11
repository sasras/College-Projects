/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 1.2 			PART 2 Command Line Calculator
 */
import java.util.Scanner;
import java.io.Console;
public class Calc
{
	public static void main(String [] args)
	{
		
		if(args.length <= 3 && args.length > 0) // Used to restrict number of arguments to three
		{
			String operation;
			operation = args[0];
			int number1 = 0;
			int number2 = 0;
			int answer = 0;
		// Try and Catch used to make sure next 2 arguments are numbers
			try
			{
				number1 = Integer.parseInt(args[1]); // Parse string into an integer
			}
			catch(NumberFormatException e)
			{
				System.out.println("Please re-run and enter a valid first number");
				System.exit(0);
			}
			try
			{
				number2 = Integer.parseInt(args[2]); // Parse string into an integer
			}
			catch(NumberFormatException ex)
			{
				System.out.println("Please re-run and enter a valid second number");
				System.exit(0);
			}
		
		// Set of statements used to determine which operation was typed
			if(operation.charAt(0) == '+')
			{
				answer = number1 + number2;
			}
			else if(operation.charAt(0) == '-')
			{
				answer = number1 - number2;
			}
			else if(operation.charAt(0) == 'x')
			{
				answer = number1 * number2;
			}
			else if(operation.charAt(0) == '/')
			{
				answer = number1 / number2;
			}
			else if(operation.charAt(0) == '%')
			{
				answer = number1 % number2;
			}
			else // This excecutes if an invalid input of opertaions has been entered
			{
				System.out.println("Please re-run and enter a valid operation");
				System.exit(0);
			}
		
			System.out.println(answer);
		}
		else // Execute if arguments are greater than 3.
		{
			System.out.println("Please only enter three arguments");
			System.exit(0);
		}
		
	}	
}

