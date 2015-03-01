/** SHAWN SINGH			SRING 2015
 *	CISC 3150-TR2		PROF. Rudowsky	
 *  HW#2				Tic Tac Toe
 */

/*The following class contains the methods for
 * playing a game of Tic Tac Toe.This class also contains
 * the main method necessary to run the game.*/

import java.util.Scanner;


public class TicTacToe 
{
	/*Global Variables needed for this class.*/
	private char [][] gameBoard; //The game board which is a double array.
	private char currentPlayer = 'X'; //To hold the current player.
	/*Win state of game. Needed to be global because its used in a number of methods.*/
	private boolean win = false; 
	
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
		boolean playing = true; //Playing state initially set to true.
		int usrRow; //To hold user row input.
		int usrCol; //To hold user column input.
	
		while(playing == true)
		{
			/*First get user inputs for the row and columns they want to place the X or O in.*/
			System.out.print("Enter a row (0, 1 or 2) for player " + currentPlayer
					+ ": ");
			usrRow = getInput(); //Get user row input.
			System.out.print("Enter a column (0, 1 or 2) for player " + currentPlayer
					+ ": ");
			usrCol= getInput(); //Get user column input
			
			/*Check to see user input space on board is free or if input is valid*/
			while(checkMove(usrRow, usrCol) == false)
			{
				System.out.println("Invalid Input or Space already filled, please re-enter.");
				System.out.print("Enter a row (0, 1 or 2) for player " + currentPlayer
						+ ": ");
				usrRow = getInput();
				System.out.print("Enter a column (0, 1 or 2) for player " + currentPlayer
						+ ": ");
				usrCol= getInput();
			}
			
			/*Have to check for valid integer input*/
			drawBoard();
			
			if(checkWin() == true)
			{
				System.out.println("Player " + currentPlayer + " YOU WIN!!");
				playing = false;
			}
			else if(draw() == true)
			{
				System.out.println("Sorry, its a DRAW!");
				playing = false;
			}
			
			changePlayer();
		}
	}
	
	/*This method uses the Scanner class to get the user input
	 * from the keyboard and returns it as a string.*/
	public int getInput()
	{
		Scanner input = new Scanner(System.in);
		int usrWrd = input.nextInt();
		return usrWrd;
	}
	
	/*Initialize board*/ 
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
	
	/*This method will be used to verify that the space is open.
	 * Check if the player has won.Check if there is a draw.*/
	public boolean checkMove(int row,int col)
	{
		boolean filled = false; //Space is empty
		if(gameBoard[row][col] == ' ')
		{
			gameBoard[row][col] = currentPlayer;
			filled = true; //Space is filled
		}
		return filled;
	}
	
	/*Check to see if player has won*/
	public boolean checkWin()
	{
		boolean result = false;
		/*First check all row possibilites   */
		for(int i = 0; i < gameBoard.length; i++)
		{
			if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != ' ')
			{
				win = true;
				result = win;
			}
			/*Check for columns win*/
			else if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != ' ')
			{
				win = true;
				result = win;
			}
			/*Check for diagonal win*/
			else if((gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') ||
					(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != ' '))
			{
				win = true;
				result = win;
			}
		}
		
		return result;
	}
	
	/*Check to see if there is a draw.
	 * Here will check to see if the board is full.*/
	public boolean draw()
	{
		boolean full = false;
		int count = 0;
		for(int i = 0; i < gameBoard.length; i++)
		{
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				if(gameBoard[i][j] != ' ' && win == false)
				{
					count++;
					if(count == 9)
					{
						full = true;
					}
				}
			}
		}
		return full;
	}
	
	/*Used to change player*/
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
	
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe();
	}
}
