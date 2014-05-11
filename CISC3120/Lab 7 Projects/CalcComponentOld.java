
import java.awt.*; // Use the awt library
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*; // Use the swing library
import java.util.Random; // Get random numbers
import java.lang.Number.*;

public class CalcComponentOld extends JComponent implements ActionListener
{
	double a = 0;
	double b;
	double result = 0;
	JButton buttons[];
	
	JTextField aField;
	JTextField bField;
	JTextField rField;
	
	Random randomGenerator = new Random();
	
	public CalcComponentOld()
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
		buttons[8] = new JButton("Reset!");
		
		for(int i = 0; i<9; i++)
		{
			add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		
		aField = new JTextField();
		aField.setColumns(3);
		add(aField);
		rField = new JTextField();
		rField.setColumns(3);
		add(rField);
		bField = new JTextField();
		bField.setColumns(3);
		add(bField);
		
		display();
	}
	
public void actionPerformed(ActionEvent e)
{
	String aString = aField.getText();
	Double aDob = new Double(aString);
	a = aDob.doubleValue();
	
	if(e.getSource() == buttons[0])
	{
		addUp(a,b);
	}
	
	if(e.getSource() == buttons[1])
	{
		subtract(a,b);
	}
	
	if(e.getSource() == buttons[2])
	{
		multiply(a,b);
	}
	if(e.getSource() == buttons[3])
	{
		divide(a,b);
	}
	if(e.getSource() == buttons[4])
	{
		sqrt(a);
	}
	if(e.getSource() == buttons[5])
	{
		sine(a);
	}
	if(e.getSource() == buttons[6])
	{
		max(a,b);
	}
	if(e.getSource() == buttons[7])
	{
		min(a,b);
	}
	if(e.getSource() == buttons[8])
	{
		a = 0;
		b = randomGenerator.nextDouble()*10;
		result = 0;
	}
	display();
}

public void addUp(double x, double y)
{
	result = x+y;
}

public void subtract(double x, double y)
{
	result= x-y;
}

public void multiply(double x, double y)
{
	result = x*y;
}

public void divide(double x, double y)
{
	result = x/y;
}
public void sqrt(double x)
{
	result = Math.sqrt(x);
}
public void sine(double x)
{
	result = Math.sin(Math.toRadians(x));
}
public void max(double x, double y)
{
	result = Math.max(x,y);
}
public void min(double x, double y)
{
	result = Math.min(x,y);
}


public void display()
{
	Double adouble =a;
	aField.setText(adouble.toString());
	Double bdouble = b;
	bField.setText(bdouble.toString());
	Double rdouble = result;
	rField.setText(rdouble.toString());
}


	
		
}

