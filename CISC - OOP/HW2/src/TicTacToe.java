/** SHAWN SINGH			SRING 2015
 *	CISC 3150-TR2		PROF. Rudowsky	
 *  HW#2				TicTacToe
 */

/*The following class contains the methods for
 * playing a game of TicTacToe.This class also contains
 * the main method necessary to run the game.*/

import java.util.Scanner;

public class TicTacToe 
{
	/*Global Variables needed for this class.*/
	private char [][] gameBoard; //The game board which is a double array.
	private char currentPlayer = 'X'; //To hold the current player.
	/*Win state of game. Needed to be global because its used in a number of methods.*/
	private boolean win = false; 
	private boolean playing = true; //Playing state initially set to true.
	int count; //Turn or number of space counts
	
	/*The constructor initializes the game runs the playGame method.*/
	public TicTacToe()
	{
		gameBoard = new char[3][3]; //Initialize to a 3 by 3 array.
		initialize(); //Initialize the game board.
		playGame(); //Play the game
	}
	
	/*Contains all the logic that is used to play the game.*/
	public void playGame()
	{
		drawBoard(); //Draw the Board.
		int usrRow; //To hold user row input.
		int usrCol; //To hold user column input.
		
		while(playing == true)
		{
			/*First get user inputs for the row and columns they want to place the X or O in.*/
			/*Get Row*/
			System.out.print("Enter a row (0, 1 or 2) for player " + currentPlayer
					+ ": ");
			usrRow = getInput(); //Get user row input.
			
			/*Check to see if user's row input is within the valid integer range.*/
			while(usrRow > gameBoard.length-1)
			{
				System.out.println("Invalid Input. Please only enter (0,1 or 2)");
				System.out.print("Enter a row (0, 1 or 2) for player " + currentPlayer
						+ ": ");
				usrRow = getInput();
			}
			
			/*Get Column*/
			System.out.print("Enter a column (0, 1 or 2) for player " + currentPlayer
					+ ": ");
			usrCol= getInput(); //Get user column input.
			
			/*Check to see if user's column input is within the valid integer range.*/
			while(usrCol > gameBoard.length-1)
			{
				System.out.println("Invalid Input. Please only enter (0,1 or 2)");
				System.out.print("Enter a column (0, 1 or 2) for player " + currentPlayer
						+ ": ");
				usrCol= getInput();
			}
			
			/*Check to see user inputs space on board is free.*/
			while(checkIfBlank(usrRow, usrCol) == false)
			{
				drawBoard(); //Draw board so user can see their mistake.
				System.out.println("Space already filled, please re-enter.");
				System.out.print("Enter a row (0, 1 or 2) for player " + currentPlayer
						+ ": ");
				usrRow = getInput();
				System.out.print("Enter a column (0, 1 or 2) for player " + currentPlayer
						+ ": ");
				usrCol= getInput();
			}
			
			drawBoard();//Draw the board.
			 
			/*Check if any of the players have won.*/
			if(checkWin() == true)
			{
				System.out.println("Player " + currentPlayer + " - YOU WIN!!");
				playAgain();
			}
			/*Check to see if the game resulted in a draw.*/
			else if(checkDraw() == true)
			{
				System.out.println("Sorry, its a DRAW!");
				playAgain();
			}
			
			changePlayer();//Used to change players
		}
	}
	
	/*This method uses the Scanner class to get the user input
	 * from the keyboard and returns it as a integer.*/
	public int getInput()
	{
		Scanner input = new Scanner(System.in);
		/*Used to make sure user input is only an integer.
		 * hasNextInt() returns false if the input is not an
		 * integer.This method is apart of the Scanner class.*/
		while(!input.hasNextInt()) 
		 {
			System.out.print("Invalid Input, Please only enter numbers: ");
			input.next();//Go to next
		 }
		int usrInt = input.nextInt();
		return usrInt; 
	}
	
	/*Initialize board with blank spaces.*/ 
	public void initialize()
	{
		for(int i = 0; i < gameBoard.length; i++)
		{
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				gameBoard[i][j] = ' ';
			}	
		}
	}
	
	/*This method will draw the board of the game.*/
	public void drawBoard()
	{
		System.out.println();
		System.out.println("-------------");
		for(int i = 0; i < gameBoard.length; i++)
		{
			System.out.print("| ");
			for(int j = 0; j < 3; j++)
			{
				System.out.print(gameBoard[i][j] + " | ");
				
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	/*This method verifies that the space is open or free.It
	 * then returns a boolean.*/
	public boolean checkIfBlank(int row,int col)
	{
		boolean blank; //Space is empty
		blank = Character.isWhitespace(gameBoard[row][col]) ? true:false;
		if(blank)
		{
			gameBoard[row][col] = currentPlayer;
		}
		return blank;
	}
	
	/*This method checks all the possibilities to see if a player has won the game
	 * and then returns a boolean.*/
	public boolean checkWin()
	{
		boolean result = false; //Holder for the global variable.
	
		for(int i = 0; i < gameBoard.length; i++)
		{
			/*First check all row wins*/
			if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != ' ')
			{
				win = true;
				result = win;
			}
			/*Check for columns wins*/
			else if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != ' ')
			{
				win = true;
				result = win;
			}
			/*Check for diagonal wins*/
			else if((gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') ||
					(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != ' '))
			{
				win = true;
				result = win;
			}
		}
		return result;
	}
	
	/*Method will check to see if there is a draw. Here
	 *  will check to see if the board is full.It returns 
	 *  a boolean.*/
	public boolean checkDraw()
	{
		boolean full = false; //Boolean to see if board is full.
		count = 0;/*Count used as a mechanism to get the whole iteration throughout the board.*/
		for(int i = 0; i < gameBoard.length; i++)
		{
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				/*Check if space is empty.*/
				if(gameBoard[i][j] != ' ' && win == false)
				{
					count++;
					/*Check if equal to 9 because thats all the spaces in the board.
					 * This is found by multiplying number of rows by columns.*/
					if(count == 9) 
					{
						full = true;
					}
				}
			}
		}
		return full;
	}
	
	/*This method is used to change the player from either X or O.*/
	public void changePlayer()
	{
		if(currentPlayer == 'X')
		{
			currentPlayer = 'O';
		}
		else
		{
			currentPlayer = 'X';
		}
	}
	
	/*This method is used to check if the player's want to keep playing.*/
	public void playAgain()
	{
		/*First display message and get input.*/
		Scanner input = new Scanner(System.in);
		String usrInp;
		System.out.print("Would you like to play again? (y/n): ");
		usrInp = input.next().toLowerCase();
		
		/*If yes then reset all the parts of the game.*/
		if(usrInp.charAt(0) == 'y')
		{
			initialize();
			count = 0;
			currentPlayer = 'x';
			drawBoard();
			playing = true;
		}
		/*If no end the game by setting playing to false*/
		else if(usrInp.charAt(0) == 'n')
		{
			System.out.println("Thanks for Playing!!!");
			playing = false;
		}	
	}
	
	/*Main method of the program which creates an instance of the 
	 * TicTacToe class which will run the game.*/
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe();
	}
}
