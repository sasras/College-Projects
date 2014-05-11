/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 6				ChatterServer
 */
 /*ChatterServer always replys name of author and port number
  *when Client talks to it*/
import java.io.*;
import java.net.*;

public class ChatterServer
{

	public static void main(String [] args) throws Exception
	{
		ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		while(true)
		{
			System.err.println("Waiting for a client");
			Socket clientSocket = serverSocket.accept();
		
			System.out.println("Connection requested from: " + clientSocket.getLocalAddress());
		
			PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader fromClient = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
			toClient.println("Watcha want?");
			String incoming = fromClient.readLine();
			while(incoming != null)
			{
				if(incoming.contains("...")) // If Client Message contains "..."
				{
					System.out.println(incoming.substring(0,(incoming.length()-3))); //Print the message	
					incoming = fromClient.readLine(); //And Keep reading fromclient
				}	
				else
				{
					System.out.println(incoming);
					String myReply;	
					myReply = "Shawn Singh..."; //Reply name
					while(myReply.contains("...")) //Check to see if server reply has "..."
					{
						toClient.println(myReply);
						myReply = ""+serverSocket.getLocalPort();	
					}
					myReply = ""+serverSocket.getLocalPort(); //Reply Port
					toClient.println(myReply);
					incoming = fromClient.readLine();
				}	
			}
		}	
	}
	final static int SERVER_PORT = 10124; // My port
}
