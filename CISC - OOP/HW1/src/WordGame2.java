import java.util.Random;
import java.util.Scanner;

public class WordGame2 
{
	public static void main(String[] args) 
	{
		Random rGen = new Random();
		String [] word = {"that","food","hello","program"};
		char [] tracker = new char[25]; //26 letters in the alphabet.
		int tCount = 0;
		int wCount =0;
		int count = 0;
		boolean playing = true;
		String answer = word[rGen.nextInt(word.length)];
		char [] blanks = new char[answer.length()];
		String usrWord; //To Hold user word
		Scanner input = new Scanner(System.in);
		
		System.out.println(answer); //For Testing purposes
		
		//Initialize blanks
		for(int i =0; i < answer.length(); i++)
		{
			blanks[i] = '*';
		}
		
		for(int i=0; i<tracker.length; i++)
		{
			tracker[i] =' ';
		}
		

		while(playing == true)
		{
			System.out.print("Enter a letter in the word: ");
			System.out.print(blanks);
			System.out.print(" >");
			usrWord = input.next();
			if(usrWord.equals("%"))
			{
				playing = false;
			}
			tCount++;
			tracker[tCount] = usrWord.charAt(0);

			
			/*This for loop checks the occurences of each char and places in the appropriate index
			 * for the blanks array*/
			
			if(answer.indexOf(usrWord.charAt(0)) >= 0)
			{
				for(int i =0; i<answer.length(); i++)
				{
					if(usrWord.charAt(0) == blanks[i])
					{
						System.out.println(usrWord+" is already in the word");
					}
					else if(answer.charAt(i) == usrWord.charAt(0))
					{
						blanks[i] = usrWord.charAt(0);
					}
				}
			}
			else
			{
				if(usrWord.charAt(0) != '%')
				{
					System.out.println(usrWord + " is not in this word");
				}
			}
			
		/**	for(int i =0; i<answer.length(); i++)
			{
				if(answer.charAt(i) == usrWord.charAt(0))
				{
					if(usrWord.charAt(0) == blanks[i])
					{
						count++; // to help with duplicate printing
						if(count == 1)
						{
							System.out.println(usrWord+" is already in the word");
						}
					}
					blanks[i] = usrWord.charAt(0);	
				}
				
			}**/

			
			for(int i =0; i < tCount; i++)
			{
				/*if(tracker[i] == tracker[i+1])
				{
					tracker[i+1] = ' ';
				}*/
				if(tracker[i] == usrWord.charAt(0))
				{
						System.out.println(usrWord+" has already been guessed");
					
				}
			}
			
			String bString = new String(blanks);
			if(answer.equals(bString))
			{
				
				System.out.println("You Win the word was " + answer + " tcount " +tCount);
				System.out.print("Would you like to play again?(y/n) > ");
				usrWord = input.next();
				if(usrWord.equals("y"))
				{
					count = 0;
					tCount =0;
					answer = word[rGen.nextInt(word.length)];
					blanks = new char[answer.length()];
					for(int i =0; i < answer.length(); i++)
					{
						blanks[i] = '*';
					}
					for(int i=0; i<tracker.length; i++)
					{
						tracker[i] =' ';
					}
					playing = true;
				}
				else if(usrWord.equals("n"))
				{
					System.out.println("Thanks for Playing!");
					playing =false;
				}
			}
		}
		
	}
	

}
