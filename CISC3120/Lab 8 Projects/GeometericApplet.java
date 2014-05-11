/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 8				GeometericApplet
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class GeometericApplet extends Applet 
{
	public void init() 
	{
		add(new Geometericboard(this));
	}
}

class Geometericboard extends Canvas 
{
    public Geometericboard(Applet parentApplet) 
    {
        setSize(600, 600);
    }

    public void paint(Graphics g) 
    {
        for (int i = 0; i < circlesInRow.length; i++)
            drawRow(g, i);
    }
    
    /**drawRow draws the number of circles needed in a row as determined
     *in the circlesInRow array. It also places a rectangle around the circles
     *based on the same number.**/

    void drawRow(Graphics g, int row) 
    {
        int centerX = getWidth() / 2;          
        int startY = 0;
        int numCirlces = circlesInRow[row];
        int rowWidth = numCirlces * circleDiam + (numCirlces-1) * circleGap;    
        int startX = centerX - rowWidth / 2;  //Determine where the drawing should start         
        int y = startY + row * (circleDiam + circleGap); 
        for (int i = 0; i < numCirlces; i++) 
        {  
        	g.setColor(Color.BLUE);
            g.drawRect(startX + i * (circleDiam + circleGap), y, circleDiam, circleDiam); //Draw Blue sqaures using mesurements of the circle
            g.setColor(Color.RED);
            g.drawOval(startX + i * (circleDiam + circleGap), y, circleDiam, circleDiam); //Drawn Red circles
        }
    }

    final int circleDiam = 20;
    final int circleGap = (int)(circleDiam * 0.50);


    int [] circlesInRow = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
}