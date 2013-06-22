package com.example.soundsurround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCreator {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    
	public ServerCreator() {
		
        try {
            serverSocket = new ServerSocket(0,0,InetAddress.getByName("192.168.1.8"));  //Server socket
 
        } catch (IOException e) {
            System.out.println("Could not listen on port: 4444");
        }
        
        if (serverSocket == null)
        	System.err.println("fuckin a");
 
        System.out.println("Server started. Listening to the port 4444");
	}
	
	public String listen() {
		String message = "";
	    try {
	        clientSocket = serverSocket.accept();   //accept the client connection
		    inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
		    bufferedReader = new BufferedReader(inputStreamReader); //get the client message
            message = bufferedReader.readLine();
 
            System.out.println(message);
            inputStreamReader.close();
            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Problem in message reading");
	    }
	    return message;
	}
	
}