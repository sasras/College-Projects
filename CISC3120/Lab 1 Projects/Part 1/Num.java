/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 1.2 			PART 1 MODIFICATION OF RANDOM NUMBER
 */

import java.util.Scanner;

public class Num
{
	public static void main(String [] args)
	{
		int size;// To hold the size of the array
		
		Scanner keyboard = new Scanner(System.in); // Used Scanner Class to recieve user input.
		System.out.print("Enter size of array: ");
		size = keyboard.nextInt(); // Read the next integer user enters
		
		int [] numarray = new int[size] ; // Create array of integers with size entered by user.
		System.out.println(""); // Used for neatness for output
		
		for(int i = 0;i < numarray.length; i++)
		{
			System.out.print("Enter Num for " + "A[" +i +"]" + ": ");
			numarray[i] = keyboard.nextInt(); // Put numbers entered by user into the array.
		}
		
		System.out.println("");

		for (int j = 0; j < numarray.length; j++)
		{
			System.out.println("A["+j+"]="+numarray[j]); // Print the array.
		}
		
		System.out.println("\nSmallest Number at Index: " + getMinIndex(numarray)); // Print the max number of array.
		System.out.println("Biggest Number at Index: " + getMaxIndex(numarray));// Print the min number of array.

	}
	
	/**This method finds the min value of the passed array 
	 *of integers and then returns its index */
	public static int getMinIndex(int [] array)
	{
		int minIndex = 0;
		int minVal = array[0];
		int i;
		for(i = 1; i < array.length; i++)
		{
			if(array[i] < minVal)
			{
				minVal = array [i];
				minIndex = i;
			}		
		}
		return minIndex;
	}
	
	/**This method finds the max value of the passed array 
	 *of integers and then returns its index */
	public static int getMaxIndex(int [] array)
	{
		int maxIndex = 0;
		int maxVal = array[0];
		int i;
		
		for(i = 1; i < array.length; i++)
		{
			if(array[i] > maxVal)
			{
				maxVal = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
