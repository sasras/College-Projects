/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 7				CalcComponent
 */
import java.awt.*; 
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*; 
import java.util.Random; 
import java.lang.Number.*;

public class CalcComponent extends JComponent implements ActionListener
{
	double a = 0;
	double b;
	double result = 0;
	double temp [] = {0,0}; //To hold the two numbers for the operation
	String operation;
	JButton buttons[];
	
	JTextField aField;

	Random randomGenerator = new Random();
	
	public CalcComponent()
	{
		b = randomGenerator.nextDouble() *10.0;
		setLayout(new GridLayout(0,2));
		
		buttons = new JButton[9];
		buttons[0] = new JButton("+");
		buttons[1] = new JButton("-");
		buttons[2] = new JButton("*");
		buttons[3] = new JButton("/");
		buttons[4] = new JButton("sqrt");
		buttons[5] = new JButton("sin");
		buttons[6] = new JButton("max");
		buttons[7] = new JButton("min");
		buttons[8] = new JButton("=");
		
		for(int i = 0; i<9; i++)
		{
			add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		
		aField = new JTextField();
		aField.setColumns(3);
		add(aField);
	}

/*This method checks to see which button was pressed
 *and then it stores the first number entered and sets
 *the operation varible to the respective operation and
 *then it clears the textfield*/
public void actionPerformed(ActionEvent e)
{
	if(e.getSource() == buttons[0])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "+";
		aField.setText("");
		
	}
	
	if(e.getSource() == buttons[1])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "-";
		aField.setText("");
	}
	
	if(e.getSource() == buttons[2])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "*";
		aField.setText("");
	}
	if(e.getSource() == buttons[3])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "/";
		aField.setText("");
	}
	if(e.getSource() == buttons[4])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "sqrt";
		displayresult();
	}
	if(e.getSource() == buttons[5])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "sin";
		displayresult();
	}
	if(e.getSource() == buttons[6])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "max";
		aField.setText("");
	}
	if(e.getSource() == buttons[7])
	{
		temp[0] = Double.parseDouble(aField.getText());
		operation = "min";
		aField.setText("");
	}
	if(e.getSource() == buttons[8])
	{
		displayresult();
	}
}

//Takes two doubles and add them
public void addUp(double x,double y)
{
	result = x+y;
}

//Takes two double and subtracts them
public void subtract(double x, double y)
{
	result= x-y;
}

//This takes two double and multiplies them
public void multiply(double x, double y)
{
	result = x*y;
}

//This takes two doubles and divides them
public void divide(double x, double y)
{
	result = x/y;
}

//This takes a double and takes the square root 
public void sqrt(double x)
{
	result = Math.sqrt(x);
}

//This takes a double and takes the sine
public void sine(double x)
{
	result = Math.sin(Math.toRadians(x));
}

//This takes two doubles and finds the max
public void max(double x, double y)
{
	result = Math.max(x,y);
}

//This takes two doubles and finds the min
public void min(double x, double y)
{
	result = Math.min(x,y);
}

//To display the single text field with a zero
public void display()
{
	Double adouble =a;
	aField.setText(adouble.toString());
}

/*This gets the second number entered after the
* button press. Then the respective operation is carried out based
* on the value of the  operation value. After the operation is
* carried out then display result*/
public void displayresult()
{
	Double rdouble;
	temp[1] = Double.parseDouble(aField.getText());
	if(operation == "+")
	{
		addUp(temp[0],temp[1]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
	if(operation == "-")
	{
		subtract(temp[0],temp[1]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
	if(operation == "*")
	{
		multiply(temp[0],temp[1]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
	if(operation == "/")
	{
		divide(temp[0],temp[1]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
	if(operation == "sqrt")
	{
		sqrt(temp[0]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
	if(operation == "sin")
	{
		sine(temp[0]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
	if(operation == "max")
	{
		max(temp[0],temp[1]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
	if(operation == "min")
	{
		min(temp[0],temp[1]);
		rdouble = result;
		aField.setText(rdouble.toString());
	}
}
		
}

