/** SHAWN SINGH			SRING 2014
 *	CISC 3120-TR2		PROF. LI		
 *  Lab 6				ChatterServer
 */
 /*ChatterServer always replys name of author and port number
  *when Client talks to it*/
import java.io.*;
import java.net.*;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.io.File;

public class ChatterServer
{

	public static void main(String [] args) throws Exception
	{
		Logger mylogger = Logger.getLogger("ChatterLog");
		FileHandler theHandler;
		
		try
		{
			theHandler= new FileHandler("ChatterLog.log");
			mylogger.addHandler(theHandler);
			SimpleFormatter theFormatter = new SimpleFormatter();
			theHandler.setFormatter(theFormatter);
		}
		catch(SecurityException se)
		{
			se.printStackTrace();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
		ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		while(true)
		{
			mylogger.info("Waiting for a client");
			Socket clientSocket = serverSocket.accept();
		
			System.out.println("Connection requested from: " + clientSocket.getLocalAddress());
		
			PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader fromClient = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
			toClient.println("Watcha want?");
			String incoming = fromClient.readLine();
			while(incoming != null)
			{
				if(incoming.endsWith("..."))
				{
					mylogger.info("Client> " + incoming);
				}
				else
				{
					mylogger.info("Client> " + incoming);
					String myReply;	
					myReply = "Shawn Singh...";
					while(myReply.contains("..."))
					{
						toClient.println(myReply);
						mylogger.info("Server> Shawn Singh...");
						myReply = ""+serverSocket.getLocalPort();
						mylogger.info("Server> " + serverSocket.getLocalPort());
					}
					myReply = ""+serverSocket.getLocalPort();
					toClient.println(myReply);	
				}
				incoming = fromClient.readLine();
							try
			{
				File afile = new File("/home/ssingh/ChatterLog.log");
				afile.renameTo(new File("/home/ssingh/public_html/" +afile.getName()));
			}
			catch(Exception e)	
			{
			e.printStackTrace();
			}	
			}
		}
	}
	final static int SERVER_PORT = 10124;
}
