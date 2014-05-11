/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 3				PART 1 Point2D
 */

public class Point2D
{
	private int x;
	private int y;
	
	//This Constructor sets x and y values to 0
	public Point2D()
	{
		x = 0;
		y = 0;
	}
	
	//This constructor recieves two intergers and sets them to x and y respectively 
	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//Mutator for the varible x
	public void setX(int theX)
	{
		x = theX;
	}
	
	//Mutator for the varible y
	public void setY(int theY)
	{
		y = theY;
	}

	//Accessor for the varible x
	public int getX()
	{
		return x;
	}

	//Accessor for the varible y
	public int getY()
	{
		return y;
	}
	
	/*This method converts x and y into a co-ordinate format and returns
	 *as a String */
	public String toString()
	{
		String position;
		position = ("(" + getX() + "," + getY() + ")");
		return position;
	}
	
	/*This method recieves a point2d ojbject to be compared
	 *and then returns a number*/
	public int compareTo(Point2D point2D)
	{
		if(this.x == point2D.getX() && this.y == point2D.getY())
			return 0;
		else
			return -1;
	}

	//This main method will perform a unit test of Point2D
	public static void main(String [] args)
	{
		Point2D obj1 = new Point2D(9,5);
		Point2D obj2 = new Point2D(4,6);
		
		//Print x and y values that the Objects' passed to constructor, using get methods and toString method
		System.out.println("Object 1 x and y values: x = " + obj1.getX() + " y = " + obj1.getY());
		System.out.println("Object 1 x and y values as a co-ordinate: " + obj1.toString());
		System.out.println("Object 2 x and y values: x = " + obj2.getX() + " y = " + obj2.getY());
		System.out.println("Object 2 x and y values as a co-ordinate: " + obj2.toString());
		
		
		// Use compareto mehtod to check if the two objects are the same
		if(obj1.compareTo(obj2) == 0)
		{
			System.out.println("The two objects have the same co-ordinates");
		}
		else
		{
			System.out.println("The two objects have different co-ordinates");
			
		}
		
		//Change values of x and y for each object using setMethods and display new values
		obj1.setX(7);
		obj1.setY(2);
		obj2.setX(7);
		obj2.setY(2);
		
		System.out.println("");
		System.out.println("Object1 updated x and y values: x = " + obj1.getX() + " y = " + obj1.getY());
		System.out.println("Object 1 x and y values as a co-ordinate: " + obj1.toString());
		System.out.println("Object2 updated x and y values: x = " + obj2.getX() + " y = " + obj2.getY());
		System.out.println("Object 2 x and y values as a co-ordinate: " + obj2.toString());
		
		// Use compareto mehtod to check if the two objects are the same
		if(obj1.compareTo(obj2) == 0)
		{
			System.out.println("The two objects have the same co-ordinates");
		}
		else
		{
			System.out.println("The two objects have different co-ordinates");
			
		}	
	}
		
}
