/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 5				Modification of WebCat
 */
import java.net.*;
import java.io.*;

public class WebCat 
{
	/*This mehtod recieves a URL, in order to connect to it's server
	 *to read the data from that URL as well as printit.*/
	public static void connection(URL theUrl)
	{
		try
		{
			InputStream is = theUrl.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String theLine;
			while((theLine = br.readLine()) != null)
			{
				System.out.println(theLine);
			}
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}	
	}
	
	
	public static void main(String [] args)
	{
		for(int i = 0; i < args.length; i++)
		{
			try
			{
				URL u = new URL(args[i]); //This assumes that protocol and a necessary full URL has been typed
				connection(u);
			}
			catch(MalformedURLException ex)
			{
				try
				{
					String input = new String (args[i]); // To input as String
					if(input.contains("ftp.")== true) //Check if URL input string contains ftp.
					{
						URL u = new URL("ftp://" + args[i]); //Set protocol to ftp
						connection(u);
					}
					else
					{
						URL u	= new URL("http","www." + args[i] + ".com",""); // Only a word for a URL is typed
						InputStream is = u.openStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader br = new BufferedReader(isr);
						String theLine;
						while((theLine = br.readLine()) != null)
						{
							System.out.println(theLine);
						}
					}	
					
				}
				catch(MalformedURLException ex2)
				{
					System.err.println(ex2);
				}
				catch(IOException et1) // Didn't call Connection method because needed to catch the IOException
				{
					try
					{
						URL u = new URL("http://" + args[i]); //To deal with URL typed without a protocol.
						connection(u);
					}
					catch(MalformedURLException ex3)
					{
						System.err.println(ex3);
					}
				}
			}
		}
	}
}
