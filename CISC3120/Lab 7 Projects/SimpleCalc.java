/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 7				SimpleCalc
 */
 
import javax.swing.*;

public class SimpleCalc
{
	public static void main(String [] args)
	{
		JFrame frame = new JFrame("My Simple Calculator");
		frame.getContentPane().add(new CalcComponent());
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}