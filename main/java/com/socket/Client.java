package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	static String tempIn;
	static String readLine;
	public static void main(String [] args) {
		try {
			byte ipAddressTemp[] = {127, 0, 0, 1};
	        InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);
			Socket socket = new Socket(ipAddress,10003);
			BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
	        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
	        while(readLine !="bye") {
	        	//outTemp = readline;
	        	 tempIn = socketIn.readLine();	             
	             //System.out.println(client + outTemp);
	             System.out.println("server" + "\n" + tempIn);
	        	System.out.println("client:");
	        	readLine = systemIn.readLine();
	        	socketOut.println(readLine);
	        	 socketOut.flush();
	        	 
	        }
	        systemIn.close();
	        socketIn.close();
	        socketOut.close();
	        socket.close();
	        
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
