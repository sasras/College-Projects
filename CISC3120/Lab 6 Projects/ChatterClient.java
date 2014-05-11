/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 6				ChatterClient
 */
 /*ChatterClient is always talking to server*/
import java.io.*;
import java.net.*;

public class ChatterClient
{
	public static void main(String [] args) throws Exception
	{
		Socket serverSocket = new Socket(args[0],SERVER_PORT);
		
		PrintWriter toServer = new PrintWriter(serverSocket.getOutputStream(), true);
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		String incoming = fromServer.readLine();
		
		while(incoming != null)
		{
			if(incoming.contains("..."))  //If Server Message contains "..."
			{
				System.out.println(incoming.substring(0,(incoming.length()-3)));//Print message
				incoming = fromServer.readLine();//And Keep reading from server
			}
			else
			{
				System.out.println(incoming);
				System.out.print("Your Turn> ");
				String myReply;
				myReply = keyboard.readLine();
				while(myReply.contains("..."))//Check to see if server reply has "..."
				{
					toServer.println(myReply);
					System.out.print("Your Turn> ");
					myReply = keyboard.readLine();	
				}
				toServer.println(myReply);
				incoming = fromServer.readLine();
			}
		}
	}
	final static int SERVER_PORT = 10124;
}