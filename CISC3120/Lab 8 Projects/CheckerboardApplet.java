/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 8				CheckerboardApplet
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CheckerboardApplet extends Applet
{
	public void init()
	{
		add(new Checkerboard(this));
	}
}

class Checkerboard extends Canvas
{
	public Checkerboard(Applet parentApplet)
	{
		setSize(500,500); //Set size to 500
	}
	
	public void paint(Graphics g)
	{
		int hBorderHeight = (int)(getHeight()* (BORDER_PCT)/2);
		int vBorderWidth = (int) (getWidth() * (BORDER_PCT/2));
		int upperLeftBoardX = vBorderWidth;
		int upperLeftBoardY = hBorderHeight;
		int boxHeight = (getHeight()- 2 * hBorderHeight)/BOARD_SIZE;
		int boxWidth = (getWidth() - 2 * vBorderWidth)/BOARD_SIZE;
		Color Brown = new Color(160,82,45); //Create the brown color for the background
		setBackground(Brown);
		
		for(int rows = 0; rows < BOARD_SIZE; rows++)
		{
			for(int cols = 0; cols < BOARD_SIZE; cols++)
			{
				g.setColor(rows % 2 ==0 ^ cols	% 2 == 0 ? Color.BLACK: Color.WHITE);
				if(g.getColor() == Color.BLACK) //Change black squares into circles
				{
					if(rows < 3) //Draw the read circles on the upper half
						g.setColor(Color.RED);
					else
						g.setColor(Color.BLACK); // Draw the black circles on the bottom half
					if(rows >2 && rows < 5) // Keep the white squares if rows and columns is within the range and drawn them
						;
					else
						g.fillOval(upperLeftBoardX + cols*boxWidth, upperLeftBoardY + rows * boxHeight, boxWidth, boxHeight);
							
				}
				else
					g.fillRect(upperLeftBoardX + cols*boxWidth, upperLeftBoardY + rows * boxHeight, boxWidth, boxHeight);
			}
		}
	}
	
	private static double BORDER_PCT =.1;
	private int hBorderHeight, vBorderWidth;
	private int boxWidth, boxHeight;
	private static final int BOARD_SIZE =8;
}